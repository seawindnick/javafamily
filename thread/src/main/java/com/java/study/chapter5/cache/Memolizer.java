package com.java.study.chapter5.cache;

import org.apache.http.annotation.GuardedBy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Memolizer<A, V> implements Comutable<A, V> {

    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<A, V>();

    private final Comutable<A, V> c;

    public Memolizer(Comutable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException, ExecutionException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
