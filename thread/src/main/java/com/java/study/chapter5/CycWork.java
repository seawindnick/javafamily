package com.java.study.chapter5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycWork implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String name;

    public CycWork(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "正在做什么");
        try {
            Thread.sleep(5000);
            System.out.println(name + "终于做完了");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + ":其他人在做什么");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        CycWork work1= new CycWork(cyclicBarrier, "张三" );
        CycWork work2= new CycWork(cyclicBarrier, "李四" );
        CycWork work3= new CycWork(cyclicBarrier, "王五" );
        CycWork work4= new CycWork(cyclicBarrier, "麻溜" );

        new Thread(work1).start();
        new Thread(work2).start();
        new Thread(work3).start();
        new Thread(work4).start();

        Thread.sleep(10000);

    }
}
