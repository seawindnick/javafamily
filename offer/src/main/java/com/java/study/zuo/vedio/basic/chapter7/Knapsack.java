package com.java.study.zuo.vedio.basic.chapter7;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-28 00:01
 */
public class Knapsack {

    public static int maxValue(int[] w, int[] v, int packege) {
        if (w == null || w.length == 0) {
            return 0;
        }

        int value = 0;
        int startIndex = 0;
        int endIndex = w.length;
        return maxValue(w, v, startIndex, endIndex, value, packege);

    }

    private static int maxValue(int[] w, int[] v, int startIndex, int endIndex, int value, int packege) {
        if (startIndex == endIndex) {
            return value;
        }

        if (packege < w[startIndex]) {
            return maxValue(w, v, startIndex + 1, endIndex, value, packege);
        }

        return Math.max(maxValue(w, v, startIndex + 1, endIndex, value, packege),
                maxValue(w, v, startIndex + 1, endIndex, value + v[startIndex], packege - w[startIndex]));
    }


    public static int maxValue2(int[] w, int[] v, int packege) {
        if (w == null || w.length == 0) {
            return 0;
        }

        int dpRowLength = w.length + 1;
        int dpCloumnLength = packege + 1;

        int[][] dp = new int[dpRowLength][dpCloumnLength];

        for (int i = 1; i < dpRowLength; i++) {
            for (int j = 0; j < dpCloumnLength; j++) {
                dp[i][j] = j >= w[i - 1] ? Math.max(dp[i - 1][j], v[i - 1] + dp[i - 1][j - w[i - 1]]) : dp[i - 1][j];

            }
        }
        return dp[dpRowLength - 1][dpCloumnLength - 1];
    }


    public static void main(String[] args) {
        int w = 10;
        int[] arr = {5, 5, 3, 4, 3};
        int[] brr = {400, 500, 200, 300, 350};
        System.out.println(maxValue(arr, brr, w));
        System.out.println(maxValue2(arr, brr, w));
    }
}
