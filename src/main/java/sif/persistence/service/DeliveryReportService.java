package sif.persistence.service;

import sif.persistence.dto.DeliveryReportDTO;

import java.util.List;

public interface DeliveryReportService {
    DeliveryReportDTO create(DeliveryReportDTO dto);
    DeliveryReportDTO getById(Long id);
    List<DeliveryReportDTO> getAll();
    DeliveryReportDTO update(Long id, DeliveryReportDTO dto);
    void delete(Long id);
}
