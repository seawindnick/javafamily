package com.java.study.seek;

import com.java.study.util.KafkaUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndTimestamp;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;

public class SeekConsumer implements Runnable {
    @Override
    public void run() {
        KafkaConsumer consumer = KafkaUtil.consumerInstance();


//        consumer.poll(Duration.ofMillis(10000));//需要存在
//        Set<TopicPartition> assignment = consumer.assignment();
        /**
         * poll方法参数为0时，此方法立即返回，poll()内部进行分区分配的逻辑会来不及实施
         * 消费者此时并未分配到任何分区
         * consumer.assignment 返回的是空列表
         * timeout参数设置太短会使分配分区动作失败，太长可能会造成不必要的等待
         */


        //优化为
        Set<TopicPartition> assignment = new HashSet<>();
        while (assignment.size() == 0) {
            consumer.poll(Duration.ofMillis(100));
            assignment = consumer.assignment();
        }


        for (TopicPartition topicPartition : assignment) {
            consumer.seek(topicPartition, 10);
        }
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.offset() + ":" + record.partition() + ":" + record.value());
            }
        }

    }


    public void endOffsets() {
        KafkaConsumer kafkaConsumer = KafkaUtil.consumerInstance();
        Set<TopicPartition> assignment = new HashSet<>();
        while (assignment.size() == 0) {
            kafkaConsumer.poll(Duration.ofMillis(100));
            assignment = kafkaConsumer.assignment();
        }

//        Map<TopicPartition, Long> offsets = kafkaConsumer.endOffsets(assignment);//获取指定分区末尾的消息位置
        Map<TopicPartition, Long> beginningOffSets = kafkaConsumer.beginningOffsets(assignment);//获取指定分区起始位置

        for (TopicPartition topicPartition : assignment) {
            kafkaConsumer.seek(topicPartition, beginningOffSets.get(topicPartition));
        }

        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.offset() + ":" + record.partition() + ":" + record.value());
            }
        }

    }


    public void preMsgConsumer() {
        KafkaConsumer consumer = KafkaUtil.consumerInstance();
        Set<TopicPartition> assignment = new HashSet<>();
        while (assignment.size() == 0) {
            consumer.poll(Duration.ofMillis(100));
            assignment = consumer.assignment();
        }

        Map<TopicPartition, Long> timestampToSearch = new HashMap<>();
        for (TopicPartition topicPartition : assignment) {
            timestampToSearch.put(topicPartition, System.currentTimeMillis() - 1 * 24 * 60 * 60 * 1000);
        }

        Map<TopicPartition, OffsetAndTimestamp> offsets = consumer.offsetsForTimes(timestampToSearch);
        for (TopicPartition topicPartition : assignment) {
            OffsetAndTimestamp offsetAndTimestamp = offsets.get(topicPartition);
            if (Objects.nonNull(offsetAndTimestamp)){
                consumer.seek(topicPartition,offsetAndTimestamp.offset());
            }
        }

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.offset() + ":" + record.partition() + ":" + record.value());
            }
        }

    }
}
