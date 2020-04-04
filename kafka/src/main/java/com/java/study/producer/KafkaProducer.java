package com.java.study.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducer implements Runnable {
    public static final String brokerList = "10.26.15.206:9092";
    public static final String topic = "topic-demo";
    public static org.apache.kafka.clients.producer.KafkaProducer<String, String> kafkaProducer;

    static {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello,kafka" + i);
            try {
                kafkaProducer.send(record);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }
}
