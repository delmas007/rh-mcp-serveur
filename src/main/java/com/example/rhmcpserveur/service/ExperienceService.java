package com.example.rhmcpserveur.service;

import com.example.rhmcpserveur.model.Experience;
import com.example.rhmcpserveur.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id);
    }

    public List<Experience> findByPersonId(Long personId) {
        return experienceRepository.findByPersonId(personId);
    }

    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    public void deleteById( Long id) {
        experienceRepository.deleteById(id);
    }
}
