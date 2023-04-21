package com.dev.wizard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;

@Configuration
public class SpringConfig {

    @Bean
    public AnnotationTransactionAttributeSource annotationTransactionAttributeSource(){
        return new AnnotationTransactionAttributeSource(false);
    }
}
