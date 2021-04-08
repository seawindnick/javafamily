package com.java.study.algorithm.zuo.abasic.basic_class_07;

import com.java.study.zuo.sort.ArrayUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 打印一个字符串的全部排列
 * 打印一个字符串的全部排列，要求不要出现重复的排列
 */
public class Code_04_Print_All_Permutations {


    public static void Print_All_Permutations(String str) {
        if (str == null) {
            return;
        }

        char[] chars = str.toCharArray();

        Print_All_Permutations(chars, 0);

    }

    /**
     * 首位元素确定好之后，其余部分全排列
     * @param chars
     * @param index
     */
    private static void Print_All_Permutations(char[] chars, int index) {
        if (index == chars.length - 1) {
            System.out.println(String.valueOf(chars));
            return;
        }


        Set<Character> existSet = new HashSet<>();

        for (int i = index; i < chars.length; i++) {
            if (!existSet.contains(chars[i])) {
                existSet.add(chars[i]);
                ArrayUtil.swap(chars, index, i);
                Print_All_Permutations(chars, index + 1);
                ArrayUtil.swap(chars, index, i);
            }
        }
    }

    public static void main(String[] args) {
        Print_All_Permutations("abcdd");

        System.out.println("===================");
        Code_04_Print_All_Permutations.Print_All_Permutations("abcdd");
    }


}