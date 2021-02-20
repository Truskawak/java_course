package com.example.demo.sequence.dto;

import com.example.demo.sequence.Pesel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecodePeselRequest {
    @Pesel
    private String pesel;
}
