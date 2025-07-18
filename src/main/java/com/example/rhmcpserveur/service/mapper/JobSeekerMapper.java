package com.example.rhmcpserveur.service.mapper;

import com.example.rhmcpserveur.model.JobSeeker;
import com.example.rhmcpserveur.service.dto.JobSeekerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobSeekerMapper extends EntityMapper<JobSeekerDto, JobSeeker> {
}
