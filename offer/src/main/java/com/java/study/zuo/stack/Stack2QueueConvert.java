package com.java.study.zuo.stack;

import java.util.Stack;

/**
 * 使用栈实现队列
 */
public class StackAndQueueConvert {
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


    


}
