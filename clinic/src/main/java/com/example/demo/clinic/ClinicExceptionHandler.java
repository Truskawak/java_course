package com.example.demo.clinic;

import com.example.demo.clinic.exception.AppointmentConflictException;
import com.example.demo.clinic.exception.RecordNotFoundException;
import com.example.demo.common.dto.ErrorDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
class ClinicExceptionHandler {
    @ExceptionHandler(AppointmentConflictException.class)
    public ResponseEntity processError(AppointmentConflictException exc) {
        List<ErrorDto> errors = Arrays.asList(new ErrorDto(exc.getMessage()));
        return ResponseEntity.status(CONFLICT).contentType(MediaType.APPLICATION_JSON).body(errors);

    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity processError(RecordNotFoundException exc) {
        List<ErrorDto> errors = Arrays.asList(new ErrorDto(exc.getMessage()));
        return ResponseEntity.status(NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(errors);

    }
}
