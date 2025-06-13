package sif.persistence.service;

import sif.persistence.dto.ProgramingDTO;

import java.util.List;

public interface ProgramingService {
    ProgramingDTO create(ProgramingDTO dto);
    ProgramingDTO getById(Long id);
    List<ProgramingDTO> getAll();
    ProgramingDTO update(Long id, ProgramingDTO dto);
    void delete(Long id);
}
