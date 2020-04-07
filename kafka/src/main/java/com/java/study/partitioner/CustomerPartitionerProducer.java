package com.java.study.partitioner;

import com.java.study.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.Future;

public class CustomerPartitionerProducer {

    public static final String brokerList = "10.26.15.206:9092";
    public static final String topic = "topic-demo";
    public static org.apache.kafka.clients.producer.KafkaProducer<String, String> kafkaProducer;
    public static final String clientId = "producer.client.id.demo";

    static {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, clientId);
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomerPartitioner.class.getName());
        kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, i + "", "hello,有key的kafka" + i);
            try {
                kafkaProducer.send(record, new KafkaProducer.KafkaMessageCallback(record)).get();
                record = new ProducerRecord<>(topic, i + "", "hello,有key的kafka" + i);
                kafkaProducer.send(record, new KafkaProducer.KafkaMessageCallback(record)).get();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }


}
