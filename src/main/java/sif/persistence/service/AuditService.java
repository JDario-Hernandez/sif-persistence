package sif.persistence.service;

import sif.persistence.dto.AuditDTO;

import java.util.List;

public interface AuditService {
    AuditDTO create(AuditDTO dto);
    AuditDTO getById(Long id);
    List<AuditDTO> getAll();
    void delete(Long id);
}
