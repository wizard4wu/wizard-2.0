package com.wizard.langchain4j.controller;

import com.wizard.langchain4j.config.AIConfiguration;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import dev.langchain4j.model.openai.internal.chat.UserMessage;
import dev.langchain4j.service.TokenStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatModelController {


    @Autowired
    private ChatModel chatModel;
    @Autowired
    private StreamingChatModel streamingChatModel;
    @Autowired
    private AIConfiguration.Assistant assistant;
    @Autowired
    private AIConfiguration.AssistantUnique assistantUnique;
    @Autowired
    private AIConfiguration.AssistantUniqueWithPersistence assistantUniqueWithPersistence;

    @RequestMapping("/ollama/string")
    public String ollamaChatModel(@RequestParam("message") String inputValue) {
        final String resultString = chatModel.chat(inputValue);
        return resultString;
    }
    @RequestMapping(value = "/ollama/stream", produces = "text/stream;charset=utf-8")
    public Flux<String> streamOllamaChatModel(@RequestParam("message") String inputValue) {
        return Flux.create(sink -> {
            streamingChatModel.chat(inputValue, new StreamingChatResponseHandler() {
                @Override
                public void onPartialResponse(String partialResponse) {
                    sink.next(partialResponse);
                }

                @Override
                public void onCompleteResponse(ChatResponse completeResponse) {
                    sink.complete();
                    log.info("complete response");
                }
                @Override
                public void onError(Throwable error) {
                    sink.error(error);
                    log.error("error: ", error);
                }
            });
        });
    }


    @RequestMapping(value = "/ollama/memory/string")
    public String ollamaChatModelMemory(@RequestParam("message") String inputValue) {
        return assistant.chat(inputValue);
    }

    @RequestMapping(value = "/ollama/memory/stream")
    public Flux<String> streamOllamaChatModelMemory(@RequestParam("message") String inputValue) {
        TokenStream stream = assistant.stream(inputValue);

        return Flux.create(sink ->{
            stream.onPartialResponse(sink::next)
                    .onCompleteResponse(c -> sink.complete())
                    .onError(sink::error)
                    .start();
        });
    }

    @RequestMapping(value = "/ollama/memory/{id}/string")
    public String ollamaChatModelMemory(@PathVariable("id") String id, @RequestParam("message") String inputValue) {
        return assistantUniqueWithPersistence.chat(id, inputValue);
    }

}
