package com.example.demo.sequence.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class SequenceRequest {
    @Size(min = 2, message = "INVALID_LIST_SIZE")
    private List<Integer> numbers;
}
