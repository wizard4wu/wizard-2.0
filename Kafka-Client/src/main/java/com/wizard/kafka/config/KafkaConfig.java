package com.wizard.kafka.config;

import com.wizard.kafka.interceptor.MyInterceptors;
import com.wizard.kafka.partition.MyPartitioner;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Bean
    public ProducerFactory producerFactory(){
        return new DefaultKafkaProducerFactory(produceConfig());
    }

    @Bean
    public Map<String, Object> produceConfig(){
        Map<String, Object> properties = new HashMap<>();


        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.100.113.38:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //默认是32M 缓冲池
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        //默认使用16kb
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);
        //自定义分区
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, MyPartitioner.class.getName());
        //自定义拦截器
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, List.of(MyInterceptors.class.getName()));

        return properties;
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

}
