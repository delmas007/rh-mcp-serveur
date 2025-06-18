package com.example.rhmcpserveur.controller;

import com.example.rhmcpserveur.model.JobSeeker;
import com.example.rhmcpserveur.service.JobSeekerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-seekers")
@RequiredArgsConstructor
public class JobSeekerController {
    
    private final JobSeekerService jobSeekerService;
    
    @GetMapping
    public ResponseEntity<List<JobSeeker>> getAllJobSeekers() {
        return ResponseEntity.ok(jobSeekerService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable Long id) {
        return jobSeekerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/actively-looking/{activelyLooking}")
    public ResponseEntity<List<JobSeeker>> getJobSeekersByActivelyLooking(@PathVariable boolean activelyLooking) {
        return ResponseEntity.ok(jobSeekerService.findByActivelyLooking(activelyLooking));
    }
    
    @GetMapping("/job-title/{jobTitle}")
    public ResponseEntity<List<JobSeeker>> getJobSeekersByPreferredJobTitle(@PathVariable String jobTitle) {
        return ResponseEntity.ok(jobSeekerService.findByPreferredJobTitle(jobTitle));
    }
    
    @GetMapping("/location/{location}")
    public ResponseEntity<List<JobSeeker>> getJobSeekersByPreferredWorkLocation(@PathVariable String location) {
        return ResponseEntity.ok(jobSeekerService.findByPreferredWorkLocation(location));
    }
    
    @GetMapping("/work-type/{workType}")
    public ResponseEntity<List<JobSeeker>> getJobSeekersByPreferredWorkType(@PathVariable String workType) {
        return ResponseEntity.ok(jobSeekerService.findByPreferredWorkType(workType));
    }
    
    @PostMapping
    public ResponseEntity<JobSeeker> createJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobSeekerService.save(jobSeeker));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<JobSeeker> updateJobSeeker(@PathVariable Long id, @RequestBody JobSeeker jobSeeker) {
        return jobSeekerService.findById(id)
                .map(existingJobSeeker -> {
                    jobSeeker.setId(id);
                    return ResponseEntity.ok(jobSeekerService.save(jobSeeker));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long id) {
        return jobSeekerService.findById(id)
                .map(jobSeeker -> {
                    jobSeekerService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}