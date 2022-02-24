package com.java.study.customer;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <Description>
 *
 * @author hushiye
 * @since 8/11/21 17:33
 */
public class ProducterConsumer2 {
    private static Lock lock = new ReentrantLock();
    static Condition fullCondition = lock.newCondition();
    static Condition emptyCondition = lock.newCondition();
    static LinkedList<Integer> food = new LinkedList<>();
    static AtomicInteger atomicInteger = new AtomicInteger();


    /**
     * 生产者线程
     */
    public static class ProducerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (food.size() == 10) {
                        emptyCondition.await();
                    }
                    Integer temp = atomicInteger.getAndIncrement();
                    System.out.println("生产了:" + temp);
                    food.add(temp);
                    fullCondition.signalAll();

                } catch (Exception ex) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }


    public static class ConsumerThread extends Thread {
        @Override
        public void run() {
            while (true) {

                try {
                    lock.lock();
                    while (food.size() == 0) {
                        fullCondition.await();
                    }
                    System.out.println("消费了:" + food.poll());
                    emptyCondition.signalAll();

                } catch (Exception ex) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ConsumerThread().start();
        new ProducerThread().start();
    }

}
