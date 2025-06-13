package sif.persistence.service;

import sif.persistence.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO create(SupplierDTO dto);
    SupplierDTO getById(Long id);
    List<SupplierDTO> getAll();
    SupplierDTO update(Long id, SupplierDTO dto);
    void delete(Long id);
}
