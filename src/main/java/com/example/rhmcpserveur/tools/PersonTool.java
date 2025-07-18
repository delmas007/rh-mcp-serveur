package com.example.rhmcpserveur.tools;

import com.example.rhmcpserveur.model.Person;
import com.example.rhmcpserveur.service.PersonService;
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
public class PersonTool {
    
    private final PersonService personService;

    @Tool(description = "Récupérer toutes les personnes")
    public List<Person> findAllPerson() {
        return personService.findAll();
    }

    @Tool(description = "Trouver une personne par son ID")
    public Optional<Person> findByIdPerson(@ToolParam(description = "id de la personne") Long id) {
        return personService.findById(id);
    }

    @Tool(description = "Sauvegarder une personne")
    public Person savePerson(@ToolParam(description = "personne à sauvegarder") Person person) {
        return personService.save(person);
    }

    @Tool(description = "Supprimer une personne par son ID")
    public void deleteByIdPerson(@ToolParam(description = "id de la personne à supprimer") Long id) {
        personService.deleteById(id);
    }
    
}
