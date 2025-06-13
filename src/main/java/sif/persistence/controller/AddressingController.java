package sif.persistence.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sif.persistence.dto.AddressingDTO;
import sif.persistence.service.AddressingService;

import java.util.List;

@RestController
@RequestMapping("/api/addressing")
public class AddressingController {

    private final AddressingService addressingService;

    public AddressingController(AddressingService addressingService) {
        this.addressingService = addressingService;
    }
    @PostMapping
    public ResponseEntity<AddressingDTO> create(@RequestBody AddressingDTO dto) {
        return ResponseEntity.ok(addressingService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressingDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(addressingService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressingDTO>> getAll() {
        return ResponseEntity.ok(addressingService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressingDTO> update(@PathVariable Long id, @RequestBody AddressingDTO dto) {
        return ResponseEntity.ok(addressingService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
