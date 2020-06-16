package com.java.study.chapter13;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer {

    private static Lock lock = new ReentrantLock();
    private static Condition fullCondition = lock.newCondition();
    private static Condition emptyCondition = lock.newCondition();
    private static ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(2);


    public static void main(String[] args) {
        new Thread(new ProdcerRunable()).start();
        new Thread(new ConsumerRunable()).start();
    }


    private static class ConsumerRunable implements Runnable {

        @Override
        public void run() {
            while (true){
                lock.lock();

                try {
                    while (arrayBlockingQueue.size() != 2){
                            fullCondition.await();
                    }

                    while (arrayBlockingQueue.size() != 0) {
                        Integer t = null;
                        try {
                            t = arrayBlockingQueue.take();
                            System.out.println("消费了:" + t);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    emptyCondition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }
    }

    private static class ProdcerRunable implements Runnable {
        @Override
        public void run() {

            while (true){
                lock.lock();
                try {
                    while (arrayBlockingQueue.size() != 0){
                        emptyCondition.await();;
                    }
                    for (int i = 0; i < 2; i++) {
                        System.out.println(50);
                        arrayBlockingQueue.put(50);
                    }

                    fullCondition.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }

        }
    }


}
