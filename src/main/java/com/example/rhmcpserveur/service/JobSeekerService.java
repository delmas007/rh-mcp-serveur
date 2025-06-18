package com.example.rhmcpserveur.service;

import com.example.rhmcpserveur.model.JobSeeker;
import com.example.rhmcpserveur.repository.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class JobSeekerService {
    
    private final JobSeekerRepository jobSeekerRepository;
    
    public List<JobSeeker> findAll() {
        return jobSeekerRepository.findAll();
    }
    
    public Optional<JobSeeker> findById(Long id) {
        return jobSeekerRepository.findById(id);
    }
    
    public List<JobSeeker> findByActivelyLooking(boolean activelyLooking) {
        return jobSeekerRepository.findByActivelyLooking(activelyLooking);
    }
    
    public List<JobSeeker> findByPreferredJobTitle(String jobTitle) {
        return jobSeekerRepository.findByPreferredJobTitleContainingIgnoreCase(jobTitle);
    }
    
    public List<JobSeeker> findByPreferredWorkLocation(String location) {
        return jobSeekerRepository.findByPreferredWorkLocationContainingIgnoreCase(location);
    }
    
    public List<JobSeeker> findByPreferredWorkType(String workType) {
        return jobSeekerRepository.findByPreferredWorkType(workType);
    }
    
    public JobSeeker save(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }
    
    public void deleteById(Long id) {
        jobSeekerRepository.deleteById(id);
    }
}