package sif.persistence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sif.persistence.dto.DeliveryReportDTO;
import sif.persistence.entity.DeliveryReport;
import sif.persistence.repository.DeliveryReportRepository;
import sif.persistence.service.DeliveryReportService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryReportServiceImpl implements DeliveryReportService {

    private final DeliveryReportRepository repository;

    @Override
    public DeliveryReportDTO create(DeliveryReportDTO dto) {
        DeliveryReport entity = toEntity(dto);
        return toDTO(repository.save(entity));
    }

    @Override
    public DeliveryReportDTO getById(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<DeliveryReportDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public DeliveryReportDTO update(Long id, DeliveryReportDTO dto) {
        Optional<DeliveryReport> existing = repository.findById(id);
        if (existing.isPresent()) {
            DeliveryReport entity = toEntity(dto);
            entity.setId(id);
            return toDTO(repository.save(entity));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private DeliveryReportDTO toDTO(DeliveryReport entity) {
        DeliveryReportDTO dto = new DeliveryReportDTO();
        dto.setId(entity.getId());
        dto.setAddressingId(entity.getAddressingId());
        dto.setEstadoEntrega(entity.getEstadoEntrega());
        dto.setValorEntregado(entity.getValorEntregado());
        dto.setFecRepEntrega(entity.getFecRepEntrega());
        dto.setEstRepEntrega(entity.getEstRepEntrega());
        dto.setFecAnulacion(entity.getFecAnulacion());
        return dto;
    }

    private DeliveryReport toEntity(DeliveryReportDTO dto) {
        DeliveryReport entity = new DeliveryReport();
        entity.setId(dto.getId());
        entity.setAddressingId(dto.getAddressingId());
        entity.setEstadoEntrega(dto.getEstadoEntrega());
        entity.setValorEntregado(dto.getValorEntregado());
        entity.setFecRepEntrega(dto.getFecRepEntrega());
        entity.setEstRepEntrega(dto.getEstRepEntrega());
        entity.setFecAnulacion(dto.getFecAnulacion());
        return entity;
    }
}
