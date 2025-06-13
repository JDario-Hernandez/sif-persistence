package sif.persistence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sif.persistence.dto.AddressingDTO;
import sif.persistence.entity.Addressing;
import sif.persistence.repository.AddressingRepository;
import sif.persistence.service.AddressingService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressingServiceImpl implements AddressingService {

    @Autowired
    private AddressingRepository repository;

    @Override
    public AddressingDTO create(AddressingDTO dto) {
        Addressing saved = repository.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public List<AddressingDTO> createAll(List<AddressingDTO> dto) {
        List<Addressing> saved = repository.saveAll(toEntityList(dto));
        return toDtoList(saved);
    }

    @Override
    public AddressingDTO getById(Long id) {
        return repository.findById(id).map(this::toDTO)
                .orElse(null);
    }

    @Override
    public List<AddressingDTO> getAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressingDTO update(Long id, AddressingDTO dto) {
        Addressing existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Addressing not found"));
        Addressing updated = toEntity(dto);
        updated.setId(existing.getId()); // asegúrate de conservar el ID
        return toDTO(repository.save(updated));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    private List<Addressing> toEntityList(List<AddressingDTO> dtos) {
        if (dtos == null) {
            return null;
        }

        List<Addressing> saveds = dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());

        return saveds;
    }

    private List<AddressingDTO> toDtoList(List<Addressing> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private AddressingDTO toDTO(Addressing entity) {

        AddressingDTO dto = new AddressingDTO();
        dto.setId(entity.getId());
        dto.setIdDireccionamiento(entity.getIdDireccionamiento());
        dto.setNoPrescripcion(entity.getNoPrescripcion());
        dto.setTipoTec(entity.getTipoTec());
        dto.setConTec(entity.getConTec());
        dto.setTipoIdPaciente(entity.getTipoIdPaciente());
        dto.setNoIdPaciente(entity.getNoIdPaciente());
        dto.setNoEntrega(entity.getNoEntrega());
        dto.setNoSubEntrega(entity.getNoSubEntrega());
        dto.setTipoIdProv(entity.getTipoIdProv());
        dto.setNoIdProv(entity.getNoIdProv());
        dto.setCodMunEnt(entity.getCodMunEnt());
        dto.setFecMaxEnt(entity.getFecMaxEnt().toString());
        dto.setCantTotAEntregar(entity.getCantTotAEntregar());
        dto.setDirPaciente(entity.getDirPaciente());
        dto.setCodSerTecAEntregar(entity.getCodSerTecAEntregar());
        dto.setNoIdEPS(entity.getNoIdEPS());
        dto.setCodEPS(entity.getCodEPS());
        dto.setFecDireccionamiento(entity.getFecDireccionamiento());
        dto.setEstDireccionamiento(entity.getEstDireccionamiento());
        return dto;
    }

    private Addressing toEntity(AddressingDTO dto) {

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate fecMaxEnt = LocalDate.parse(dto.getFecMaxEnt(), formatter1);

        Addressing entity = new Addressing();
        entity.setId(dto.getId());
        entity.setIdDireccionamiento(dto.getIdDireccionamiento());
        entity.setNoPrescripcion(dto.getNoPrescripcion());
        entity.setTipoTec(dto.getTipoTec());
        entity.setConTec(dto.getConTec());
        entity.setTipoIdPaciente(dto.getTipoIdPaciente());
        entity.setNoIdPaciente(dto.getNoIdPaciente());
        entity.setNoEntrega(dto.getNoEntrega());
        entity.setNoSubEntrega(dto.getNoSubEntrega());
        entity.setTipoIdProv(dto.getTipoIdProv());
        entity.setNoIdProv(dto.getNoIdProv());
        entity.setCodMunEnt(dto.getCodMunEnt());
        entity.setFecMaxEnt(fecMaxEnt);
        entity.setCantTotAEntregar(dto.getCantTotAEntregar());
        entity.setDirPaciente(dto.getDirPaciente());
        entity.setCodSerTecAEntregar(dto.getCodSerTecAEntregar());
        entity.setNoIdEPS(dto.getNoIdEPS());
        entity.setCodEPS(dto.getCodEPS());
        entity.setFecDireccionamiento(dto.getFecDireccionamiento());
        entity.setEstDireccionamiento(dto.getEstDireccionamiento());
        return entity;
    }


}
