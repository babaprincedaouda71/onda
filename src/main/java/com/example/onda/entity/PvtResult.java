package com.example.onda.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pvt_results")
public class PvtResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pvt_id")
    private Long pvtId;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private WorkSession workSession;

    @Column(name = "test_timestamp")
    private LocalDateTime testTimestamp;

    @Column(name = "avg_reaction_time_ms")
    private Integer avgReactionTimeMs;

    @Column(name = "lapse_count")
    private Integer lapseCount;
}