package com.java.study.rebalanceListener;

import com.java.study.util.KafkaUtil;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RebalanceListenerConsumer implements Runnable{

    @Override
    public void run() {

        Map<TopicPartition, OffsetAndMetadata> currentOffSets = new HashMap<>();
        KafkaConsumer consumer = KafkaUtil.consumerInstance();
        consumer.subscribe(Arrays.asList(KafkaUtil.topic), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
                consumer.commitSync(currentOffSets);
                currentOffSets.clear();
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {

            }
        });


        try {
            while (true){
                ConsumerRecords<String,String> consumerRecords = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord consumerRecord : consumerRecords) {
                    currentOffSets.put(new TopicPartition(consumerRecord.topic(),consumerRecord.partition()),new OffsetAndMetadata(consumerRecord.offset() + 1));

                }
                consumer.commitSync(currentOffSets);
            }
        }finally {
            consumer.close();
        }


    }
}
