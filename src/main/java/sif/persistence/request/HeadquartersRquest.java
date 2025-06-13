package sif.persistence.request;

import lombok.Data;

@Data
public class HeadquartersRquest {

    private Long id;
    private Long supplierId;
    private Integer codMunicipality;
    private String codSedeProv;
    private Integer status;

}
