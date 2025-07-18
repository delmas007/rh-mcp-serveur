package com.example.rhmcpserveur.tools;

import com.example.rhmcpserveur.model.JobSeeker;
import com.example.rhmcpserveur.service.JobSeekerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobSeekerTool {
    
    private final JobSeekerService jobSeekerService;

    @Tool(description = "Récupérer tous les chercheurs d'emploi")
    public List<JobSeeker> findAllJobSeeker() {
        return jobSeekerService.findAll();
    }

    @Tool(description = "Trouver un chercheur d'emploi par son ID")
    public Optional<JobSeeker> findByIdJobSeeker(@ToolParam(description = "id du chercheur d'emploi") Long id) {
        return jobSeekerService.findById(id);
    }

    @Tool(description = "Trouver des chercheurs d'emploi selon leur statut de recherche active")
    public List<JobSeeker> findByActivelyLooking(@ToolParam(description = "statut de recherche active") boolean activelyLooking) {
        return jobSeekerService.findByActivelyLooking(activelyLooking);
    }

    @Tool(description = "Trouver des chercheurs d'emploi par le titre de poste recherché")
    public List<JobSeeker> findByPreferredJobTitle(@ToolParam(description = "titre du poste recherché") String jobTitle) {
        return jobSeekerService.findByPreferredJobTitle(jobTitle);
    }

    @Tool(description = "Trouver des chercheurs d'emploi par lieu de travail préféré")
    public List<JobSeeker> findByPreferredWorkLocation(@ToolParam(description = "lieu de travail recherché") String location) {
        return jobSeekerService.findByPreferredWorkLocation(location);
    }

    @Tool(description = "Trouver des chercheurs d'emploi par type de travail préféré")
    public List<JobSeeker> findByPreferredWorkType(@ToolParam(description = "type de travail recherché") String workType) {
        return jobSeekerService.findByPreferredWorkType(workType);
    }

    @Tool(description = "Sauvegarder un chercheur d'emploi")
    public JobSeeker saveJobSeeker(@ToolParam(description = "chercheur d'emploi à sauvegarder") JobSeeker jobSeeker) {
        return jobSeekerService.save(jobSeeker);
    }

    @Tool(description = "Supprimer un chercheur d'emploi par son ID")
    public void deleteByIdJobSeeker(@ToolParam(description = "id du chercheur d'emploi à supprimer") Long id) {
        jobSeekerService.deleteById(id);
    }
    
}
