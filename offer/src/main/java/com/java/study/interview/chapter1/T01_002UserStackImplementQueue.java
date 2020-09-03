package com.java.study.interview.chapter1;

import java.util.Stack;

/**
 * <Description>
 * <p>
 * 使用两个栈实现队列
 * add,poll,peek
 * @author hushiye
 * @since 2020-08-11 18:41
 */
public class T01_002UserStackImplementQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public T01_002UserStackImplementQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void add(Integer value){
        inStack.add(value);
        full();
    }

    public Integer pop(){
        if (inStack.isEmpty() && outStack.isEmpty()){
            throw new IllegalArgumentException("栈中没有数据");
        }
        full();
        return outStack.pop();

    }

    private void full() {
        if (!outStack.isEmpty()){
            return;
        }
        while (!inStack.isEmpty()){
            outStack.add(inStack.pop());
        }
    }

    public Integer peek(){
        if (inStack.isEmpty() && outStack.isEmpty()){
            throw new IllegalArgumentException("栈中没有数据");
        }
        full();
        return outStack.peek();
    }
}
