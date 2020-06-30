package com.java.study.offer.stack;

import java.util.Stack;

public class StackMin {

    private static Stack<Integer> stack = new Stack();
    private static Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        push(3);
        push(5);
        push(4);
        push(2);
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
    }


    public static int min() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("栈中无数据");
        }
        return minStack.peek();
    }

    public static void push(Integer value) {
        stack.push(value);
        if (minStack.isEmpty()) {
            minStack.push(value);
            return;
        }

        Integer oldMinValue = minStack.peek();
        if (oldMinValue > value) {
            minStack.push(value);
        } else {
            minStack.push(oldMinValue);
        }

    }

    public static Integer pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈中无数据");
        }

        minStack.pop();
        return stack.pop();
    }


}
