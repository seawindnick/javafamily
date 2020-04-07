package com.java.study;

import com.java.study.customerserializer.CompanyConsumer;
import com.java.study.customerserializer.CompanyProducer;

public class CompanyDeserializerTest {
    public static void main(String[] args) {
        new Thread(new CompanyProducer()).start();
        new Thread(new CompanyConsumer()).start();
    }
}
