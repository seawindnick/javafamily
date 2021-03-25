package com.java.study.algorithm.zuo.abasic.basic_class_03;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 如何仅用队列结构实现栈结构?
 * 如何仅用栈结构实现队列结构?
 */
public class Code_03_StackAndQueueConvert {

    /**
     * 队列转换成栈
     */
    public static class QueueToStack {
        private Queue<Integer> firstQueue;
        private Queue<Integer> secondQueue;


        public QueueToStack() {
            this.firstQueue = new LinkedList<>();
            this.secondQueue = new LinkedList<>();
        }

        public void add(Integer value) {
            Queue addQueue = firstQueue.isEmpty() ? secondQueue : firstQueue;
            addQueue.add(value);
        }


        public Integer pop() {
            if (firstQueue.isEmpty() && secondQueue.isEmpty()) {
                throw new IllegalArgumentException("栈中没有元素");
            }

            Queue<Integer> popQueue = firstQueue.isEmpty() ? secondQueue : firstQueue;
            Queue<Integer> transQueue = firstQueue.isEmpty() ? firstQueue : secondQueue;
            while (popQueue.size() != 1) {
                transQueue.add(popQueue.poll());
            }

            return popQueue.poll();
        }

        public Integer peek() {
            if (firstQueue.isEmpty() && secondQueue.isEmpty()) {
                throw new IllegalArgumentException("栈中没有元素");
            }

            Queue<Integer> popQueue = firstQueue.isEmpty() ? secondQueue : firstQueue;
            Queue<Integer> transQueue = firstQueue.isEmpty() ? firstQueue : secondQueue;
            while (popQueue.size() != 1) {
                transQueue.add(popQueue.poll());
            }
            int result = popQueue.poll();
            transQueue.add(result);

            return result;
        }


    }

    /**
     * 栈转换成队列
     */
    public static class StackToQueue {

        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public StackToQueue() {
            this.popStack = new Stack<>();
            this.pushStack = new Stack<>();
        }


        public void push(Integer value) {
            pushStack.push(value);
        }

        public Integer pop() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new IllegalArgumentException("队列中没有元素");
            }

            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }


        public Integer peek() {

            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new IllegalArgumentException("队列中没有元素");
            }

            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            int result = popStack.pop();
            popStack.push(result);
            return result;

        }

    }

    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        for (int i = 0; i < 10; i++) {
            queueToStack.add(i);
        }
        System.out.println("peek:" + queueToStack.peek());//9

        for (int i = 0; i < 5; i++) {
            System.out.println(queueToStack.pop());
        }

        for (int i = 0; i < 10; i++) {
            queueToStack.add(i);
        }
        System.out.println("peek:" + queueToStack.peek());//9

        for (int i = 0; i < 15; i++) {
            System.out.println(queueToStack.pop());
        }

//        StackToQueue stackToQueue = new StackToQueue();
//        for (int i = 0; i < 10; i++) {
//            stackToQueue.push(i);
//        }
//        System.out.println("peek:" + stackToQueue.peek());//0
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(stackToQueue.pop());
//        }
//
//        System.out.println("peek:" + stackToQueue.peek());//5
//        for (int i = 0; i < 10; i++) {
//            stackToQueue.push(i);
//        }
//
//        System.out.println("peek:" + stackToQueue.peek());//5
//        for (int i = 0; i < 15; i++) {
//            System.out.println(stackToQueue.pop());
//        }
    }


}