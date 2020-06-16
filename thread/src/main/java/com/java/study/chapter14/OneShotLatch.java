package com.java.study.chapter14;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class OneShotLatch {
    private Sync sync = new Sync();
    public void signal(){
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected int tryAcquireShared(int arg) {
            //如果闭锁是开的。那么该操作将成功，否则失败
            return (getState() == 1) ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            /**
             * 0 关闭
             * 1 打开
             */
            setState(1);//打开闭锁
            return true;//其他线程都可以获取该闭锁
        }
    }

}
