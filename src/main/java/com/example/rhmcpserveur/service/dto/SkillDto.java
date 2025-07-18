package com.example.rhmcpserveur.service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillDto {
    private Long id;
    private String name;
    private String level;
}
