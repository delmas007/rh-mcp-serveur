package com.example.rhmcpserveur.tools;

import com.example.rhmcpserveur.model.Employee;
import com.example.rhmcpserveur.model.Employee.AvailabilityStatus;
import com.example.rhmcpserveur.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeTool {

    private final EmployeeService employeeService;

    @Tool(description = "Trouver un employé par son ID")
    public Optional<Employee> findByIdEmployee(@ToolParam(description = "id de l'employé") Long id) {
        return employeeService.findById(id);
    }

    @Tool(description = "Trouver un employé par son identifiant d'employé")
    public Optional<Employee> findByEmployeeIdEmployee(@ToolParam(description = "identifiant de l'employé") String employeeId) {
        return employeeService.findByEmployeeId(employeeId);
    }

    @Tool(description = "Trouver des employés par leur statut de disponibilité")
    public List<Employee> findByAvailabilityStatusEmployee(@ToolParam(description = "statut de disponibilité") AvailabilityStatus status) {
        return employeeService.findByAvailabilityStatus(status);
    }

    @Tool(description = "Trouver des employés par leur département")
    public List<Employee> findByDepartmentEmployee(@ToolParam(description = "nom du département") String department) {
        return employeeService.findByDepartment(department);
    }

    @Tool(description = "Trouver des employés par leur poste")
    public List<Employee> findByPositionEmployee(@ToolParam(description = "intitulé du poste") String position) {
        return employeeService.findByPosition(position);
    }

    @Tool(description = "Trouver des employés par leur projet actuel")
    public List<Employee> findByCurrentProjectEmployee(@ToolParam(description = "nom du projet") String project) {
        return employeeService.findByCurrentProject(project);
    }

    @Tool(description = "Sauvegarder un employé")
    public Employee saveEmployee(@ToolParam(description = "employé à sauvegarder") Employee employee) {
        return employeeService.save(employee);
    }

    @Tool(description = "Supprimer un employé par son ID")
    public void deleteByIdEmployee(@ToolParam(description = "id de l'employé à supprimer") Long id) {
        employeeService.deleteById(id);
    }

    @Tool(description = "Mettre à jour le statut de disponibilité d'un employé")
    public Employee updateAvailabilityStatus(
            @ToolParam(description = "id de l'employé") Long id,
            @ToolParam(description = "nouveau statut de disponibilité") AvailabilityStatus status) {
        Employee employee = employeeService.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employee.setAvailabilityStatus(status);
        return employeeService.save(employee);
    }
}
