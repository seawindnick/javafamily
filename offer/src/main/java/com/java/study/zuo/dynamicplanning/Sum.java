package com.java.study.zuo.dynamicplanning;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-10 18:07
 */
public class Sum {


    public static Boolean isSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return Boolean.FALSE;
        }

        int startIndex = 0;
        int indexSum = 0;
        return isSum(arr, startIndex, indexSum, target);
    }


    public static Boolean isSum2(int[] arr, int target) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        int rowLength = arr.length + 1;
        int colLength = sum + 1;

        boolean[][] dp = new boolean[rowLength][sum + 1];
        //初始化最后一列的数据
        for (int i = 0; i < colLength; i++) {
            dp[rowLength - 1][i] = i == target;
        }

        for (int row = rowLength - 2; row >= 0; row--) {
            int indexvalue = arr[row];
            for (int col = 0; col < colLength; col++) {
                if (col + indexvalue >= colLength){
                    dp[row][col] = dp[row+1][col];
                }else {
                    dp[row][col] = (dp[row+1][col] || dp[row+1][col+indexvalue]) ;
                }

            }
        }
        System.out.println(JSONArray.toJSONString(dp));
        return dp[0][0];
    }

    private static Boolean isSum(int[] arr, int curIndex, int indexSum, int target) {
        if (curIndex == arr.length) {
            return indexSum == target;
        }
        return isSum(arr, curIndex + 1, indexSum, target) || isSum(arr, curIndex + 1, indexSum + arr[curIndex], target);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(isSum2(arr, 0));
        System.out.println(isSum(arr, 0));
    }
}
