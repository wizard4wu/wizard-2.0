package com.wizard.langchain4j;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;

public class TestChat {

    @Test
    public void test(){
        ChatModel model = OpenAiChatModel
                .builder()
                .baseUrl("https://api.deepseek.com")
                .apiKey("sk-95c4ddc522bf4c6380c779d3973b4a36")
                .modelName("deepseek-reasoner")
                .build();
        String answerResult = model.chat("你好，你是谁?");
        System.out.println(answerResult);
    }
    @Test
    public void testOllamaLocal(){
        ChatModel model = OllamaChatModel
                .builder()
                .baseUrl("http://localhost:11434")
                .modelName("deepseek-r1:1.5b")
                .build();
        String answerResult = model.chat("你好，帮我写一个快排算法?");
        System.out.println(answerResult);
    }
}
