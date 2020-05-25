package com.java.study;

import com.java.study.offset.OffSetConsumer;
import com.java.study.producer.KafkaProducer;

public class OffsetTest {
    public static void main(String[] args) {
        new KafkaProducer().run();
        new OffSetConsumer().run();

    }
}
