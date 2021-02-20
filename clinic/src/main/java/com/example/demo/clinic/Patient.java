package com.example.demo.clinic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
class Patient {

    @Id
    private Long id;
    private String surname;
    private String name;
    private LocalDate birthDate;
    private String pesel;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "patient")
    private List<Appointment> appointment;
}
