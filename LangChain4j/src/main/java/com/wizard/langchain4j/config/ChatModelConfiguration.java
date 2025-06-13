package com.wizard.langchain4j.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatModelConfiguration {

    @Autowired
    private OllamaChatProperties ollamaChatProperties;

    //配置文本输出
    @Bean
    public ChatModel chatModel() {
        ChatModel model = OllamaChatModel
                .builder()
                .baseUrl(ollamaChatProperties.getBaseUrl())
                .modelName(ollamaChatProperties.getModelName())
                .build();
        return model;
    }

    //配置流式输出
    @Bean
    public StreamingChatModel streamChatModel() {
        StreamingChatModel streamingChatModel = OllamaStreamingChatModel
                .builder()
                .baseUrl(ollamaChatProperties.getBaseUrl())
                .modelName(ollamaChatProperties.getModelName())
                .build();
        return streamingChatModel;
    }
}
