package com.java.study.algorithm.zuo.abasic.basic_class_08;

/**
 * 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所有字 符串拼起来之后形成的字符串具有最低的字典序。
 */
public class Code_06_LowestLexicography {


    public static String LowestLexicography(String[] arr) {
        if (arr == null) {
            return null;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (check(arr[i], arr[j])) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i];
        }
        return result;
    }

    private static boolean check(String s, String s1) {
        return (s + s1).compareTo(s1 + s) <= 0;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"a", "ac", "ab", "ag"};
        System.out.println(LowestLexicography(arr));
    }
}