package com.example.onda.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "work_sessions")
public class WorkSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "start_timestamp")
    private LocalDateTime startTimestamp;

    @Column(name = "end_timestamp")
    private LocalDateTime endTimestamp;

    @Column(name = "planned_shift_duration_hrs")
    private BigDecimal plannedShiftDurationHrs;

    @Column(name = "consecutive_work_days")
    private Integer consecutiveWorkDays;

    @Column(name = "breaks_taken_count")
    private Integer breaksTakenCount;

    @OneToMany(mappedBy = "workSession")
    private Set<Measurement> measurements;

    @OneToMany(mappedBy = "workSession")
    private Set<PvtResult> pvtResults;
}