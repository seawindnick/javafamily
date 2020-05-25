package com.java.study.customerserializer;

import com.java.study.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Objects;
import java.util.Properties;

public class CompanyProducer implements Runnable {
    public static final String brokerList = "10.26.15.206:9092";
    public static final String topic = "topic-demo";
    public static org.apache.kafka.clients.producer.KafkaProducer<String, Company> kafkaProducer;
    public static final String clientId = "producer.client.id.demo";

    static {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CompanySerializer.class.getName());
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, clientId);
        kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<String, Company>(properties);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Company company = Company.builder().name("hiddenkafka:" + i)
                    .address("China:" + i).build();

            ProducerRecord<String, Company> record = new ProducerRecord<>(topic, company);
            try {
                kafkaProducer.send(record, new KafkaProducer.KafkaMessageCallback(record)).get();
                System.out.println("发送完毕:" + i);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static class KafkaMessageCallback implements Callback {
        public ProducerRecord producerRecord;

        public KafkaMessageCallback(ProducerRecord producerRecord) {
            this.producerRecord = producerRecord;
        }

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            System.out.println(producerRecord.value());
            if (Objects.nonNull(e)) {
                e.printStackTrace();
            } else {
                System.out.println(recordMetadata);
            }

        }
    }
}
