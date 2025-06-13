package sif.persistence.request;

import lombok.Data;

@Data
public class UserRequest {

    private Long supplierId;
    private String username;
    private String password;
    private String role;
    private String email;
    private String contact;

}
