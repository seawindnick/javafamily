package com.java.study.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaProducer implements Runnable {
    public static final String brokerList = "10.26.15.206:9092";
    public static final String topic = "topic-demo";
    public static org.apache.kafka.clients.producer.KafkaProducer<String, String> kafkaProducer;
    public static final String clientId = "producer.client.id.demo";

    static {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,clientId);
        kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello,kafka" + i);
            try {
                Future<RecordMetadata> future = kafkaProducer.send(record,new KafkaMessageCallback(record));
//                RecordMetadata recordMetadata = future.get();
//                System.out.println(recordMetadata);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }


    public static class KafkaMessageCallback implements Callback{
        public ProducerRecord producerRecord;

        public KafkaMessageCallback(ProducerRecord producerRecord) {
            this.producerRecord = producerRecord;
        }

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            System.out.println(producerRecord.value());
            if (Objects.nonNull(e)){
                e.printStackTrace();
            }else {
                System.out.println(recordMetadata);
            }

        }
    }
}
