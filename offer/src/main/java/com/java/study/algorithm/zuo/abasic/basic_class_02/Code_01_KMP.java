package com.java.study.algorithm.zuo.abasic.basic_class_02;

import com.alibaba.fastjson.JSONArray;

public class Code_01_KMP {


    /**
     * KMP算法的核心是利用匹配失败后的信息，尽量减少模式串与主串的匹配次数以达到快速匹配的目的
     *
     * @param str
     * @param match
     * @return
     */
    public static int KMP(String str, String match) {
        if (str == null || match == null || str.length() < match.length()) {
            return -1;
        }


        char[] origeArray = str.toCharArray();
        char[] matchArray = match.toCharArray();
        int[] next = getNext(matchArray);


        int origIndex = 0;
        int matchIndex = 0;
        while (origIndex < origeArray.length && matchIndex < matchArray.length) {
            if (origeArray[origIndex] == matchArray[matchIndex]) {
                origIndex++;
                matchIndex++;
            } else if (next[matchIndex] == -1) {
                //说明此时 matchIndex == 0,走到此处说明 当前 str 元素位置 与 match 首个元素不匹配
                origIndex++;
            } else {
                matchIndex = next[matchIndex];
            }
        }


        return matchIndex == matchArray.length ? origIndex - matchIndex : -1;
    }

    private static int[] getNext(char[] matchArray) {
        if (matchArray.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[matchArray.length];
        next[0] = -1;
        next[1] = 0;

        // 角标位置
        int pos = 2;
        // 匹配元素位置
        int cn = 0;
        while (pos < matchArray.length) {
            if (matchArray[pos - 1] == matchArray[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                // 此时 cn == 0
                next[pos++] = 0;
            }

        }
        return next;

    }

    public static void main(String[] args) {
        System.out.println(KMP("abaabd", "abc"));
    }
}