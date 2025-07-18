package com.example.rhmcpserveur.tools;

import com.example.rhmcpserveur.model.Experience;
import com.example.rhmcpserveur.service.ExperienceService;
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
public class ExperienceTool {

    private final ExperienceService experienceService;

    @Tool(description = "Récupérer toutes les expériences professionnelles")
    public List<Experience> findAllExperience() {
        return experienceService.findAll();
    }

    @Tool(description = "Trouver une expérience professionnelle par son ID")
    public Optional<Experience> findByIdExperience(@ToolParam(description = "id de l'expérience") Long id) {
        return experienceService.findById(id);
    }

    @Tool(description = "Trouver les expériences professionnelles d'une personne par son ID")
    public List<Experience> findByPersonIdExperience(@ToolParam(description = "id de la personne") Long personId) {
        return experienceService.findByPersonId(personId);
    }

    @Tool(description = "Sauvegarder une expérience professionnelle")
    public Experience saveExperience(@ToolParam(description = "expérience à sauvegarder") Experience experience) {
        return experienceService.save(experience);
    }

    @Tool(description = "Supprimer une expérience professionnelle par son ID")
    public void deleteByIdExperience(@ToolParam(description = "id de l'expérience à supprimer") Long id) {
        experienceService.deleteById(id);
    }
}
