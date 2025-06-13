package sif.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Delivery {

    @Id
    @Column(name = "ID")
    private Long id;

    private Long addressingId;

    @Column(name = "CodSerTecEntregado")
    private String codSerTecEntregado;

    @Column(name = "CantTotEntregada")
    private Integer cantTotEntregada;

    @Column(name = "EntTotal")
    private Integer entTotal;

    @Column(name = "CausaNoEntrega")
    private Integer causaNoEntrega;

    @Column(name = "FecEntrega")
    private Date fecEntrega;

    @Column(name = "NoLote")
    private String noLote;

    @Column(name = "TipoIDRecibe")
    private String tipoIdRecibe;

    @Column(name = "NoIDRecibe")
    private String noIdRecibe;

    @Column(name = "EstEntrega")
    private Integer estEntrega;

    @Column(name = "FecAnulacion", nullable = true)
    private LocalDateTime fecAnulacion;

    @Column(name = "CodigosEntrega")
    private String codigosEntrega;

    @PrePersist
    protected void onCreate() {
        if (estEntrega == null) {
            estEntrega = 1;
        }
    }
}
