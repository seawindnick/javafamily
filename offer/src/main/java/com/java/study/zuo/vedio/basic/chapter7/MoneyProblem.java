package com.java.study.zuo.vedio.basic.chapter7;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-27 23:05
 */
public class MoneyProblem {

    public static boolean moneyProblem(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int startIndex = 0;
        int length = arr.length;
        int result = 0;

        return moneyProblem(arr, startIndex, length, result, target);

    }

    private static boolean moneyProblem(int[] arr, int startIndex, int length, int result, int target) {
        if (startIndex == length) {
            return result == target;
        }

        return moneyProblem(arr, startIndex + 1, length, result, target) || moneyProblem(arr, startIndex + 1, length, result + arr[startIndex], target);
    }


    private static boolean moneyProblem2(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }


        int dpRowLength = arr.length + 1;
        int dpCloumnLength = sum + 1;
        boolean[][] dp = new boolean[dpRowLength][dpCloumnLength];


        dp[dpRowLength - 1][target] = true;

        for (int i = dpRowLength - 2; i >= 0; i--) {
            for (int j = 0; j < dpCloumnLength - 1; j++) {
                dp[i][j] = j + arr[i] >= dpCloumnLength ? dp[i + 1][j] : dp[i + 1][j] || dp[i + 1][j + arr[i]];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(JSONArray.toJSONString(dp[i]));
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8};
        int aim = 12;
        System.out.println(moneyProblem(arr, aim));
        System.out.println(moneyProblem2(arr, aim));
    }

}
