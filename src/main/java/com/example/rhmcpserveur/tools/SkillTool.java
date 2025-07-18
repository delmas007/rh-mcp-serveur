package com.example.rhmcpserveur.tools;

import com.example.rhmcpserveur.model.Skill;
import com.example.rhmcpserveur.service.SkillService;
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
public class SkillTool {

    private final SkillService skillService;

    @Tool(description = "Récupérer toutes les compétences")
    public List<Skill> findAllSkill() {
        return skillService.findAll();
    }

    @Tool(description = "Trouver une compétence par son ID")
    public Optional<Skill> findByIdSkill(@ToolParam(description = "id de la compétence") Long id) {
        return skillService.findById(id);
    }

    @Tool(description = "Trouver une compétence par son nom")
    public Optional<Skill> findByName(@ToolParam(description = "nom de la compétence") String name) {
        return skillService.findByName(name);
    }

    @Tool(description = "Sauvegarder une compétence")
    public Skill saveSkill(@ToolParam(description = "compétence à sauvegarder") Skill skill) {
        return skillService.save(skill);
    }

    @Tool(description = "Récupérer une compétence existante ou en créer une nouvelle")
    public Skill getOrCreate(
            @ToolParam(description = "nom de la compétence") String name,
            @ToolParam(description = "niveau de la compétence") String level) {
        return skillService.getOrCreate(name,level);
    }

    @Tool(description = "supprimer une compétence par son ID")
    public void deleteByIdSkill(Long id) {
        skillService.deleteById(id);
    }
}
