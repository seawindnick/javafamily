package com.java.study.topicPartition;

import com.java.study.util.KafkaUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;

public class TopicPartitionConsumer implements Runnable {
    @Override
    public void run() {
        KafkaConsumer kafkaConsumer = KafkaUtil.consumerInstance();
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));

            for (TopicPartition partition : records.partitions()) {
                for (ConsumerRecord<String, String> record : records.records(partition)) {
                    System.out.println(record.partition() + " : " + record.value());

                }

            }
        }


    }


}
