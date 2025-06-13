package sif.persistence.request;

import lombok.Data;

import java.util.Date;

@Data
public class AddressingRequest {

    private Long id;
    private Long idDireccionamiento;
    private String noPrescripcion;
    private String tipoTec;
    private Integer conTec;
    private String tipoIdPaciente;
    private String noIdPaciente;
    private Integer noEntrega;
    private Integer noSubEntrega;
    private String tipoIdProv;
    private String noIdSedeProv;
    private Long codMunEnt;
    private Date fecMaxEnt;
    private Integer cantTotAEntregar;
    private String dirPaciente;
    private String codSerTecAEntregar;
    private String noIdEPS;
    private String codEPS;
    private Date fecDireccionamiento;
    private Integer estDireccionamiento;

}
