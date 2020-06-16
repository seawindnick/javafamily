package com.java.study.chapter5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Work implements Runnable {
    private CountDownLatch countDownLatch;
    private String name;

    public Work(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        this.dowork();

        try {
            TimeUnit.SECONDS.sleep(new Random(10).nextInt());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }

    }

    private void dowork() {
        System.out.println(this.name + "活儿干完了");
    }
}
