package sif.persistence.request;

import lombok.Data;

@Data
public class SupplierRquest {

    private Long id;
    private String tipoIdProv;
    private String noIdProv;
    private String name;
    private String address;
    private Integer status;

}
