package com.example.demo.clinic.liquibase;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtil implements ApplicationContextAware {
    private static AutowireCapableBeanFactory factory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        factory = applicationContext.getAutowireCapableBeanFactory();
    }

    public static Object getBean(Class<?> clazz) {
        return factory.autowire(clazz, 2, true);
    }
}
