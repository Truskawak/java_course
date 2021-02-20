package com.example.demo.sequence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DecodePeselResponse {
    private LocalDate birthDate;
    private Gender gender;
}
