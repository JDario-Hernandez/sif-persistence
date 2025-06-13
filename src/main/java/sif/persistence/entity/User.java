package sif.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private Long supplierId;

    private String username;

    private String password;

    private Integer status;

    private String role;

    private String email;

    private String contact;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @Column(nullable = false)
    private LocalDateTime dateUpdated;

    private LocalDateTime dateLastLogin;

    @PrePersist
    protected void onCreate() {
        dateCreated = LocalDateTime.now();
        dateUpdated = LocalDateTime.now();
        if(status == null){
            status = 1;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        dateUpdated = LocalDateTime.now();
    }

}
