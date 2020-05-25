package com.java.study;

import com.java.study.consumer.KafkaConsumer;
import com.java.study.producer.KafkaProducer;

public class ConsumerTest {

    public static void main(String[] args) {
        new Thread(new KafkaProducer()).start();
        new Thread(new KafkaConsumer()).start();

    }
}
