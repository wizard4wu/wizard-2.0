package com.wizard.kafka.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "MyTest")
    public void listGroup(ConsumerRecord<String, String> consumerRecord, Acknowledgment ack, Consumer consumer){
        String value = consumerRecord.value();
        System.out.println("value: " + value);
consumer.commitSync();
consumer.commitAsync();
        ack.acknowledge();
    }
}
