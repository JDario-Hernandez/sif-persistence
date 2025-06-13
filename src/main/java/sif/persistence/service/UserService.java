package sif.persistence.service;

import sif.persistence.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTO getById(Long id);
    List<UserDTO> getAll();
    UserDTO update(Long id, UserDTO dto);
    void delete(Long id);
}
