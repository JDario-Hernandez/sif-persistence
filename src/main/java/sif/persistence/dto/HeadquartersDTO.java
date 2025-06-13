package sif.persistence.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HeadquartersDTO {
    private Long id;
    private Long supplierId;
    private Integer codMunicipality;
    private String codSedeProv;
    private Integer status;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
