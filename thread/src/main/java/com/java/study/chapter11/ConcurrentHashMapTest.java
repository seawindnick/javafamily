package com.java.study.chapter11;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        concurrentHashMap.putIfAbsent("123","12313");

        System.out.println(concurrentHashMap.get("123"));
    }
}
