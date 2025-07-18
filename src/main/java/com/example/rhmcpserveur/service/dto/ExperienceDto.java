package com.example.rhmcpserveur.service.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceDto extends PersonDto {
    private LocalDate availableFrom;
    private String preferredJobTitle;
    private String preferredWorkLocation;
    private String preferredWorkType;
    private String resumeSummary;
    private boolean activelyLooking;
}
