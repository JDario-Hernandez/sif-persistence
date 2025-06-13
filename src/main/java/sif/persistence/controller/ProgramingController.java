package sif.persistence.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sif.persistence.dto.ProgramingDTO;
import sif.persistence.service.ProgramingService;

import java.util.List;

@RestController
@RequestMapping("/api/programings")
public class ProgramingController {

    private final ProgramingService programingService;

    public ProgramingController(ProgramingService programingService) {
        this.programingService = programingService;
    }

    @PostMapping
    public ResponseEntity<ProgramingDTO> create(@RequestBody ProgramingDTO dto) {
        return ResponseEntity.ok(programingService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramingDTO> getById(@PathVariable Long id) {
        ProgramingDTO dto = programingService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ProgramingDTO>> getAll() {
        return ResponseEntity.ok(programingService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramingDTO> update(@PathVariable Long id, @RequestBody ProgramingDTO dto) {
        ProgramingDTO updated = programingService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        programingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
