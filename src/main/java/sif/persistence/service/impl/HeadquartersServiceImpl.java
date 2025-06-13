package sif.persistence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sif.persistence.dto.HeadquartersDTO;
import sif.persistence.entity.Headquarters;
import sif.persistence.repository.HeadquartersRepository;
import sif.persistence.service.HeadquartersService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeadquartersServiceImpl implements HeadquartersService {

    private final HeadquartersRepository repository;

    @Override
    public HeadquartersDTO create(HeadquartersDTO dto) {
        Headquarters entity = toEntity(dto);
        return toDTO(repository.save(entity));
    }

    @Override
    public HeadquartersDTO getById(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<HeadquartersDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public HeadquartersDTO update(Long id, HeadquartersDTO dto) {
        Optional<Headquarters> existing = repository.findById(id);
        if (existing.isPresent()) {
            Headquarters entity = toEntity(dto);
            entity.setId(id);
            return toDTO(repository.save(entity));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private HeadquartersDTO toDTO(Headquarters entity) {
        HeadquartersDTO dto = new HeadquartersDTO();
        dto.setId(entity.getId());
        dto.setSupplierId(entity.getSupplierId());
        dto.setCodMunicipality(entity.getCodMunicipality());
        dto.setCodSedeProv(entity.getCodSedeProv());
        dto.setStatus(entity.getStatus());
        dto.setDateCreated(entity.getDateCreated());
        dto.setDateUpdated(entity.getDateUpdated());
        return dto;
    }

    private Headquarters toEntity(HeadquartersDTO dto) {
        Headquarters entity = new Headquarters();
        entity.setId(dto.getId());
        entity.setSupplierId(dto.getSupplierId());
        entity.setCodMunicipality(dto.getCodMunicipality());
        entity.setCodSedeProv(dto.getCodSedeProv());
        entity.setStatus(dto.getStatus());
        entity.setDateCreated(dto.getDateCreated());
        entity.setDateUpdated(dto.getDateUpdated());
        return entity;
    }
}
