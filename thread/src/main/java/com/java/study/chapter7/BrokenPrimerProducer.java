package com.java.study.chapter7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BrokenPrimerProducer extends Thread {

    private final BlockingQueue<BigInteger>  queue;
    private volatile boolean cancelled = false;


    public BrokenPrimerProducer(BlockingQueue<BigInteger>  queue){
        this.queue = queue;
    }

    public void cancel() {
        cancelled = true;
    }

    public void run() {
        BigInteger p = BigInteger.ONE;
        int i = 0;
        while (!cancelled) {
            try {
                System.out.println(i);
                i ++;
                queue.put(p = p.nextProbablePrime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<>(100);
        BrokenPrimerProducer brokenPrimerProducer = new BrokenPrimerProducer(queue);
        brokenPrimerProducer.start();
        Thread.sleep(1000);
        System.out.println(brokenPrimerProducer.isInterrupted());
        brokenPrimerProducer.cancel();
        brokenPrimerProducer.interrupt();
        System.out.println(brokenPrimerProducer.isInterrupted());
        brokenPrimerProducer.start();
        BrokenPrimerProducer.interrupted();

//        brokenPrimerProducer.cancel();

    }



}
