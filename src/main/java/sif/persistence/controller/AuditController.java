package sif.persistence.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sif.persistence.dto.AuditDTO;
import sif.persistence.service.AuditService;

import java.util.List;

@RestController
@RequestMapping("/api/audits")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping
    public ResponseEntity<AuditDTO> create(@RequestBody AuditDTO dto) {
        return ResponseEntity.ok(auditService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditDTO> getById(@PathVariable Long id) {
        AuditDTO dto = auditService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AuditDTO>> getAll() {
        return ResponseEntity.ok(auditService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        auditService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
