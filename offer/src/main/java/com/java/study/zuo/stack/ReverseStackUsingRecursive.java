package com.java.study.zuo.stack;

import com.alibaba.fastjson.JSONObject;

import java.util.Stack;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-10 16:33
 */
public class ReverseStackUsingRecursive {


    public static void reverseStackUsingRecursive(Stack<Integer> stack) {
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverseStackUsingRecursive(stack);
        stack.push(i);

    }

    //获取最后一个元素
    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }
        int last = getAndRemoveLastElement(stack);
        stack.push(result);
        return last;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < 10; i++) {
            stack.add(i);
        }
        reverseStackUsingRecursive(stack);
        System.out.println(JSONObject.toJSONString(stack));


    }
}
