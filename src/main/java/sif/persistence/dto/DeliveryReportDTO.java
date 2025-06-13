package sif.persistence.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DeliveryReportDTO {

    private Long id;
    private Long addressingId;
    private Integer estadoEntrega;
    private String valorEntregado;
    private Date fecRepEntrega;
    private Integer estRepEntrega;
    private LocalDateTime fecAnulacion;

}
