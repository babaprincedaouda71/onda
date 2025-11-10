package com.example.onda.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PvtResultDto {
    private Long pvtId;
    private Long sessionId; // ID de la session de travail
    private LocalDateTime testTimestamp;
    private Integer avgReactionTimeMs;
    private Integer lapseCount;
}