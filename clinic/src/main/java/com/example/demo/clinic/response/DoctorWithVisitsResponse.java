package com.example.demo.clinic.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
public class DoctorWithVisitsResponse {
    private final String surname;
    private final String name;
    private final String specialty;
    private final LocalDate birthDate;
    private final String nip;
    private final String pesel;
    List<AppointmentResponse> appointments;
}
