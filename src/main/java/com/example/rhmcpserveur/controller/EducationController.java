package com.example.rhmcpserveur.controller;

import com.example.rhmcpserveur.model.Education;
import com.example.rhmcpserveur.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@RequiredArgsConstructor
public class EducationController {
    
    private final EducationService educationService;
    
    @GetMapping
    public ResponseEntity<List<Education>> getAllEducations() {
        return ResponseEntity.ok(educationService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long id) {
        return educationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/person/{personId}")
    public ResponseEntity<List<Education>> getEducationsByPersonId(@PathVariable Long personId) {
        List<Education> educations = educationService.findByPersonId(personId);
        return ResponseEntity.ok(educations);
    }
    
    @PostMapping
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        return ResponseEntity.status(HttpStatus.CREATED).body(educationService.save(education));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education education) {
        return educationService.findById(id)
                .map(existingEducation -> {
                    education.setId(id);
                    return ResponseEntity.ok(educationService.save(education));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        return educationService.findById(id)
                .map(education -> {
                    educationService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}