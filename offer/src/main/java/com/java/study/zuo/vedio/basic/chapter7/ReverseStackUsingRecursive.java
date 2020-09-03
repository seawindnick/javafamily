package com.java.study.zuo.vedio.basic.chapter7;

import com.alibaba.fastjson.JSONArray;

import java.util.Stack;

/**
 * <Description>
 * 使用递归逆序栈
 * @author hushiye
 * @since 2020-08-27 09:03
 */
public class ReverseStackUsingRecursive {


    public static void reverseStackUsingRecursive(Stack<Integer> stack){
        if(stack == null || stack.size() <= 1){
            return;
        }

        reverseStack(stack);
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()){
            return;
        }
        Integer value = getLastElement(stack);//获取最后一个元素
        reverseStack(stack);
        stack.push(value);
    }

    private static Integer getLastElement(Stack<Integer> stack) {
        Integer value = stack.pop();
        if (stack.isEmpty()){
            return value;
        }else {
            Integer result = getLastElement(stack);
            stack.push(value);
            return result;
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println(JSONArray.toJSONString(stack));
        reverseStackUsingRecursive(stack);
        System.out.println(JSONArray.toJSONString(stack));
    }

}
