package com.java.study.zuo.dynamicplanning;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-11 08:45
 */
public class Knapsack {

    public static int maxPackage(int[] weights, int[] values, int capacity) {
        if (weights == null || weights.length == 0 || values == null || values.length == 0) {
            return 0;
        }


        int curTotalValues = 0;
        int curIndex = 0;

        return getMax(weights, values, curTotalValues, curIndex, capacity);

    }

    private static int getMax(int[] weights, int[] values, int curTotalValues, int curIndex, int capacity) {
        if (curIndex == weights.length) {
            return curTotalValues;
        }

        if (weights[curIndex] > capacity) {
            return getMax(weights, values, curTotalValues, curIndex + 1, capacity);
        }

        return Math.max(getMax(weights, values, curTotalValues, curIndex + 1, capacity),
                getMax(weights, values, curTotalValues + values[curIndex], curIndex + 1, capacity - weights[curIndex]));

    }

    public static int maxPackage2(int[] weights, int[] values, int capacity) {
        if (weights == null || weights.length == 0 || values == null || values.length == 0) {
            return 0;
        }

        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int row = 1; row < dp.length; row++) {

            for (int col = 1; col <= capacity; col++) {
                dp[row][col] = dp[row - 1][col];
                if (col >= weights[row - 1]) {
                    dp[row][col] = Math.max(dp[row][col], dp[row - 1][col - weights[row - 1]] + values[row - 1]);
                }
            }
        }
        System.out.println(JSONArray.toJSONString(dp));
        return dp[weights.length][capacity];
    }


    public static void main(String[] args) {
        int w = 10;
        int[] arr = {5, 5, 3, 4, 3};
        int[] brr = {400, 500, 200, 300, 350};
        System.out.println(maxPackage2(arr, brr, w));
    }
}
