package com.java.study.chapter15;

import org.apache.http.annotation.GuardedBy;

public class SimulatedCAS {
    @GuardedBy("this")
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized int comepareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }


    public synchronized boolean aompareAndSet(int expectedValue, int newValue) {
        return (expectedValue == comepareAndSwap(expectedValue, newValue));
    }

}
