package com.java.study.chapter7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }


    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                p = p.nextProbablePrime();
                System.out.println(p);
                queue.put(p);
            }
        } catch (InterruptedException ex) {
            System.out.println("线程中止");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(100);
        Thread thread = new PrimeProducer(blockingQueue);
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();

    }

}
