package sif.persistence.service;

import sif.persistence.dto.AddressingDTO;

import java.util.List;

public interface AddressingService {

    AddressingDTO create(AddressingDTO dto);
    List<AddressingDTO> createAll(List<AddressingDTO> dtos);
    AddressingDTO getById(Long id);
    List<AddressingDTO> getAll();
    AddressingDTO update(Long id, AddressingDTO dto);
    void delete(Long id);
}
