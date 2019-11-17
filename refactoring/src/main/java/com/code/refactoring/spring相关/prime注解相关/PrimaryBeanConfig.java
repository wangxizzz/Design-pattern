package com.code.refactoring.spring相关.prime注解相关;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class PrimaryBeanConfig {

    @Bean
    public ExecutorService personPool() {
        return Executors.newFixedThreadPool(10);
    }

    @Bean
    @Primary
    public ExecutorService animalPool() {
        return Executors.newCachedThreadPool();
    }
}
