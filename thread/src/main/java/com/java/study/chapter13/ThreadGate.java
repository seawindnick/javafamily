package com.java.study.chapter13;

import org.apache.http.annotation.GuardedBy;

public class ThreadGate {

    @GuardedBy("this")
    private boolean isOpen;
    @GuardedBy("this")
    private int generation;

    public synchronized void close() {
        isOpen = false;
    }

    public synchronized void open() {
        ++generation;
        isOpen = true;
        notifyAll();
    }


    public synchronized void await() throws InterruptedException {
        int availableGeneration = generation;
        while (!isOpen && availableGeneration == generation){
            wait();
        }
    }
}
