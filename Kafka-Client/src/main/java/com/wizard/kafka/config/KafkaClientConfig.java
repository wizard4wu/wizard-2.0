package com.wizard.kafka.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class KafkaClientConfig {

    private final static String TOPIC_NAME = "MyTest";
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
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
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "com.wizard.kafka.partition.MyPartitioner");
        // properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 1);
        //2.创建生产消息的客户端
        Producer<String, String> producer = new KafkaProducer<>(properties);

        //创建消息
        //value 是指具体发送数据  key用于指定topic中的分区
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME,"HHHHzzz");
        RecordMetadata metadata = producer.send(record).get();
        System.out.println(metadata.toString());
        producer.close();
    }


}
