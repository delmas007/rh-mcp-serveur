package com.example.rhmcpserveur.service.dto;

import com.example.rhmcpserveur.model.Employee;
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
@Builder
public class EmployeeDto extends PersonDto{
    private String employeeId;
    private LocalDate hireDate;
    private String department;
    private String position;
    private Employee.AvailabilityStatus availabilityStatus;
    private LocalDate availableFrom;
    private String currentProject;
    private String currentProjectDescription;
}
