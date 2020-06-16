package com.java.study.offer.chapter5;

import java.util.Stack;

public class StackImplateQueue {

    private static Stack inStack = new Stack();
    private static Stack outStack = new Stack<>();

    public void push(Object e){
        inStack.push(e);
    }


    public Object pop(){
        if (!outStack.empty()){
            return outStack.pop();
        }


        while (!inStack.empty()){
            Object e = inStack.pop();
            outStack.push(e);
        }

        if (outStack.isEmpty()){
            throw new RuntimeException("没有数据");
        }
        return outStack.pop();
    }

}
