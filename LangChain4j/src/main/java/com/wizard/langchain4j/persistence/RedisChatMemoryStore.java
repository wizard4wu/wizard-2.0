package com.wizard.langchain4j.persistence;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
@Slf4j
public class RedisChatMemoryStore implements CacheChatMemoryStore{

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        String value = redisTemplate.opsForValue().get((String) memoryId);
        if(value == null) {
            return List.of();
        }
        List<ChatMessage> chatMessageList = ChatMessageDeserializer.messagesFromJson(value);
        return chatMessageList;
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages) {
        if(CollectionUtils.isEmpty(messages)) {
            return;
        }
        redisTemplate.opsForValue().set((String)memoryId, ChatMessageSerializer.messagesToJson(messages));

    }
    @Override
    public void deleteMessages(Object memoryId) {
        redisTemplate.delete((String)memoryId);
    }
}
