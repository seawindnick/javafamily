package com.java.study.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-04 22:16
 */
public class LongestValidParentheses {



    public int longestValidParentheses (String s) {
        if (s == null || s.trim().length() == 0){
            return 0;
        }

        char[] array = s.toCharArray();

        int max = 0;

        char left = '(';
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < array.length ; i++) {
            char indexChar = array[i];
            if (indexChar == left){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    int length = i - stack.peek();
                    max = Math.max(max,length);
                }
            }
        }


        return max;
    }

    public int longestValidParentheses2(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        String str = "))))";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(str));
    }

}
