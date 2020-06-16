package com.java.study.chapter7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InterruptedTest extends Thread {
    private final BlockingQueue<BigInteger> queue;

    public InterruptedTest(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        this.getNextTask(queue);
    }

    private BigInteger getNextTask(BlockingQueue<BigInteger> queue) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                    //do somethings
                    System.out.println("重试信息");
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<BigInteger> bigIntegers = new ArrayBlockingQueue<BigInteger>(10);
        InterruptedTest interruptedTest = new InterruptedTest(bigIntegers);
        interruptedTest.start();
        Thread.sleep(10000);
        interruptedTest.interrupt();

    }


}
