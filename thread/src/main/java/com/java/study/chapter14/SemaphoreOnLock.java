package com.java.study.chapter14;

import org.apache.http.annotation.GuardedBy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreOnLock {

    private final Lock lock = new ReentrantLock();
    private final Condition permitsAvailavle = lock.newCondition();

    @GuardedBy("this")
    private int permits;


    SemaphoreOnLock(int initialPermits) {
        lock.lock();
        try {
            permits = initialPermits;
        } finally {
            lock.unlock();
        }
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permits <= 0) {
                permitsAvailavle.await();
            }
            --permits;
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            ++permits;
            permitsAvailavle.signal();
        } finally {
            lock.unlock();
        }
    }
}
