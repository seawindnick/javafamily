package com.java.study.chapter13;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptedLock {
    static ReentrantLock reentrantLock = new ReentrantLock();

    private void doBusiness() {
        String name = Thread.currentThread().getName();

        try {
            System.out.println(name + "开始获取锁");
            reentrantLock.lockInterruptibly();
            System.out.println(name + "得到锁");
            System.out.println(name + "开始工作");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(name + ":" + i);
            }
        } catch (InterruptedException e) {
            System.out.println(name + "被中断");
            System.out.println(name + "处理别饿的情");
        }finally {
            try {
                reentrantLock.unlock();
                System.out.println(name + "释放锁");
            }catch (Exception ex){
                System.out.println(name + "没有获得锁的线程运行结束");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        InterruptedLock interruptedLock = new InterruptedLock();

        Thread thread0 = new Thread(new Runnable() {
            @Override
            public void run() {
                interruptedLock.doBusiness();
            }
        });
        thread0.setName("线程0");


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                interruptedLock.doBusiness();
            }
        });
        thread1.setName("线1");

        thread0.start();
        Thread.sleep(10);

        thread1.start();
        Thread.sleep(100);
        thread1.interrupt();
    }

}
