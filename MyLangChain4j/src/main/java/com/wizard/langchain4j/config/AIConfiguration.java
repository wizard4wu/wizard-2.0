package com.wizard.langchain4j.config;

import com.wizard.langchain4j.service.ToolService;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.TokenStream;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfiguration {

    public interface Assistant{
        String chat(String text);

        TokenStream stream(String text);
    }

    //进行对话隔离
    public interface AssistantUnique{
        String chat(@MemoryId String memoryId, @UserMessage String text);

        TokenStream stream(@MemoryId String memoryId, @UserMessage String text);
    }
    //进行对话隔离并且持久化数据
    public interface AssistantUniqueWithPersistence{
        String chat(@MemoryId String memoryId, @UserMessage String text);

        TokenStream stream(@MemoryId String memoryId, @UserMessage String text);
    }

    @Bean
    public AssistantUniqueWithPersistence assistantUniqueWithPersistence(ChatModel chatModel, StreamingChatModel streamingChatModel, ChatMemoryStore chatMemoryStore) {
        AssistantUniqueWithPersistence assistantUnique = AiServices
                .builder(AssistantUniqueWithPersistence.class)
                .chatModel(chatModel)
                .streamingChatModel(streamingChatModel)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.builder().id(memoryId).maxMessages(10).chatMemoryStore(chatMemoryStore).build())
                .build();
        return assistantUnique;
    }


    @Bean
    public AssistantUnique assistantUnique(ChatModel chatModel, StreamingChatModel streamChatModel){
        AssistantUnique assistantUnique = AiServices
                .builder(AssistantUnique.class)
                .chatModel(chatModel)
                .streamingChatModel(streamChatModel)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.builder().maxMessages(10).id(memoryId).build())
                .build();
        return assistantUnique;
    }

    @Bean
    public Assistant assistant(ChatModel chatModel, StreamingChatModel streamChatModel, ToolService toolService) {
        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatModel(chatModel)
                .tools(toolService)
                .streamingChatModel(streamChatModel)
                .chatMemory(chatMemory)
                .build();
        return assistant;
    }
}
