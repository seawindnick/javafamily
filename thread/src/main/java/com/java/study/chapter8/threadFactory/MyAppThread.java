package com.java.study.chapter8.threadFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyAppThread extends Thread {

    public static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle = false;
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger log = Logger.getAnonymousLogger();

    public MyAppThread(Runnable r) {
        this(r, DEFAULT_NAME);
    }


    public MyAppThread(Runnable runnable, String name) {
        super(runnable, name + "-" + created.incrementAndGet());
        setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.log(Level.SEVERE, "UncaughtException" + t.getName(), e);
            }
        });
    }

    public void run() {
        boolean debug = debugLifecycle;
        if (debug) {
            log.log(Level.FINE, "Exiting " + getName());
            System.out.println("Exiting " + getName());
        }


        try {
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) {
                log.log(Level.FINE, "Exiting " + getName());
                System.out.println("Exiting " + getName());
            }
        }
    }


    public static int getThreadsCreated() {
        return created.get();
    }


    public static int getThreadsAlive() {
        return alive.get();
    }

    public static boolean getDebug() {
        return debugLifecycle;
    }

    public static void setDebug(Boolean b) {
        debugLifecycle = b;
    }


    public static class MyThreadFactory implements ThreadFactory{
        private final String poolName;

        public MyThreadFactory(String poolName) {
            this.poolName = poolName;
        }

        @Override
        public Thread newThread(Runnable runnable) {
            return new MyAppThread(runnable,poolName);
        }
    }

    public static class MyRunable implements Runnable{

        private final String name;

        public MyRunable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        if (executor instanceof ThreadPoolExecutor){
            ((ThreadPoolExecutor) executor).setCorePoolSize(10);
        }


//
//
//        String poolName = "测试线程池";
//        MyThreadFactory myThreadFactory = new MyThreadFactory(poolName);
//
//
//        BlockingQueue blockingQueue = new ArrayBlockingQueue(30);
//        MyAppThread.setDebug(true);
//
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(7,10,10L,TimeUnit.SECONDS,blockingQueue,myThreadFactory,new ThreadPoolExecutor.CallerRunsPolicy());
//
//        for (int i = 0; i < 100; i++) {
//            threadPoolExecutor.submit(new MyRunable(String.valueOf(i)));
//        }
    }

}
