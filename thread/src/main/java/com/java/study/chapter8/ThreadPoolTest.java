package com.java.study.chapter8;

import java.util.concurrent.*;

public class ThreadPoolTest {


    public static void main(String[] args) throws InterruptedException {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4), new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                try {
//                    executor.getQueue().put(r);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(new Task(i));
        }
    }

    public static class Task implements Callable {

        private int name;

        public Task(int name) {
            this.name = name;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(Thread.currentThread() + "----" + name);
//            System.out.println( name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
