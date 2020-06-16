package com.java.study.chapter7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BrokenPrimerProducerCancel extends Thread {

    private final BlockingQueue<BigInteger>  queue;
    private volatile boolean cancelled = false;


    public BrokenPrimerProducerCancel(BlockingQueue<BigInteger>  queue){
        this.queue = queue;
    }

    public void cancel() {
        cancelled = true;
    }

    public void run() {
        BigInteger p = BigInteger.ONE;
        int i = 0;
        while (true) {
            try {
                System.out.println(i);
                i ++;
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<>(100);
        BrokenPrimerProducerCancel brokenPrimerProducer = new BrokenPrimerProducerCancel(queue);
        brokenPrimerProducer.start();
        Thread.sleep(1000);
        System.out.println(brokenPrimerProducer.isInterrupted());
        brokenPrimerProducer.interrupt();
        System.out.println(brokenPrimerProducer.isInterrupted());
        brokenPrimerProducer.start();
        BrokenPrimerProducerCancel.interrupted();

//        brokenPrimerProducer.cancel();

    }



}
