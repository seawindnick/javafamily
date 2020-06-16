package com.java.study.chapter5;

import java.util.concurrent.CountDownLatch;

public class Boss implements Runnable {
    private CountDownLatch countDownLatch;

    public Boss(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("老板等待所有人干完活");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("工人干完活了");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Work work1 = new Work(countDownLatch," 张三");
        Work work2 = new Work(countDownLatch," 李四");
        Work work3 = new Work(countDownLatch,"王五");

        Boss boss = new Boss(countDownLatch);
        new Thread(boss).start();
        new Thread(work1).start();
        new Thread(work2).start();
        new Thread(work3).start();

        Thread.sleep(1000000);

    }
}
