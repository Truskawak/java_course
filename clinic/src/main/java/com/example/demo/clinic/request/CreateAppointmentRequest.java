package com.example.demo.clinic.request;

import com.example.demo.clinic.DoctorRepository;
import com.example.demo.clinic.PatientRepository;
import com.example.demo.clinic.contraint.RecordExists;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateAppointmentRequest {
    @NotNull
    @RecordExists(repository = DoctorRepository.class)
    private Long doctorId;
    @NotNull
    @RecordExists(repository = PatientRepository.class)
    private Long patientId;
    @NotNull
    //TODO: validation if doctor or patient doesn't have appointment this day
    private LocalDate date;
}
