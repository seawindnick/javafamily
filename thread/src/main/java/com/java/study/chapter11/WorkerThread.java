package com.java.study.chapter11;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread {
    private final BlockingQueue<Runnable> queue;

    public WorkerThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }


    public void run(){
        while (true){
            try {
                Runnable runnable = queue.take();//从队列中获取数据，串行部分
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
