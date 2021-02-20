package com.example.demo.clinic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Getter
@Setter
public class Appointment {
    //TODO: cahnge to Long id;
    @EmbeddedId
    private AppointmentId id;

    @MapsId("doctorId")
    @ManyToOne
    private Doctor doctor;
    @MapsId("patientId")
    @ManyToOne
    private Patient patient;

}
