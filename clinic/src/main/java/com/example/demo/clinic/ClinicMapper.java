package com.example.demo.clinic;

import com.example.demo.clinic.response.AppointmentResponse;
import com.example.demo.clinic.response.DoctorResponse;
import com.example.demo.clinic.response.DoctorWithVisitsResponse;
import com.example.demo.clinic.response.PatientResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class ClinicMapper {

    DoctorResponse mapDoctor(Doctor doctor) {

        return DoctorResponse.builder()
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .birthDate(doctor.getBirthDate())
                .specialty(doctor.getSpecialty())
                .pesel(doctor.getPesel())
                .nip(doctor.getNip())
                .build();
    }

    DoctorWithVisitsResponse mapDoctorWithVisits(Doctor doctor) {
        List<AppointmentResponse> appointments = doctor.getAppointments().stream()
                .map(this::mapDoctorAppointment)
                .collect(Collectors.toList());

        return DoctorWithVisitsResponse.builder()
                .name(doctor.getName())
                .surname(doctor.getSurname())
                .birthDate(doctor.getBirthDate())
                .specialty(doctor.getSpecialty())
                .pesel(doctor.getPesel())
                .nip(doctor.getNip())
                .appointments(appointments)
                .build();
    }

    PatientResponse mapPatient(Patient patient) {

        return PatientResponse.builder()
                .name(patient.getName())
                .surname(patient.getSurname())
                .birthDate(patient.getBirthDate())
                .pesel(patient.getPesel())
                .build();
    }

    AppointmentResponse mapAppointment(Appointment appointment) {
        return AppointmentResponse.builder()
                .doctorName(String.format("%s %s", appointment.getDoctor().getName(), appointment.getDoctor().getSurname()))
                .patientName(String.format("%s %s", appointment.getPatient().getName(), appointment.getPatient().getSurname()))
                .date(appointment.getId().getDate())
                .build();
    }

    private AppointmentResponse mapDoctorAppointment(Appointment appointment) {
        return AppointmentResponse.builder()
                .patientName(String.format("%s %s", appointment.getPatient().getName(), appointment.getPatient().getSurname()))
                .date(appointment.getId().getDate())
                .build();
    }

}
