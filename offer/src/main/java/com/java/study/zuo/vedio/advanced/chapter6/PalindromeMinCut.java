package com.java.study.zuo.vedio.advanced.chapter6;

/**
 * <Description>
 * <p>
 * <p>
 * 回文最少分割数
 * 【题目】 给定一个字符串str，返回把str全部切成回文子串的最小分割数。 【举例】
 * str="ABA"。
 * 不需要切割，str本身就是回文串，所以返回0。
 * str="ACDCDCDAD"。 最少需要切2次变成3个回文子串，比如"A"、"CDCDC"和"DAD"，所以返回2。
 *
 * @author hushiye
 * @since 2020-09-23 00:05
 */
public class PalindromeMinCut {


    public static int palindromeMinCut(char[] arr, int i) {
        if (i == arr.length - 1) {
            return 0;
        }

        if (checkIsPalindrom(arr, i, arr.length - 1)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int j = i; j < arr.length; j++) {
            if (checkIsPalindrom(arr, i, j)) {
                int result = palindromeMinCut(arr, j + 1);
                min = Math.min(result, min);
            }
        }
        return min + 1;

    }


    public static int palindromeMinCut2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] array = str.toCharArray();

        boolean[][] p = new boolean[array.length][array.length];
        int[] dp = new int[array.length + 1];
        dp[dp.length - 1] = -1;

        for (int i = array.length - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < array.length; j++) {
                if (array[i] == array[j] && (j - i <= 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }

            }
        }
        return dp[0];

    }


    public static Boolean checkIsPalindrom(char[] arr, int l, int r) {
        while (l < r) {
            if (arr[l++] != arr[r--]) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        String str = "CDC";

//        System.out.println(palindromeMinCut(str.toCharArray(), 0));
        System.out.println(palindromeMinCut2(str));
    }
}
