package com.java.study.algorithm.zuo.abasic.basic_class_07;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的 数字，能不能累加得到aim，返回true或者false
 */
public class Code_08_Money_Problem {

    public static boolean Money_Problem3(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        // 列是累计的值
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        print(dp);
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
                System.out.println("行:" + i + ",列:" + j);
                print(dp);

            }
        }

        return dp[0][0];
    }


    public static boolean Money_Problem(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        return Money_Problem(arr, value, 0, 0);


    }


    private static boolean Money_Problem(int[] arr, int value, int index, int result) {
        if (result == value) {
            return true;
        }

        if (result > value || index == arr.length) {
            return false;
        }

        return Money_Problem(arr, value, index + 1, result + arr[index]) || Money_Problem(arr, value, index + 1, result);
    }

    private static void print(boolean[][] dp) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dp[0].length; i++) {
            list.add("  " + i);
        }
        System.out.println("    :" + JSONArray.toJSONString(list));

        for (int i = 0; i < dp.length; i++) {
            System.out.println("第" + i + "行:" + JSONArray.toJSONString(dp[i]));
        }
        System.out.println("==========================");
    }


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
                    dp[i][j] = dp[i][j] || dp[i + 1][j - indexValue];
                }
            }
        }

        return dp[0][value];
    }


//    private static boolean Money_Problem(int[] arr, int value, int index) {
//        if (index == arr.length) {
//            return arr[index] == value;
//        }
//
//        return Money_Problem(arr, value + arr[index], index + 1) || Money_Problem(arr, value, index + 1);
//    }


//    private static boolean Money_Problem(int[] arr, int value, int index) {
//        if (index == arr.length - 1) {
//            return arr[index] == value;
//        }
//
//        return Money_Problem(arr, value - arr[index], index + 1) || Money_Problem(arr, value, index + 1);
//    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4};
        System.out.println(Money_Problem(arr, 1));
//        System.out.println(Money_Problem2(arr, 13));
//        System.out.println(Money_Problem3(arr, 5));
    }

}