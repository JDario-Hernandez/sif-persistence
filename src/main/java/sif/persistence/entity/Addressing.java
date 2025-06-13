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
public class Addressing {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "IDDireccionamiento")
    private Long idDireccionamiento;

    @Column(name = "NoPrescripcion")
    private String noPrescripcion;

    @Column(name = "TipoTec")
    private String tipoTec;

    @Column(name = "ConTec")
    private Integer conTec;

    @Column(name = "TipoIDPaciente")
    private String tipoIdPaciente;

    @Column(name = "NoIDPaciente")
    private String noIdPaciente;

    @Column(name = "NoEntrega")
    private Integer NoEntrega;

    @Column(name = "NoSubEntrega")
    private Integer noSubEntrega;

    @Column(name = "TipoIDProv")
    private String tipoIdProv;

    @Column(name = "NoIDProv")
    private String noIdProv;

    @Column(name = "CodMunEnt")
    private String codMunEnt;

    @Column(name = "FecMaxEnt")
    private LocalDate fecMaxEnt;

    @Column(name = "CantTotAEntregar")
    private Integer cantTotAEntregar;

    @Column(name = "DirPaciente")
    private String dirPaciente;

    @Column(name = "CodSerTecAEntregar")
    private String codSerTecAEntregar;

    @Column(name = "NoIDEPS")
    private String noIdEPS;

    @Column(name = "CodEPS")
    private String codEPS;

    @Column(name = "FecDireccionamiento")
    private Date fecDireccionamiento;

    @Column(name = "EstDireccionamiento")
    private Integer estDireccionamiento;

    @Column(name = "FecAnulacion", nullable = true)
    private Date fecAnulacion;

    @Column(name = "Status", nullable = true)
    private String status;

    @PrePersist
    protected void onCreate() {
        if (estDireccionamiento == null) {
            estDireccionamiento = 1;
        }
        if (estDireccionamiento == 1) {
            status = "DIRECCIONADO";
        } else if (estDireccionamiento == 2) {
            status = "PROGRAMADO";
        } else {
            status = "DIRECCIONAMIENTO_ANULADO";
        }
    }
}
