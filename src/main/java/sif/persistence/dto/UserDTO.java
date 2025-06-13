package sif.persistence.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Long id;
    private Long supplierId;
    private String username;
    private String password;
    private Integer status;
    private String role;
    private String email;
    private String contact;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private LocalDateTime dateLastLogin;

}
