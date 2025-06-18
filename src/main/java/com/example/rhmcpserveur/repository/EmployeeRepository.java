package com.example.rhmcpserveur.repository;

import com.example.rhmcpserveur.model.Employee;
import com.example.rhmcpserveur.model.Employee.AvailabilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmployeeId(String employeeId);
    List<Employee> findByAvailabilityStatus(AvailabilityStatus status);
    List<Employee> findByDepartment(String department);
    List<Employee> findByPosition(String position);
    List<Employee> findByCurrentProjectContainingIgnoreCase(String project);
}