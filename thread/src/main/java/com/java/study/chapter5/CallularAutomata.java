package com.java.study.chapter5;


import lombok.Data;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CallularAutomata {
    private final Board minBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CallularAutomata(Board board) {
        this.minBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                minBoard.commitNewValues();
            }
        });

        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(minBoard.getSubBoard(count,i));
        }

    }


    @Data
    public static class Board {

        private int x;
        private int y;

        private Boolean hasConverged = false;
        public void commitNewValues() {
            System.out.println("哈哈");
        }

        public Board(int count, int index) {
            this.x = count;
            this.y = index;
        }

        public Board getSubBoard(int count, int i) {
            return new Board(count,i);
        }

        public int getMaxX() {
            return x;
        }

        public int getMaxY() {
            return y;
        }

        public void setNewValue(int i, int j) {
            this.x = i;
            this.y = j;
            hasConverged = true;
        }

        public boolean hasConverged() {
            return hasConverged;
        }

        public void waitForConveragence() {

        }
    }

    public  class Worker implements Runnable{
        private Board subBoard;

        public Worker(Board subBoard) {
            this.subBoard = subBoard;
        }

        @Override
        public void run() {
            while (!subBoard.hasConverged()){
                for (int i = 0; i < subBoard.getMaxX(); i++) {
                    for (int j = 0; j < subBoard.getMaxY(); j++) {
                        System.out.println("哈哈哈哈");
                        subBoard.setNewValue(i,j);
                    }
                }

                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public void start(){
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
        minBoard.waitForConveragence();
    }

    public static void main(String[] args) {
        Board board = new Board(10,20);
        CallularAutomata callularAutomata = new CallularAutomata(board);
        callularAutomata.start();
    }

}
