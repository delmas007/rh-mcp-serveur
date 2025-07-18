package com.example.rhmcpserveur.service.mapper;

import com.example.rhmcpserveur.model.Employee;
import com.example.rhmcpserveur.service.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDto, Employee> {
}