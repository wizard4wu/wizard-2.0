package com.wizard.kafka.intercepter;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

@Sl
public class MyInterceptors implements ProducerInterceptor {
    //拦截器 对数据进行加工
    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        return null;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
