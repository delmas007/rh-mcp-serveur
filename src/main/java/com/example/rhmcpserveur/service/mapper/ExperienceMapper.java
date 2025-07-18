package com.example.rhmcpserveur.service.mapper;

import com.example.rhmcpserveur.model.Experience;
import com.example.rhmcpserveur.service.dto.ExperienceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { PersonMapper.class })
public interface ExperienceMapper extends EntityMapper<ExperienceDto, Experience> {
}
