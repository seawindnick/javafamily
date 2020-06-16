package com.java.study.chapter8;

import java.util.concurrent.*;

public class BoundExecutor {

    private final Executor executor;
    private final Semaphore semaphore;

    public BoundExecutor(Executor executor, Semaphore semaphore) {
        this.executor = executor;
        this.semaphore = semaphore;
    }


    public void submitTask(final Runnable runnable) throws InterruptedException {
        semaphore.acquire();

        try {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        } catch (RejectedExecutionException ex) {
            semaphore.release();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(1);
        BoundExecutor boundExecutor = new BoundExecutor(executor, semaphore);

        for (int i = 0; i < 1000000; i++) {
            boundExecutor.submitTask(new ThreadTask(String.valueOf(i)));
        }


    }


    public static class ThreadTask implements Runnable {
        private final String str;

        public ThreadTask(String str) {
            this.str = str;
        }

        @Override
        public void run() {
            System.out.println("哈哈" + str);
        }
    }

}
