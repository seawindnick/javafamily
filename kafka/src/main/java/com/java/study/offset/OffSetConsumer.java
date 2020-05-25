package com.java.study.offset;

import com.java.study.util.KafkaUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class OffSetConsumer implements Runnable {


    @Override
    public void run() {
        org.apache.kafka.clients.consumer.KafkaConsumer<String,String> consumer = KafkaUtil.consumerNoTopic();


        TopicPartition tp = new TopicPartition(KafkaUtil.topic,0);
        consumer.assign(Arrays.asList(tp));
        long lastConsumedOffset = -1;
        while (true){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(1000));
            if (records.isEmpty()){
                break;
            }

            List<ConsumerRecord<String,String>> partitionRecords = records.records(tp);
            lastConsumedOffset = partitionRecords.get(partitionRecords.size()-1).offset();
            consumer.commitSync();

        }

        System.out.println("comsumed offset is " + lastConsumedOffset);
        OffsetAndMetadata offsetAndMetadata = consumer.committed(tp);
        System.out.println("commited offset is " + offsetAndMetadata.offset());
        long posititon = consumer.position(tp);

        System.out.println("the offset of the next record is " + posititon);
    }


}
