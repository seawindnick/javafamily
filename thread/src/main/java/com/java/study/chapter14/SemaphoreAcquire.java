package com.java.study.chapter14;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SemaphoreAcquire extends AbstractQueuedSynchronizer {


    @Override
    protected int tryAcquireShared(int acquires) {
        while (true) {
            int available = getState();
            int remaining = available - acquires;
            if (remaining < 0 || compareAndSetState(available, remaining)) {
                return remaining;
            }
        }
    }


    @Override
    protected boolean tryReleaseShared(int releases) {
        while (true) {
            int p = getState();
            if (compareAndSetState(p, p + releases)) {
                return true;
            }
        }
    }
}
