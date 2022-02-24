package com.study;

import org.junit.Test;
import org.junit.internal.runners.statements.RunAfters;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <Description>
 *
 * @author hushiye
 * @since 1/22/22 16:29
 */
public class YieldTest {

    private static volatile Map<String, AtomicInteger> counter = new ConcurrentHashMap<>();


    static class Y implements Runnable {

        private String name;

        private boolean isYield;

        public Y(String name, boolean isYield) {
            this.name = name;
            this.isYield = isYield;
        }

        @Override
        public void run() {
            long l = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                if (isYield) {
                    Thread.yield();
                }

                AtomicInteger atomicInteger = counter.get(name);
                if (atomicInteger == null) {
                    counter.put(name, new AtomicInteger(1));
                    continue;
                }

                atomicInteger.addAndGet(1);
                counter.put(name, atomicInteger);
            }

            System.out.println("线程编号:" + name + ",执行完成耗时" + (System.currentTimeMillis() - l) + "毫秒," + (isYield ? "让出CPU" : "不让CPU"));


        }
    }

    @Test
    public void test() throws InterruptedException {

        for (int i = 0; i < 500; i++) {
            if (i < 100){
                new Thread(new Y(String.valueOf(i),true)).start();
                continue;
            }

            new Thread(new Y(String.valueOf(i),false)).start();
        }


        Thread.sleep(10000);

    }


}
