package sif.persistence.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sif.persistence.dto.DeliveryDTO;
import sif.persistence.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


    @PostMapping
    public ResponseEntity<DeliveryDTO> create(@RequestBody DeliveryDTO dto) {
        return ResponseEntity.ok(deliveryService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDTO> getById(@PathVariable Long id) {
        DeliveryDTO dto = deliveryService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DeliveryDTO>> getAll() {
        return ResponseEntity.ok(deliveryService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDTO> update(@PathVariable Long id, @RequestBody DeliveryDTO dto) {
        DeliveryDTO updated = deliveryService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deliveryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
