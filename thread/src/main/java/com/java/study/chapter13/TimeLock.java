package com.java.study.chapter13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock(3, TimeUnit.SECONDS);
        try {
            Thread.sleep(7000);
            System.out.println("哈哈");
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("出现异常");
        }finally {
            reentrantLock.unlock();
        }

    }
}
