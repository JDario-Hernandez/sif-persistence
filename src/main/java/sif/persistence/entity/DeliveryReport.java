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
public class DeliveryReport {
    @Id
    @Column(name = "ID")
    private Long id;

    private Long addressingId;

    @Column(name = "EstadoEntrega")
    private Integer estadoEntrega;

    @Column(name = "ValorEntregado")
    private String valorEntregado;

    @Column(name = "FecRepEntrega")
    private Date fecRepEntrega;

    @Column(name = "EstRepEntrega")
    private Integer estRepEntrega;

    @Column(name = "FecAnulacion", nullable = true)
    private LocalDateTime fecAnulacion;

    @PrePersist
    protected void onCreate() {
        this.fecRepEntrega = new Date();
        if (estRepEntrega == null) {
            estRepEntrega = 1;
        }
    }


}
