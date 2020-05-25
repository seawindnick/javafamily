package com.java.study.expireMsg;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.apache.shiro.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ExpireMessageIntercept implements ConsumerInterceptor<String, String> {

    private static final long EXPIRE_INTERVAL = 10 * 1000;

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords consumerRecords) {
        long currentTime = System.currentTimeMillis();
        Map<TopicPartition, List<ConsumerRecord<String, String>>> newRecords = new HashMap<>();
        Set<TopicPartition> topicPartitionSet = consumerRecords.partitions();
        for (TopicPartition topicPartition : topicPartitionSet) {
            List<ConsumerRecord<String, String>> list = consumerRecords.records(topicPartition);
            if (!CollectionUtils.isEmpty(list)) {
                list = list.stream().filter(consumerRecord ->
                        currentTime - consumerRecord.timestamp() < EXPIRE_INTERVAL
                ).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(list)) {
                    newRecords.put(topicPartition, list);
                }
            }
        }

        return new ConsumerRecords<>(newRecords);
    }

    @Override
    public void close() {

    }

    @Override
    public void onCommit(Map map) {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
