package com.example.demo.clinic.contraint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class RecordExistsValidator implements ConstraintValidator<RecordExists, Long> {

    @Autowired
    private ApplicationContext context;

    private Class<? extends JpaRepository> repository;

    @Override
    public void initialize(RecordExists constraintAnnotation) {
        repository = constraintAnnotation.repository();

    }

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
        JpaRepository repository = context.getBean(this.repository);

        return repository.existsById(aLong);
    }
}
