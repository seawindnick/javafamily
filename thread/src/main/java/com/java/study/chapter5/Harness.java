package com.java.study.chapter5;

import java.util.concurrent.CountDownLatch;

public class Harness {

    public long timeTasks(int nThreads,final Runnable task) throws InterruptedException {
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(10);

        for (int i = 0; i < nThreads ; i++) {
            Thread t = new Thread(){
                public void run(){
                    try {
                        start.await();
                        try {
                            task.run();
                        }finally {
                            end.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        long startTime = System.currentTimeMillis();
        start.countDown();
        end.await();
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
        return endTime - startTime;

    }


    public static void main(String[] args) throws InterruptedException {
        Harness harness = new Harness();
        harness.timeTasks(10,new CountDownLatchTask());
    }


    public static class CountDownLatchTask implements Runnable{

        @Override
        public void run() {
            System.out.println("哈哈");
        }
    }

}
