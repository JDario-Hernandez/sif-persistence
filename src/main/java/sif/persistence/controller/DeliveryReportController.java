package sif.persistence.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sif.persistence.dto.DeliveryReportDTO;
import sif.persistence.service.DeliveryReportService;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-reports")
public class DeliveryReportController {

    private final DeliveryReportService deliveryReportService;

    public DeliveryReportController(DeliveryReportService deliveryReportService) {
        this.deliveryReportService = deliveryReportService;
    }

    @PostMapping
    public ResponseEntity<DeliveryReportDTO> create(@RequestBody DeliveryReportDTO dto) {
        return ResponseEntity.ok(deliveryReportService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryReportDTO> getById(@PathVariable Long id) {
        DeliveryReportDTO dto = deliveryReportService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DeliveryReportDTO>> getAll() {
        return ResponseEntity.ok(deliveryReportService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryReportDTO> update(@PathVariable Long id, @RequestBody DeliveryReportDTO dto) {
        DeliveryReportDTO updated = deliveryReportService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deliveryReportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
