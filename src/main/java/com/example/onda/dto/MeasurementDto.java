package com.example.onda.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MeasurementDto {
    private Long measurementId;
    private Long userId;
    private LocalDateTime measurementTimestamp;
    private String dataSource;
    private Integer heartRate;
    private BigDecimal hrv;
    private String bloodPressure;
    private BigDecimal o2Saturation;
    private BigDecimal glucose;
    private BigDecimal morningCortisol;
    private BigDecimal previousNightSleepDurationHrs;
    private Integer caffeineMg;
    private Integer perceivedStressLevel;
}