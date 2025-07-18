package com.example.rhmcpserveur.service.mapper;


import com.example.rhmcpserveur.model.Education;
import com.example.rhmcpserveur.service.dto.EducationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface EducationMapper extends EntityMapper<EducationDto, Education> {
}
