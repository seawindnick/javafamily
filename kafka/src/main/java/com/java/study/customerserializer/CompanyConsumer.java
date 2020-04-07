package com.java.study.customerserializer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class CompanyConsumer implements Runnable {

    public static final String brokerList = "10.26.15.206:9092";
    public static final String topic = "topic-demo";
    public static final String groupId = "group.demo.11";


    @Override
    public void run() {
        org.apache.kafka.clients.consumer.KafkaConsumer<String,String> consumer = this.initConsumer();
        while (true){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record);
            }
        }

    }

    private KafkaConsumer<String, String> initConsumer() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,brokerList);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CompanyDeserializer.class);
        org.apache.kafka.clients.consumer.KafkaConsumer<String,String>  consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<String, String>(properties);
        //创建一个消费者客户端实例
        consumer =  new org.apache.kafka.clients.consumer.KafkaConsumer(properties);
        consumer.subscribe(Collections.singleton(topic));
        return consumer;

    }


}
