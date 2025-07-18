package com.example.rhmcpserveur.repository;

import com.example.rhmcpserveur.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByPersonId(Long personId);
}