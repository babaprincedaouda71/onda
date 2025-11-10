package com.example.onda.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
public class WorkSessionDto {
    private Long sessionId;
    private Long userId; // ID de l'utilisateur
    private LocalDateTime startTimestamp;
    private LocalDateTime endTimestamp;
    private BigDecimal plannedShiftDurationHrs;
    private Integer consecutiveWorkDays;
    private Integer breaksTakenCount;
    private Set<MeasurementDto> measurements;
    private Set<PvtResultDto> pvtResults;
}