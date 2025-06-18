package com.example.rhmcpserveur.service;

import com.example.rhmcpserveur.model.Education;
import com.example.rhmcpserveur.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EducationService {
    
    private final EducationRepository educationRepository;
    
    public List<Education> findAll() {
        return educationRepository.findAll();
    }
    
    public Optional<Education> findById(Long id) {
        return educationRepository.findById(id);
    }
    
    public List<Education> findByPersonId(Long personId) {
        return educationRepository.findByPersonId(personId);
    }
    
    public Education save(Education education) {
        return educationRepository.save(education);
    }
    
    public void deleteById(Long id) {
        educationRepository.deleteById(id);
    }
}