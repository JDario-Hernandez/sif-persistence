package sif.persistence.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class ProgramingDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("codSedeProv")
    private String codSedeProv;

    @JsonProperty("addressingId")
    private Long addressingId;

    @JsonProperty("noIdSedeProv")
    private String noIdSedeProv;

    @JsonProperty("tipoIdSedeProv")
    private String tipoIdSedeProv;

    @JsonProperty("codSerTecAEntregar")
    private String codSerTecAEntregar;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("fecProgramacion")
    private Date fecProgramacion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("fecAnulacion")
    private Date fecAnulacion;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("fecMaxEnt")
    private String fecMaxEnt;

    @JsonProperty("estProgramacion")
    private Integer estProgramacion;

    @JsonProperty("cantTotAEntregar")
    private int cantTotAEntregar;
}