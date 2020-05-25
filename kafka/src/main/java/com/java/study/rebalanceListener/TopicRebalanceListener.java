package com.java.study.rebalanceListener;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;

public class TopicRebalanceListener implements ConsumerRebalanceListener {

    private KafkaConsumer consumer;

    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> collection) {
        consumer.commitSync();
    }

    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> collection) {

    }
}
