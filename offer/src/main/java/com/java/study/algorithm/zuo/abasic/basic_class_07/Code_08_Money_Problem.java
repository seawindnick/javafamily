package com.java.study.algorithm.zuo.abasic.basic_class_07;

/**
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的 数字，能不能累加得到aim，返回true或者false
 */
public class Code_08_Money_Problem {


    public static boolean Money_Problem2(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int maxSum = 0;
        for (int i : arr) {
            maxSum += i;
        }

        if (maxSum == value) {
            return true;
        }

        if (maxSum < value) {
            return false;
        }

        boolean[][] dp = new boolean[arr.length + 1][maxSum + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[arr.length][arr[i]] = true;
        }

        //行
        for (int i = arr.length - 1; i >= 0; i--) {
            //列
            for (int j = 0; j < maxSum + 1; j++) {
                int indexValue = arr[i];
                dp[i][j] = dp[i + 1][j];
                if (arr[i] <= j) {
                    dp[i][j] = dp[i][j] || dp[i][j - indexValue];
                }
            }
        }

        return dp[0][value];
    }


    public static boolean Money_Problem(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        return Money_Problem(arr, value, 0);


    }

    private static boolean Money_Problem(int[] arr, int value, int index) {
        if (index == arr.length - 1) {
            return arr[index] == value;
        }

        return Money_Problem(arr, value - arr[index], index + 1) || Money_Problem(arr, value, index + 1);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8};
        System.out.println(Money_Problem(arr, 14));
        System.out.println(Money_Problem2(arr, 14));
    }

}