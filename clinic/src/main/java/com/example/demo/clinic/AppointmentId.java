package com.example.demo.clinic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
class AppointmentId implements Serializable {
    private long patientId;
    private long doctorId;
    private LocalDate date;
}
