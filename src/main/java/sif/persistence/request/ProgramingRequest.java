package sif.persistence.request;

import lombok.Data;

import java.util.Date;

@Data
public class ProgramingRequest {

    private Long id;
    private Long addressingId;
    private Date fecMaxEnt;
    private String tipoIdSedeProv;
    private String noIdSedeProv;
    private String codSedeProv;
    private String codSerTecAEntregar;
    private Integer cantTotAEntregar;
    private Integer estProgramacion;

}
