package com.java.study.zuo.stack;

import java.util.Stack;

/**
 * 使用栈实现队列
 */
public class Stack2QueueConvert {
    private Stack<Integer> inputStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();



    public void push(int value){
        inputStack.push(value);
    }

    public int pop(){
        if (inputStack.isEmpty() && outStack.isEmpty()){
            throw new IllegalArgumentException("集合中没有任何元素");
        }
        refresh();
        return outStack.pop();

    }

    private void refresh() {
        if (outStack.isEmpty()){
            System.out.println("发生灌水");
            while (!inputStack.isEmpty()){
                outStack.push(inputStack.pop());
            }
        }
    }

    public int peek(){
        if (inputStack.isEmpty() && outStack.isEmpty()){
            throw new IllegalArgumentException("集合中没有任何元素");
        }
        refresh();
        return outStack.peek();
    }

    public static void main(String[] args) {
        Stack2QueueConvert stack2QueueConvert = new Stack2QueueConvert();
        for (int i = 0; i < 10; i++) {
            stack2QueueConvert.push(i);
        }

        for (int i = 0; i < 8; i++) {
            System.out.println(stack2QueueConvert.pop());
        }

        for (int i = 0; i < 5; i++) {
            stack2QueueConvert.push(i);
        }

        for (int i = 0; i < 7; i++) {
            System.out.println(stack2QueueConvert.pop());
        }

    }





}
