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
public class Doctor {

    @Id
    private Long id;
    private String surname;
    private String name;
    private String specialty;
    private LocalDate birthDate;
    private String nip;
    private String pesel;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "doctor")
    private List<Appointment> appointments;

}
