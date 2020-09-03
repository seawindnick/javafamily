package com.java.study.interview.chapter1;

import com.java.study.zuo.stack.GetMinStack;

import java.util.Stack;

/**
 * <Description>
 * <p>
 * 实现一个特殊栈，实现栈的基本功能上，返回栈中最小的元素
 * <p>
 * pop,push,getMin操作时间复杂度都是O(1)
 *
 * @author hushiye
 * @since 2020-08-11 18:26
 */
public class T01_001MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> elementStack;

    public T01_001MinStack() {
        minStack = new Stack<>();
        elementStack = new Stack<>();
    }

    public void push(int element) {
        elementStack.push(element);
        minStack.push(minStack.isEmpty() ? element : Math.min(minStack.peek(), element));
    }

    public Integer pop() {
        if (elementStack.isEmpty()) {
            throw new IllegalArgumentException("栈中无元素");
        }

        minStack.pop();
        return elementStack.pop();
    }

    public Integer getMin() {
        if (elementStack.isEmpty()) {
            throw new IllegalArgumentException("栈中无元素");
        }

        return minStack.peek();
    }


}
