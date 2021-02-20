package com.example.demo.clinic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
