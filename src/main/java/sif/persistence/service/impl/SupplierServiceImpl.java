package sif.persistence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sif.persistence.dto.SupplierDTO;
import sif.persistence.entity.Supplier;
import sif.persistence.repository.SupplierRepository;
import sif.persistence.service.SupplierService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    @Override
    public SupplierDTO create(SupplierDTO dto) {
        Supplier entity = toEntity(dto);
        return toDTO(repository.save(entity));
    }

    @Override
    public SupplierDTO getById(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<SupplierDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public SupplierDTO update(Long id, SupplierDTO dto) {
        Optional<Supplier> existing = repository.findById(id);
        if (existing.isPresent()) {
            Supplier entity = toEntity(dto);
            entity.setId(id);
            return toDTO(repository.save(entity));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SupplierDTO toDTO(Supplier entity) {
        SupplierDTO dto = new SupplierDTO();
        dto.setId(entity.getId());
        dto.setTipoIdProv(entity.getTipoIdProv());
        dto.setNoIdProv(entity.getNoIdProv());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setStatus(entity.getStatus());
        dto.setDateCreated(entity.getDateCreated());
        dto.setDateUpdated(entity.getDateUpdated());
        return dto;
    }

    private Supplier toEntity(SupplierDTO dto) {
        Supplier entity = new Supplier();
        entity.setId(dto.getId());
        entity.setTipoIdProv(dto.getTipoIdProv());
        entity.setNoIdProv(dto.getNoIdProv());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setStatus(dto.getStatus());
        entity.setDateCreated(dto.getDateCreated());
        entity.setDateUpdated(dto.getDateUpdated());
        return entity;
    }
}
