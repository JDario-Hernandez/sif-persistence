package sif.persistence.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sif.persistence.dto.UserDTO;
import sif.persistence.entity.User;
import sif.persistence.repository.UserRepository;
import sif.persistence.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserDTO create(UserDTO dto) {
        User entity = toEntity(dto);
        return toDTO(repository.save(entity));
    }

    @Override
    public UserDTO getById(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<UserDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        Optional<User> existing = repository.findById(id);
        if (existing.isPresent()) {
            User entity = toEntity(dto);
            entity.setId(id);
            return toDTO(repository.save(entity));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private UserDTO toDTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setSupplierId(entity.getSupplierId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setStatus(entity.getStatus());
        dto.setRole(entity.getRole());
        dto.setEmail(entity.getEmail());
        dto.setContact(entity.getContact());
        dto.setDateCreated(entity.getDateCreated());
        dto.setDateUpdated(entity.getDateUpdated());
        dto.setDateLastLogin(entity.getDateLastLogin());
        return dto;
    }

    private User toEntity(UserDTO dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setSupplierId(dto.getSupplierId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setStatus(dto.getStatus());
        entity.setRole(dto.getRole());
        entity.setEmail(dto.getEmail());
        entity.setContact(dto.getContact());
        entity.setDateCreated(dto.getDateCreated());
        entity.setDateUpdated(dto.getDateUpdated());
        entity.setDateLastLogin(dto.getDateLastLogin());
        return entity;
    }
}
