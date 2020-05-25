package com.java.study.consumer;

import com.java.study.util.KafkaUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;

public class KafkaConsumer implements Runnable {


    @Override
    public void run() {
        org.apache.kafka.clients.consumer.KafkaConsumer<String,String> consumer = KafkaUtil.consumerInstance();

        while (true){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000));

            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record);
            }

        }

    }
}
