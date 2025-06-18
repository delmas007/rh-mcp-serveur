package com.example.rhmcpserveur.controller;

import com.example.rhmcpserveur.model.Experience;
import com.example.rhmcpserveur.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {
    
    private final ExperienceService experienceService;
    
    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperiences() {
        return ResponseEntity.ok(experienceService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Long id) {
        return experienceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/person/{personId}")
    public ResponseEntity<List<Experience>> getExperiencesByPersonId(@PathVariable Long personId) {
        List<Experience> experiences = experienceService.findByPersonId(personId);
        return ResponseEntity.ok(experiences);
    }
    
    @PostMapping
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        return ResponseEntity.status(HttpStatus.CREATED).body(experienceService.save(experience));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        return experienceService.findById(id)
                .map(existingExperience -> {
                    experience.setId(id);
                    return ResponseEntity.ok(experienceService.save(experience));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {
        return experienceService.findById(id)
                .map(experience -> {
                    experienceService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}