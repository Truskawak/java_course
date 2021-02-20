package com.example.demo.sequence;

import com.example.demo.common.dto.ErrorDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity processError(MethodArgumentNotValidException exc) {
        List<ErrorDto> errors = exc.getAllErrors().stream()
                .map(error -> new ErrorDto(error.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(errors);

    }
}
