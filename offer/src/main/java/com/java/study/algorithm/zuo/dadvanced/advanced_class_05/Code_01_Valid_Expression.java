package com.java.study.algorithm.zuo.dadvanced.advanced_class_05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 爱编程的小易发现，当自己代码中的括号较多时，
 * 如果括号未 成对出现，或者出现的顺序错误，
 * 他的编辑器 总是能立马给出 错误提示。好奇的小易决定自己尝试实现该功能。
 * 对于一行代 码(字符串)，里面可能出现大括号"{}"、中括号"[]"和小括号 "()"，
 * 请编程判断该行代码的括号嵌 套是否正确。 "()","({})","print ('Hello Netease')"等都是括号的正确使 用方法，"(]","print (Hello Netease]"则是错误的范例
 */
public class Code_01_Valid_Expression {


    public static Boolean expression(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        Map<String, String> map = new HashMap<>();
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");

        Stack<String> stack = new Stack<>();

        Collection<String> collection = map.values();

        for (int i = 0; i < str.length(); i++) {
            String indexValue = String.valueOf(str.charAt(i));

            if (map.containsKey(indexValue) && (stack.isEmpty() || !map.get(indexValue).equals(stack.pop()))) {
                return false;
            }

            if (collection.contains(indexValue)){
                stack.push(indexValue);
            }

        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(expression("{1+(2+3)+[(1+3)+(4*5)]}"));
        System.out.println(expression("{{}"));
        System.out.println(expression("({})"));
        System.out.println(expression("print ('Hello Netease')"));
        System.out.println(expression("print ('Hello Netease'}"));
    }

}