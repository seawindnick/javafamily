package com.java.study.chapter13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TimeOutLock {

    static Lock lock = new ReentrantLock();


    public static boolean trySendOnShareLine(long timeout, TimeUnit unit) throws InterruptedException {
        long nanosToLock = unit.toNanos(timeout) - 100;

        if (!lock.tryLock(nanosToLock, TimeUnit.NANOSECONDS)) {
            Thread.sleep(1000);
            return false;
        } else {
            Thread.sleep(1000);
            return true;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new Thread(new TestLock()).start();
        Thread.sleep(5000);
        System.out.println(trySendOnShareLine(1, TimeUnit.SECONDS));
    }

    public static class TestLock implements Runnable {

        @Override
        public void run() {
            lock.lock();
        }
    }

}
