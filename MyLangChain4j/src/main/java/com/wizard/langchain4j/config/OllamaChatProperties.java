package com.wizard.langchain4j.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ollama.chat")
@Data
public class OllamaChatProperties {

    private String baseUrl;
    private String modelName;

}
