package com.example.demo.clinic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {

    //TO ASK, count, boolean ?
    @Query(value = "SELECT * FROM appointment a where a.doctor_id = :doctorId and a.date = :date",
            nativeQuery = true)
    List<Appointment> findAppointmentsByDoctorAndDate(Long doctorId, LocalDate date);
}
