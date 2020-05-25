package com.java.study;

import com.java.study.producer.KafkaProducer;
import com.java.study.topicPartition.TopicPartitionConsumer;

public class TopicPartitionTest {

    public static void main(String[] args) {
        new KafkaProducer().run();
        new TopicPartitionConsumer().run();
    }
}
