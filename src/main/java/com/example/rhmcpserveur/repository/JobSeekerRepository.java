package com.example.rhmcpserveur.repository;

import com.example.rhmcpserveur.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
    List<JobSeeker> findByActivelyLooking(boolean activelyLooking);
    List<JobSeeker> findByPreferredJobTitleContainingIgnoreCase(String jobTitle);
    List<JobSeeker> findByPreferredWorkLocationContainingIgnoreCase(String location);
    List<JobSeeker> findByPreferredWorkType(String workType);
}