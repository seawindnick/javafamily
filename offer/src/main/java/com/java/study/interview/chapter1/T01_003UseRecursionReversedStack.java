package com.java.study.interview.chapter1;

import com.alibaba.fastjson.JSONObject;

import java.util.Stack;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-13 18:41
 */
public class T01_003UseRecursionReversedStack {

    public static void reversedStack(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() <= 1) {
            return;
        }

        reversed(stack);

    }

    private static void reversed(Stack<Integer> stack) {
        int lastElement = getLastElement(stack);
        reversedStack(stack);
        stack.add(lastElement);
    }

    /**
     * 获取最后一个元素
     *
     * @param stack
     * @return
     */
    private static int getLastElement(Stack<Integer> stack) {
        Integer value = stack.pop();
        if (stack.size() == 0) {
            return value;
        } else {
            Integer lastValue = getLastElement(stack);
            stack.add(value);
            return lastValue;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.add(i);
        }
        System.out.println(JSONObject.toJSONString(stack));
        reversedStack(stack);
        System.out.println(JSONObject.toJSONString(stack));

    }
}
