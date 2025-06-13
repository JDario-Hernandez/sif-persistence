package sif.persistence.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private Long moduleId;

    private Long userId;

    private LocalDateTime date;

    private String event;

    @Column(columnDefinition = "LONGTEXT")
    private String metadataJson;

    @Transient
    private Map<String, Object> metadata = new HashMap<>();

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
        try {
            this.metadataJson = new ObjectMapper().writeValueAsString(metadata);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> getMetadata() {
        if (metadataJson != null) {
            try {
                this.metadata = new ObjectMapper().readValue(metadataJson, new TypeReference<>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return metadata;
    }

    @PrePersist
    protected void onCreate() {
        date = LocalDateTime.now();
    }
}
