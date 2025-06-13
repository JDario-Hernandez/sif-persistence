package sif.persistence.service;

import sif.persistence.dto.DeliveryDTO;

import java.util.List;

public interface DeliveryService {
    DeliveryDTO create(DeliveryDTO dto);
    DeliveryDTO getById(Long id);
    List<DeliveryDTO> getAll();
    DeliveryDTO update(Long id, DeliveryDTO dto);
    void delete(Long id);
}
