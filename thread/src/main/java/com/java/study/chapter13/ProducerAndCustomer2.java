package com.java.study.chapter13;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndCustomer2 {

    private static final int MAX_SIZE = 10;
    private static final BlockingQueue<String> queue = new ArrayBlockingQueue(MAX_SIZE);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Producer());
        Thread thread2 = new Thread(new Consumer());

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();

        Thread.sleep(1000000);

    }


    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == MAX_SIZE) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        System.out.println("生产了:" + i);
                        try {
                            queue.put(String.valueOf(i));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.notifyAll();
                }
            }

        }
    }


    static class Consumer implements Runnable {

        @Override
        public void run() {

            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    while (queue.size() != 0) {
                        try {
                            String value = queue.take();
                            System.out.println("消费了" + value);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.notifyAll();
                }
            }
        }

    }
}
