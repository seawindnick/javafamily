package com.java.study.zuo.stack;

import java.util.Stack;

/**
 * 获取栈中最小元素
 */
public class GetMinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public GetMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);

        int minValue = minStack.isEmpty() ? value : Math.min(minStack.peek(), value);
        minStack.push(minValue);

    }


    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("栈中没有任何元素");
        }
        minStack.pop();
        return stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("栈中没有任何元素");
        }
        return stack.peek();
    }


    public int getMin() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("栈中没有任何元素");
        }
        return minStack.peek();
    }


    public static void main(String[] args) {
        GetMinStack stack1 = new GetMinStack();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        GetMinStack stack2 = new GetMinStack();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }

}
