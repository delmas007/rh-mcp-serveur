package com.example.rhmcpserveur.service.mapper;

import com.example.rhmcpserveur.model.Skill;
import com.example.rhmcpserveur.service.dto.SkillDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper extends EntityMapper<SkillDto, Skill> {
}
