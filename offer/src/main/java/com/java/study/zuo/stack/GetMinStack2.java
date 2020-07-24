package com.java.study.zuo.stack;

import java.util.Random;
import java.util.Stack;

public class GetMinStack2 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public GetMinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else if (value <= minStack.peek()) {
            minStack.push(value);
        }

        System.out.println("minStack:" + minStack.size());
    }


    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("栈中没有元素");
        }

        int value = stack.pop();

        if (minStack.peek() == value) {
            minStack.pop();
        }


        return value;

    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("栈中没有元素");
        }

        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinStack2 stack1 = new GetMinStack2();
        for (int i = 0; i < 10; i++) {
            stack1.push(new Random().nextInt(10));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack1.pop());
        }
        System.out.println(stack1.getMin());


//        GetMinStack2 stack1 = new GetMinStack2();
//        stack1.push(3);
//        System.out.println(stack1.getMin());
//        stack1.push(2);
//        System.out.println(stack1.getMin());
//        stack1.push(3);
//        System.out.println(stack1.getMin());
//        stack1.push(1);
//        System.out.println(stack1.getMin());
//        System.out.println(stack1.pop());
//        System.out.println(stack1.getMin());


    }


}
