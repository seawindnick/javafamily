package com.java.study.util;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Collections;
import java.util.Properties;

public class KafkaUtil {

    public static final String brokerList = "kafka118-online.zeus.ljnode.com:9092,kafka119-online.zeus.ljnode.com:9092,kafka120-online.zeus.ljnode.com:9092";
    public static final String topic = "beijia-settle-detail-event-change";
    public static final String clientId = "producer.client.id.demo";
    public static final String groupId = "group.demo.11112121111";

   public static org.apache.kafka.clients.producer.KafkaProducer<String, String> producerInstance(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,clientId);
        org.apache.kafka.clients.producer.KafkaProducer<String, String> kafkaProducer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);

        return kafkaProducer;
    }




    public static org.apache.kafka.clients.consumer.KafkaConsumer<String,String> consumerInstance(){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,brokerList);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        org.apache.kafka.clients.consumer.KafkaConsumer<String,String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<String, String>(properties);
        //创建一个消费者客户端实例
        consumer =  new org.apache.kafka.clients.consumer.KafkaConsumer(properties);
        consumer.subscribe(Collections.singleton("store-manager-take-money"));
        return consumer;

    }


    public static KafkaConsumer<String, String> consumerNoTopic() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,brokerList);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        properties.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,5000);
        org.apache.kafka.clients.consumer.KafkaConsumer<String,String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<String, String>(properties);
        //创建一个消费者客户端实例
        consumer =  new org.apache.kafka.clients.consumer.KafkaConsumer(properties);
        return consumer;
    }
}
