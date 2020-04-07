package com.java.study.producerIntercept;

import com.java.study.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerInterceptorPrefixProducer {

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
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,ProducerInterceptorPrefix.class.getName());
        properties.put(ProducerConfig.MAX_BLOCK_MS_CONFIG,60000);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);
        kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello,kafka" + i);
            try {
                 kafkaProducer.send(record,new ProducerInterceptorPrefixProducer.KafkaMessageCallback(record));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        try {
            Thread.sleep(10009);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        kafkaProducer.close();
    }


    public static class KafkaMessageCallback implements Callback {
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
