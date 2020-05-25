package com.java.study.producer;

import com.java.study.util.KafkaUtil;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Objects;
import java.util.concurrent.Future;

public class KafkaProducer implements Runnable {

    @Override
    public void run() {
        org.apache.kafka.clients.producer.KafkaProducer<String, String> kafkaProducer = KafkaUtil.producerInstance();
        for (int i = 0; i < 100; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(KafkaUtil.topic, i+"","hello,kafka" + i);
            try {
                Future<RecordMetadata> future = kafkaProducer.send(record);
                RecordMetadata recordMetadata = future.get();
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
