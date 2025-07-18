package com.example.rhmcpserveur.model;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class JobSeeker extends Person {
    
    private LocalDate availableFrom;
    private String preferredJobTitle;
    private String preferredWorkLocation;
    private String preferredWorkType;
    private String resumeSummary;
    private boolean activelyLooking;
}