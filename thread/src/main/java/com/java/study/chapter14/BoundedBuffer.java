package com.java.study.chapter14;

public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public BoundedBuffer(int capacity) {
        super(capacity);
    }


    public synchronized void put(V v) throws InterruptedException {
        while (isFull()){
            wait();
        }
        doPut(v);
        notifyAll();
    }

    public synchronized V get() throws InterruptedException {
        while (isEmpty()){
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }
}
