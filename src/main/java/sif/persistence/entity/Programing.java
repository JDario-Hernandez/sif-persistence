package sif.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Programing {
    @Id
    private Long id;

    private Long addressingId;

    @Column(name = "FecMaxEnt")
    private LocalDate fecMaxEnt;

    @Column(name = "TipoIDSedeProv")
    private String tipoIdSedeProv;

    @Column(name = "NoIDSedeProv")
    private String NoIdSedeProv;

    @Column(name = "CodSedeProv")
    private String codSedeProv;

    @Column(name = "CodSerTecAEntregar")
    private String codSerTecAEntregar;

    @Column(name = "CantTotAEntregar")
    private Integer cantTotAEntregar;

    @Column(name = "FecProgramacion")
    private Date fecProgramacion;

    @Column(name = "EstProgramacion")
    private Integer estProgramacion;

    @Column(name = "FecAnulacion", nullable = true)
    private Date fecAnulacion;

    @PrePersist
    protected void onCreate() {
        if (fecProgramacion == null) {
            this.fecProgramacion = new Date();
        }
        if (estProgramacion == null) {
            estProgramacion = 1;
        }
    }
}
