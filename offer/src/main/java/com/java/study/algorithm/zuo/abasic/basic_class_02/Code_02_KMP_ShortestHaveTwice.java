package com.java.study.algorithm.zuo.abasic.basic_class_02;

/**
 * 给定一个字符串str1，只能往str1的后面添加字符变成str2。
 * 要求1:str2必须包含两个str1，两个str1可以有重合，但是不 能以同一个位置开头。
 * 要求2:str2尽量短
 * 最终返回str2
 */
public class Code_02_KMP_ShortestHaveTwice {


    public static String ShortestHaveTwice(String str) {
        if (str == null) {
            return null;
        }

        if (str.length() <= 1) {
            return str + str;
        }

        char[] array = str.toCharArray();
        int startIndex = getStartIndex(array);

//        while (startIndex < array.length) {
//            str += array[startIndex++];
//        }
        return str + str.substring(startIndex);
    }

    private static int getStartIndex(char[] array) {
        int[] next = new int[array.length + 1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (array[pos - 1] == array[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }

        }

        return next[array.length];
    }

    public static void main(String[] args) {
        System.out.println(ShortestHaveTwice("aabca"));
    }

}