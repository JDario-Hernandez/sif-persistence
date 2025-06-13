package sif.persistence.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SupplierDTO {
    private Long id;
    private String tipoIdProv;
    private String noIdProv;
    private String name;
    private String address;
    private Integer status;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
