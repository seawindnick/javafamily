package com.java.study.chapter8.semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    private SemaphoreService semaphoreService;

    public MyThread(String name, SemaphoreService semaphoreService) {
        super();
        this.setName(name);
        this.semaphoreService = semaphoreService;
    }


    @Override
    public void run() {
        this.semaphoreService.doSomething();
    }


    public static class SemaphoreService {

        private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss:SSS");
        //总信号量数量
        private Semaphore semaphore = new Semaphore(6);

        public void doSomething() {
            try {
                //每次执行需要使用信号量数量，当信号量不足时，进行等待
                semaphore.acquire(2);
                System.out.println(Thread.currentThread().getName() + ":doSomething start - " + getFormatTimeStr());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + ":doSomething end - " + getFormatTimeStr());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //执行完毕释放信号量数量
                semaphore.release(2);
            }
        }

        private String getFormatTimeStr() {
            return sf.format(new Date());
        }

    }

    public static void main(String[] args) {
        SemaphoreService semaphoreService = new SemaphoreService();
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread("thread" + i, semaphoreService);
            myThread.start();
        }
    }
}
