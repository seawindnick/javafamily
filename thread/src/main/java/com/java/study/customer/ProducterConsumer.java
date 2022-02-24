package com.java.study.customer;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <Description>
 *
 * @author hushiye
 * @since 8/11/21 17:16
 */
public class ProducterConsumer {

    private static Lock fullConditionLock = new ReentrantLock();
    private static Lock emptyConditionLockLock = new ReentrantLock();
    //    static Condition fullCondition = lock.newCondition();
//    static Condition emptyCondition = lock.newCondition();
    static LinkedList<Integer> food = new LinkedList<>();
    static AtomicInteger atomicInteger = new AtomicInteger();


    /**
     * 生产者线程
     */
    public static class ProducerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (ProducterConsumer.class) {
                    if (food.size() == 10) {
                        continue;
                    } else {
                        Integer temp = atomicInteger.getAndIncrement();
                        System.out.println("生产了:" + temp);
                        food.add(temp);
                    }
                }
            }
        }
    }


    public static class ConsumerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (ProducterConsumer.class) {
                    if (food.size() == 0) {
                        continue;
                    } else {
                        System.out.println("消费了:" + food.poll());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new ConsumerThread().start();
        new ProducerThread().start();
    }

}
