package com.example.demo.clinic.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class PatientResponse {
    private final String surname;
    private final String name;
    private final LocalDate birthDate;
    private final String pesel;
}
