package com.example.rhmcpserveur.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Employee extends Person {
    
    private String employeeId;
    private LocalDate hireDate;
    private String department;
    private String position;
    
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;
    
    private LocalDate availableFrom; // Relevant if on leave or mission
    private String currentProject; // If on mission
    private String currentProjectDescription;
    
    public enum AvailabilityStatus {
        AVAILABLE,
        ON_MISSION,
        ON_LEAVE
    }
}