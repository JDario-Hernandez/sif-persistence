package sif.persistence.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sif.persistence.dto.HeadquartersDTO;
import sif.persistence.service.HeadquartersService;

import java.util.List;

@RestController
@RequestMapping("/api/headquarters")
public class HeadquartersController {

    private final HeadquartersService headquartersService;

    public HeadquartersController(HeadquartersService headquartersService) {
        this.headquartersService = headquartersService;
    }


    @PostMapping
    public ResponseEntity<HeadquartersDTO> create(@RequestBody HeadquartersDTO dto) {
        return ResponseEntity.ok(headquartersService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeadquartersDTO> getById(@PathVariable Long id) {
        HeadquartersDTO dto = headquartersService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<HeadquartersDTO>> getAll() {
        return ResponseEntity.ok(headquartersService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeadquartersDTO> update(@PathVariable Long id, @RequestBody HeadquartersDTO dto) {
        HeadquartersDTO updated = headquartersService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        headquartersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
