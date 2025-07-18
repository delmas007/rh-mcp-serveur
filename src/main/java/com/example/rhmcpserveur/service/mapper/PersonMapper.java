package com.example.rhmcpserveur.service.mapper;

import com.example.rhmcpserveur.model.Person;
import com.example.rhmcpserveur.service.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends EntityMapper<PersonDto, Person> {
}
