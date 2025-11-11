package com.example.onda.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private Long measurementId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "measurement_timestamp")
    private LocalDateTime measurementTimestamp;

    @Column(name = "data_source")
    private String dataSource;

    @Column(name = "heart_rate")
    private Integer heartRate;

    private BigDecimal hrv;

    @Column(name = "blood_pressure")
    private String bloodPressure;

    @Column(name = "o2_saturation")
    private BigDecimal o2Saturation;

    private BigDecimal glucose;

    @Column(name = "morning_cortisol")
    private BigDecimal morningCortisol;

    @Column(name = "previous_night_sleep_duration_hrs")
    private BigDecimal previousNightSleepDurationHrs;

    @Column(name = "caffeine_mg")
    private Integer caffeineMg;

    @Column(name = "perceived_stress_level")
    private Integer perceivedStressLevel;
}