package com.java.study.algorithm.zuo.abasic.basic_class_07;

import java.util.Stack;

/**
 * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能
 * 使用递归函数。如何实现?
 */
public class Code_06_ReverseStackUsingRecursive {


    /**
     * 找到第一个元素，最后一个添加进入栈中
     *
     * @param stack
     */

    public static void ReverseStackUsingRecursive(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) {
            return;
        }

        //获取最后栈底元素
        int lastValue = getLastValue(stack);
        // 递归处理其他数据
        ReverseStackUsingRecursive(stack);

        //栈底元素加入栈顶
        stack.push(lastValue);
    }

    private static int getLastValue(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return stack.pop();
        } else {
            Integer indexValue = stack.pop();
            Integer lastValue = getLastValue(stack);
            //获取完栈底元素之后，将元素按照原顺序添加进入栈中
            stack.push(indexValue);
            return lastValue;
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println("-------------");

        ReverseStackUsingRecursive(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}