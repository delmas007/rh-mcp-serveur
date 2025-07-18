package com.example.rhmcpserveur.service;

import com.example.rhmcpserveur.model.Skill;
import com.example.rhmcpserveur.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SkillService {

    private final SkillRepository skillRepository;

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    public Optional<Skill> findByName(String name) {
        return skillRepository.findByName(name);
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill getOrCreate(String name, String level) {
        return skillRepository.findByName(name)
                .orElseGet(() -> {
                    Skill newSkill = new Skill();
                    newSkill.setName(name);
                    newSkill.setLevel(level);
                    return skillRepository.save(newSkill);
                });
    }

    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }
}
