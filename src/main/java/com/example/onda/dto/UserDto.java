package com.example.onda.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private Long roleId; // On utilise l'ID pour éviter la récursion
    private String login;
    // Le mot de passe (passwordHash) n'est généralement pas exposé dans un DTO
    private String firstName;
    private String lastName;
    private boolean isActive;
    private LocalDate birthDate;
    private String gender;
    private String maritalStatus;
    private Integer seniority;
    private String circadianProfile;
    private String experienceLevel;
}