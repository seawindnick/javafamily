package com.java.study.chapter14;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class ReentrantLockAcquire extends AbstractQueuedSynchronizer {

    private Thread owner;
    @Override
    protected boolean tryAcquire(int arg) {
        final Thread current = Thread.currentThread();
        int c = getState();
        if (c == 0){
            if (compareAndSetState(0,1)){
                owner = current;
                return true;
            }
        }else if (owner == current){
            setState(c+1);
            return true;
        }

        return false;
    }
}
