package sif.persistence.service;

import sif.persistence.dto.HeadquartersDTO;

import java.util.List;

public interface HeadquartersService {
    HeadquartersDTO create(HeadquartersDTO dto);
    HeadquartersDTO getById(Long id);
    List<HeadquartersDTO> getAll();
    HeadquartersDTO update(Long id, HeadquartersDTO dto);
    void delete(Long id);
}
