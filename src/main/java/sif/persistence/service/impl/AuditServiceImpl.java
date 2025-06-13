package sif.persistence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sif.persistence.dto.AuditDTO;
import sif.persistence.entity.Audit;
import sif.persistence.repository.AuditRepository;
import sif.persistence.service.AuditService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    @Override
    public AuditDTO create(AuditDTO dto) {
        Audit audit = new Audit();
        audit.setModuleId(dto.getModuleId());
        audit.setUserId(dto.getUserId());
        audit.setEvent(dto.getEvent());
        audit.setMetadata(dto.getMetadata());

        Audit saved = auditRepository.save(audit);
        return toDTO(saved);
    }

    @Override
    public AuditDTO getById(Long id) {
        return auditRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public List<AuditDTO> getAll() {
        return auditRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        auditRepository.deleteById(id);
    }

    private AuditDTO toDTO(Audit audit) {
        AuditDTO dto = new AuditDTO();
        dto.setId(audit.getId());
        dto.setModuleId(audit.getModuleId());
        dto.setUserId(audit.getUserId());
        dto.setDate(audit.getDate());
        dto.setEvent(audit.getEvent());
        dto.setMetadata(audit.getMetadata());
        return dto;
    }
}
