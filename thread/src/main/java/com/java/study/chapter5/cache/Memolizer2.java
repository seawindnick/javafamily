package com.java.study.chapter5.cache;

import org.apache.http.annotation.GuardedBy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

public class Memolizer2<A, V> implements Comutable<A, V> {

    @GuardedBy("this")
    private final Map<A, V> cache = new ConcurrentHashMap<>();

    private final Comutable<A, V> c;

    public Memolizer2(Comutable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        V result = cache.get(arg);
        if (result == null) {
            /**
             * 多个线程可能会同时进入这一段
             * 一个线程开启了计算，其他线程并不知道，又进行重复计算
             */
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
