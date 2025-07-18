package com.example.rhmcpserveur.service.dto;

import lombok.*;

@Getter
@Setter
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
}
