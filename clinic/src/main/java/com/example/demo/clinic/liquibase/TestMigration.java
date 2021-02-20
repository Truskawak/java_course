package com.example.demo.clinic.liquibase;

import com.example.demo.clinic.DoctorRepository;
import liquibase.change.custom.CustomTaskChange;
import liquibase.database.Database;
import liquibase.exception.SetupException;
import liquibase.exception.ValidationErrors;
import liquibase.integration.spring.SpringResourceAccessor;
import liquibase.resource.ResourceAccessor;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

import java.lang.reflect.Field;

public class TestMigration implements CustomTaskChange {

    @Override
    public void execute(Database database) {

        BeanUtil.getBean(DoctorRepository.class);

    }


    @Override
    public String getConfirmationMessage() {
        return null;
    }

    @Override
    public void setUp() throws SetupException {

    }

    @Override
    public void setFileOpener(ResourceAccessor resourceAccessor) {
        SpringResourceAccessor obj = (SpringResourceAccessor) resourceAccessor;

        try {

            Field contextField = obj.getClass().getDeclaredField("resourceLoader");
            contextField.setAccessible(true);

            AnnotationConfigServletWebServerApplicationContext applicationContext = (AnnotationConfigServletWebServerApplicationContext) contextField.get(obj);
            DoctorRepository repository = applicationContext.getBean(DoctorRepository.class);
            System.out.println(repository.findAll());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public ValidationErrors validate(Database database) {
        return null;
    }
}
