package com.example.demo.clinic;

import com.example.demo.clinic.exception.AppointmentConflictException;
import com.example.demo.clinic.exception.RecordNotFoundException;
import com.example.demo.clinic.request.CreateAppointmentRequest;
import com.example.demo.clinic.response.AppointmentResponse;
import com.example.demo.clinic.response.DoctorResponse;
import com.example.demo.clinic.response.DoctorWithVisitsResponse;
import com.example.demo.clinic.response.PatientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
class ClinicService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final ClinicMapper clinicMapper;

    DoctorResponse findDoctorById(Long id) {
        return clinicMapper.mapDoctor(findDoctor(id));

    }

    DoctorWithVisitsResponse findDoctorWithVisitsById(Long id) {
        return clinicMapper.mapDoctorWithVisits(findDoctor(id));
    }

    PatientResponse findPatientById(Long id) {
        return clinicMapper.mapPatient(findPatient(id));

    }

    AppointmentResponse createAppointment(CreateAppointmentRequest request) {
        List<Appointment> conflictAppointments = appointmentRepository.findAppointmentsByDoctorAndDate(request.getDoctorId(), request.getDate());

        if (!conflictAppointments.isEmpty()) {
            throw new AppointmentConflictException("Doctor has already appointment on: " + request.getDate());
        }

        Doctor doctor = findDoctor(request.getDoctorId());
        Patient patient = findPatient(request.getPatientId());

        AppointmentId appointmentId = new AppointmentId();
        appointmentId.setDate(request.getDate());

        Appointment appointment = new Appointment();
        appointment.setId(appointmentId);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        appointment = appointmentRepository.save(appointment);

        return clinicMapper.mapAppointment(appointment);

    }

    private Patient findPatient(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Patient not found by id " + id));
    }


    private Doctor findDoctor(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Doctor not found by id " + id));
    }
}
