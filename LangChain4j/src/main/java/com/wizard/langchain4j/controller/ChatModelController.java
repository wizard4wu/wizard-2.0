package com.wizard.langchain4j.controller;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import dev.langchain4j.model.openai.internal.chat.UserMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatModelController {



    @RequestMapping("/ollama/string")
    public String ollamaChatModel(@RequestParam("message") String inputValue) {
        final String resultString = getChatModel().chat(inputValue);
        return resultString;
    }
    @RequestMapping(value = "/ollama/stream", produces = "text/stream;charset=utf-8")
    public Flux<String> streamOllamaChatModel(@RequestParam("message") String inputValue) {
        return Flux.create(sink -> {
            getStreamChatModel().chat(inputValue, new StreamingChatResponseHandler() {
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

    private ChatModel getChatModel() {
        ChatModel model = OllamaChatModel
                .builder()
                .baseUrl("http://localhost:11434")
                .modelName("deepseek-r1:1.5b")
                .build();
        return model;
    }

    private StreamingChatModel getStreamChatModel() {
        StreamingChatModel model = OllamaStreamingChatModel
                .builder()
                .baseUrl("http://localhost:11434")
                .modelName("deepseek-r1:1.5b")
                .build();
        return model;
    }

}
