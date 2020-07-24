package com.java.study.zuo.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Queue2Stack2 {

    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();


    public void push(int value){
        queue.add(value);
    }


    public int pop(){
        if (queue.isEmpty()){
            throw new IllegalArgumentException("无数据");
        }

        while (queue.size() != 1){
            help.add(queue.poll());
        }
        int value = queue.poll();
        swap();
        return value;
    }

    public int peek(){
        if (queue.isEmpty()){
            throw new IllegalArgumentException("无数据");
        }

        while (queue.size() != 1){
            help.add(queue.poll());
        }
        int value = queue.poll();
        help.add(value);
        swap();
        return value;

    }

    private void swap() {
        Queue temp = queue;
        queue = help;
        help = temp;
    }

    public static void main(String[] args) {
        Queue2Stack2 queue2Stack2 = new Queue2Stack2();
        for (int i = 0; i < 10 ; i++) {
            queue2Stack2.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue2Stack2.peek());
        }
    }
}
