package com.example.onda.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    // --- Champs de profil (tous optionnels/nullable) ---

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String gender;

    @Column(name = "marital_status")
    private String maritalStatus;

    private Integer seniority;

    @Column(name = "circadian_profile")
    private String circadianProfile;

    @Column(name = "experience_level")
    private String experienceLevel;

    // --- Relations inverses ---
    @OneToMany(mappedBy = "user")
    private Set<WorkSession> workSessions;
}