package com.java.study.chapter6;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @Auther: hushiye
 * @Date: 2019/4/19
 * @Description:
 */
public class ThreadPoolExecutorUtil {

    private static volatile ThreadPoolExecutor threadPool = null;

    private static volatile ThreadPoolExecutor retryThreadPool = null;

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        if (Objects.nonNull(threadPool)) {
            return threadPool;
        }

        synchronized (ThreadPoolExecutorUtil.class) {
            if (Objects.isNull(threadPool)) {
                BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(1000);// 队列数
                threadPool = new ThreadPoolExecutor(50, 90, 0L, TimeUnit.MILLISECONDS,
                        queue);
                threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {

                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        try {
                            executor.getQueue().put(r);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            return threadPool;
        }
    }


    public static ThreadPoolExecutor getRetryThreadPoolExecutor() {
        if (Objects.nonNull(retryThreadPool)) {
            return retryThreadPool;
        }

        synchronized (ThreadPoolExecutorUtil.class) {
            if (Objects.isNull(retryThreadPool)) {
                BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100);// 队列数
                retryThreadPool = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS,
                        queue);
                retryThreadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {

                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        try {
                            executor.getQueue().put(r);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            return retryThreadPool;
        }
    }
}
