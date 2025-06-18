package com.example.rhmcpserveur.service;

import com.example.rhmcpserveur.model.Employee;
import com.example.rhmcpserveur.model.Employee.AvailabilityStatus;
import com.example.rhmcpserveur.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;
    
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }
    
    public Optional<Employee> findByEmployeeId(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }
    
    public List<Employee> findByAvailabilityStatus(AvailabilityStatus status) {
        return employeeRepository.findByAvailabilityStatus(status);
    }
    
    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
    
    public List<Employee> findByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }
    
    public List<Employee> findByCurrentProject(String project) {
        return employeeRepository.findByCurrentProjectContainingIgnoreCase(project);
    }
    
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
    
    public Employee updateAvailabilityStatus(Long id, AvailabilityStatus status) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employee.setAvailabilityStatus(status);
        return employeeRepository.save(employee);
    }
}