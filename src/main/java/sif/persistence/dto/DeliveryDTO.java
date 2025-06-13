package sif.persistence.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DeliveryDTO {

    private Long id;
    private Long addressingId;
    private String codSerTecEntregado;
    private Integer cantTotEntregada;
    private Integer entTotal;
    private Integer causaNoEntrega;
    private Date fecEntrega;
    private String noLote;
    private String tipoIdRecibe;
    private String noIdRecibe;
    private Integer estEntrega;
    private String codigosEntrega;
    private LocalDateTime fecAnulacion;

}
