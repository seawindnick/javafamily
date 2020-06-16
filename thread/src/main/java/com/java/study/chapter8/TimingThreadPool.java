/*
package com.java.study.chapter8;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class TimingThreadPool extends ThreadPoolExecutor {
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final Logger logger = Logger.getLogger("TimingThreadPool");
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();



    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    protected void beforeExecute(Thread t, Runnable r){
        super.beforeExecute(t,r);
        logger.fine(String.format("Thread %s : start %s",t,r));
        System.out.println(String.format("Thread %s : start %s",t,r));
        startTime.set(System.nanoTime());
    }

    protected void afterExecute(Runnable t,Throwable r){
        try{
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            logger.fine(String.format("Thread %s  : end %s, time %dns",t,r,taskTime));
            System.out.println(String.format("Thread %s  : end %s, time %dns",t,r,taskTime));
        }finally {
            super.afterExecute(t,r);
        }
    }

    protected void terminated(){
        try {
            logger.info(String.format("Terminated : avg time = %dns",totalTime.get()/numTasks.get()));
            System.out.println(String.format("Terminated : avg time = %dns",totalTime.get()/numTasks.get()));
        }finally {
            super.terminated();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TimingThreadPool timingThreadPool = new TimingThreadPool(2, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(200), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                executor.submit(r);
            }
        });
        for (int i = 0; i < 100; i++) {
            timingThreadPool.submit(new Task(i));
        }
        Thread.sleep(10000);
        timingThreadPool.shutdownNow();

    }


    public static class Task implements Callable{

        private int name;

        public Task(int name) {
            this.name = name;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}



*/
