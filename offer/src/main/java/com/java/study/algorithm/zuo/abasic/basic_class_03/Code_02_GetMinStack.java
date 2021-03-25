package com.java.study.algorithm.zuo.abasic.basic_class_03;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返 回栈中最小元素的操作。
 * 【要求】 1.pop、push、getMin操作的时间复杂度都是O(1)。 2.设计的栈类型可以使用现成的栈结构。
 */
public class Code_02_GetMinStack {

    public static class GetMinStack {
        private Stack<Integer> minStack = new Stack<>();
        private Stack<Integer> stack = new Stack<>();

        public Integer pop() {
            if (stack.isEmpty()) {
                throw new IllegalArgumentException("栈中没有元素信息");
            }
            minStack.pop();
            return stack.pop();
        }

        public void push(Integer value) {
            stack.push(value);

            Integer pushValue = minStack.isEmpty() ? value : Math.min(minStack.peek(), value);
            minStack.push(pushValue);

        }

        public Integer getmin() {
            return minStack.peek();
        }
    }

    public static class MyStack2 {
        private Stack<Integer> minStack = new Stack<>();
        private Stack<Integer> stack = new Stack<>();


        public Integer pop() {
            if (stack.isEmpty()) {
                throw new IllegalArgumentException("栈中没有元素信息");
            }

            Integer value = stack.pop();
            //minStack 栈顶元素 == 当前要抛出的元素，进行元素弹出
            if (minStack.peek().equals(value)) {
                minStack.pop();
            }
            return value;
        }

        public void push(Integer value) {
            stack.push(value);

            // 队列是空的，获取 minStack 栈顶元素 >= 当前压入元素，将当前元素压入minStack
            if (minStack.isEmpty() || minStack.peek() >= value) {
                minStack.push(value);
            }
        }

        public Integer getmin() {
            return minStack.peek();
        }

    }


    public static void main(String[] args) {
        GetMinStack stack1 = new GetMinStack();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());

        System.out.println("=============");

        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        System.out.println(stack2.getmin());
        stack2.push(4);
        System.out.println(stack2.getmin());
        stack2.push(1);
        System.out.println(stack2.getmin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getmin());
    }


}