package com.java.study.chapter5.cache;

import org.apache.http.annotation.GuardedBy;

import java.util.Map;
import java.util.concurrent.*;

public class Memolizer3<A, V> implements Comutable<A, V> {

    @GuardedBy("this")
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Comutable<A, V> c;

    public Memolizer3(Comutable<A, V> c) {
        this.c = c;
    }

    /**
     * 将执行Future 放入缓存，如果发现，说明正在执行，等待执行结果即可
     *
     * 问题
     * 1。非原子的先检查后执行，两个线程仍然可能在同一时间调用compute计算相同的值
     * 2。存储占用内存变大
     * @param arg
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };

            FutureTask<V> ft = new FutureTask<>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run();
        }

        try {
            return f.get();
        } catch (ExecutionException e) {
            throw e;
        }

    }
}
