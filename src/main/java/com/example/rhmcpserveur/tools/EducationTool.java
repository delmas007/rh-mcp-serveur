package com.example.rhmcpserveur.tools;

import com.example.rhmcpserveur.model.Education;
import com.example.rhmcpserveur.repository.EducationRepository;
import com.example.rhmcpserveur.service.EducationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationTool {

    private final EducationService educationService;

    @Tool(description = "Récupérer toutes les formations")
    public List<Education> findAllEducation() {
        return educationService.findAll();
    }

    @Tool(description = "Trouver une formation par son ID")
    public Optional<Education> findByIdEducation(@ToolParam(description = "id de la formation") Long id) {
        return educationService.findById(id);
    }

    @Tool(description = "Trouver les formations d'une personne par son ID")
    public List<Education> findByPersonIdEducation(@ToolParam(description = "id de la personne") Long personId) {
        return educationService.findByPersonId(personId);
    }

    @Tool(description = "Sauvegarder une formation")
    public Education saveEducation(@ToolParam(description = "formation à sauvegarder") Education education) {
        return educationService.save(education);
    }

    @Tool(description = "Supprimer une formation par son ID")
    public void deleteByIdEducation(@ToolParam(description = "id de la formation à supprimer") Long id) {
        educationService.deleteById(id);
    }
}
