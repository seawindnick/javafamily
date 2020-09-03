package com.java.study.interview.chapter1;

import com.alibaba.fastjson.JSONObject;

import java.util.Stack;

/**
 * <Description>
 * 使用一个栈对另一个栈中数据进行排序
 * @author hushiye
 * @since 2020-08-13 19:38
 */
public class T01_005UseStackSort {

    public static void stackSort(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }


        Stack<Integer> helpStack = new Stack<>();

        while (!stack.isEmpty()){
            Integer value = stack.pop();
            while (!helpStack.isEmpty() && helpStack.peek() < value){
                stack.push(helpStack.pop());
            }
            helpStack.push(value);
        }

        while (!helpStack.isEmpty()){
            stack.push(helpStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        stack.add(3);
        stack.add(7);
        stack.add(3);
        stack.add(10);
        System.out.println(JSONObject.toJSONString(stack));
        stackSort(stack);
        System.out.println(JSONObject.toJSONString(stack));
    }



}
