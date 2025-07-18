package com.example.rhmcpserveur.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String level; // e.g., Beginner, Intermediate, Advanced, Expert
    
//    @ManyToMany(mappedBy = "skills")
//    @JsonIgnore
//    private Set<Person> persons = new HashSet<>();
}