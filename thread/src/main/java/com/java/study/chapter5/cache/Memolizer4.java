package com.java.study.chapter5.cache;

import org.apache.http.annotation.GuardedBy;

import java.util.Map;
import java.util.concurrent.*;

public class Memolizer4<A, V> implements Comutable<A, V> {

    @GuardedBy("this")
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Comutable<A, V> c;

    public Memolizer4(Comutable<A, V> c) {
        this.c = c;
    }

    /**

     缓存污染问题，计算可能被取消或者失败
     如果发现失败，将其从缓存中移除
     通过FutureTask为每个结果指定一个逾期时间，定期扫描逾期元素

     * @param arg
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @Override
    public V compute(A arg) {
        while (true){
            Future<V> f = cache.get(arg);
            if (f == null){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<>(eval);
                f = cache.putIfAbsent(arg,ft);
                if (f == null){
                    f = ft;
                    ft.run();
                }
            }

            try {
                return f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

    }
}
