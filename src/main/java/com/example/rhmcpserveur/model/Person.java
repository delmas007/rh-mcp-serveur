package com.example.rhmcpserveur.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

//    @ManyToMany(cascade = {CascadeType.MERGE})
//    @JoinTable(
//        name = "person_skills",
//        joinColumns = @JoinColumn(name = "person_id"),
//        inverseJoinColumns = @JoinColumn(name = "skill_id")
//    )
//    @JsonIgnore
//    private Set<Skill> skills = new HashSet<>();
//
//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private Set<Experience> experiences = new HashSet<>();
//
//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private Set<Education> educations = new HashSet<>();
}
