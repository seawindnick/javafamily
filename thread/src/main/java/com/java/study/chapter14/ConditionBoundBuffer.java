package com.java.study.chapter14;

import org.apache.http.annotation.GuardedBy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBoundBuffer<T> {

    protected final Lock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();

    @GuardedBy("lock")
    private final Condition notEmpty = lock.newCondition();

    @GuardedBy("lock")
    private final T[] items = (T[]) new Object[10];

    @GuardedBy("lock")
    private int tail, head, count;

    public void put(T x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                System.out.println(Thread.currentThread().getName() + "开始等待");
                notFull.await();
            }
            items[tail] = x;
            if (++tail == items.length) {
                tail = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println(Thread.currentThread().getName() + "开始等待");
                notEmpty.await();
            }

            T x = items[head];
            items[head] = null;
            if (++head == items.length) {
                head = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }

    }




}
