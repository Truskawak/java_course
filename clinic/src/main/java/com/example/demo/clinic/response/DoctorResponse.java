package com.example.demo.clinic.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class DoctorResponse {
    private final String surname;
    private final String name;
    private final String specialty;
    private final LocalDate birthDate;
    private final String nip;
    private final String pesel;
}
