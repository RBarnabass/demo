package com.example.demo.configuration;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RomeoScopeConfig {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {

        return new RomeoBeanFactoryPostProcessor();
    }
}
