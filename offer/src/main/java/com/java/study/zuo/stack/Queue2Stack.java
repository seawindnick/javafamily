package com.java.study.zuo.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 */
public class Queue2Stack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();


    public void push(int value) {
        Queue pushQueue = !queue1.isEmpty() ? queue1 : queue2;
        pushQueue.add(value);
    }


    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new IllegalArgumentException("无元素");
        }

        Queue<Integer> hasElementQueue = !queue1.isEmpty() ? queue1 : queue2;
        Queue<Integer> noElementQueue = queue1.isEmpty() ? queue1 : queue2;


        while (!hasElementQueue.isEmpty()){
            int value = hasElementQueue.poll();
            if (hasElementQueue.isEmpty()){
                return value;
            }
            noElementQueue.add(value);
        }
        return Integer.MIN_VALUE;
    }


    public int peek(){
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new IllegalArgumentException("无元素");
        }

        Queue<Integer> hasElementQueue = !queue1.isEmpty() ? queue1 : queue2;
        Queue<Integer> noElementQueue = queue1.isEmpty() ? queue1 : queue2;

        while (!hasElementQueue.isEmpty()){
            int value = hasElementQueue.poll();
            noElementQueue.add(value);
            if (hasElementQueue.isEmpty()){
                return value;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Queue2Stack queue2Stacck = new Queue2Stack();

        for (int i = 0; i < 10 ; i++) {
            queue2Stacck.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue2Stacck.peek());
        }

    }

}
