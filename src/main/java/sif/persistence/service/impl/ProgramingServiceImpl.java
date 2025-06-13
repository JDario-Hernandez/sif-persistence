package sif.persistence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sif.persistence.dto.ProgramingDTO;
import sif.persistence.entity.Programing;
import sif.persistence.repository.ProgramingRepository;
import sif.persistence.service.ProgramingService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgramingServiceImpl implements ProgramingService {

    private final ProgramingRepository repository;

    @Override
    public ProgramingDTO create(ProgramingDTO dto) {
        Programing entity = toEntity(dto);
        return toDTO(repository.save(entity));
    }

    @Override
    public ProgramingDTO getById(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<ProgramingDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProgramingDTO update(Long id, ProgramingDTO dto) {
        Optional<Programing> existing = repository.findById(id);
        if (existing.isPresent()) {
            Programing entity = toEntity(dto);
            entity.setId(id);
            return toDTO(repository.save(entity));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ProgramingDTO toDTO(Programing entity) {
        ProgramingDTO dto = new ProgramingDTO();
        dto.setId(entity.getId());
        dto.setAddressingId(entity.getAddressingId());
        dto.setFecMaxEnt(entity.getFecMaxEnt().toString());
        dto.setTipoIdSedeProv(entity.getTipoIdSedeProv());
        dto.setNoIdSedeProv(entity.getNoIdSedeProv());
        dto.setCodSedeProv(entity.getCodSedeProv());
        dto.setCodSerTecAEntregar(entity.getCodSerTecAEntregar());
        dto.setCantTotAEntregar(entity.getCantTotAEntregar());
        dto.setFecProgramacion(entity.getFecProgramacion());
        dto.setEstProgramacion(entity.getEstProgramacion());
        dto.setFecAnulacion(entity.getFecAnulacion());
        return dto;
    }

    private Programing toEntity(ProgramingDTO dto) {

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate fecMaxEnt = LocalDate.parse(dto.getFecMaxEnt(), formatter1);

        Programing entity = new Programing();
        entity.setId(dto.getId());
        entity.setAddressingId(dto.getAddressingId());
        entity.setFecMaxEnt(fecMaxEnt);
        entity.setTipoIdSedeProv(dto.getTipoIdSedeProv());
        entity.setNoIdSedeProv(dto.getNoIdSedeProv());
        entity.setCodSedeProv(dto.getCodSedeProv());
        entity.setCodSerTecAEntregar(dto.getCodSerTecAEntregar());
        entity.setCantTotAEntregar(dto.getCantTotAEntregar());
        entity.setFecProgramacion(dto.getFecProgramacion());
        entity.setEstProgramacion(dto.getEstProgramacion());
        entity.setFecAnulacion(dto.getFecAnulacion());
        return entity;
    }

    private List<Programing> toEntityList(List<ProgramingDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    private List<ProgramingDTO> toDtoList(List<Programing> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
