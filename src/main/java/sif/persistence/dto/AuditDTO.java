package sif.persistence.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class AuditDTO {
    private Long id;
    private Long moduleId;
    private Long userId;
    private LocalDateTime date;
    private String event;
    private Map<String, Object> metadata;
}
