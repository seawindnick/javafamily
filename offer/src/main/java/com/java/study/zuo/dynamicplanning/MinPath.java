package com.java.study.zuo.dynamicplanning;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-10 17:20
 */
public class MinPath {


    public static int minPath(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        return getMinPath(arr, 0, 0, sum);
    }

    private static int getMinPath(int[][] arr, int rowIndex, int cowIndex, int sum) {
        if (rowIndex == arr.length - 1 && cowIndex == arr[0].length - 1) {
            return sum;
        }

        if (rowIndex == arr.length - 1) {
            return getMinPath(arr, rowIndex, cowIndex + 1, sum + arr[rowIndex][cowIndex]);
        }

        if (cowIndex == arr[0].length - 1) {
            return getMinPath(arr, rowIndex + 1, cowIndex, sum + arr[rowIndex][cowIndex]);
        }

        return Math.min(getMinPath(arr, rowIndex, cowIndex + 1, sum + arr[rowIndex][cowIndex]),
                getMinPath(arr, rowIndex + 1, cowIndex, sum + arr[rowIndex][cowIndex]));

    }


//
//    public static int minPath2(int[][] m) {
//        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
//            return 0;
//        }
//        int row = m.length;
//        int col = m[0].length;
//        int[][] dp = new int[row][col];
//        dp[0][0] = m[0][0];
//        for (int i = 1; i < row; i++) {
//            dp[i][0] = dp[i - 1][0] + m[i][0];
//        }
//        for (int j = 1; j < col; j++) {
//            dp[0][j] = dp[0][j - 1] + m[0][j];
//        }
//        for (int i = 1; i < row; i++) {
//            for (int j = 1; j < col; j++) {
//                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
//            }
//        }
//        return dp[row - 1][col - 1];
//    }


    public static int minPath2(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int rowLength = arr.length;
        int cowLength = arr[0].length;
        int[][] dp = new int[rowLength][cowLength];

        int rowEndIndex = rowLength - 1;
        int cowEndIndex = cowLength - 1;
        dp[rowEndIndex][cowEndIndex] = arr[rowEndIndex][cowEndIndex];

        //填充最后一行，因为最后一行只能向右走
        for (int cow = cowEndIndex - 1; cow >= 0; cow--) {
            dp[rowEndIndex][cow] = arr[rowEndIndex][cow] + dp[rowEndIndex][cow + 1];
        }

        //填充最后一列的数据，最后一列的数据只能向下走
        for (int row = rowEndIndex - 1; row >= 0; row--) {
            dp[row][cowEndIndex] = arr[row][cowEndIndex] + dp[row + 1][cowEndIndex];
        }

        //逆序填充其他位置的数据
        for (int row = rowEndIndex - 1; row >= 0; row--) {
            for (int cow = rowEndIndex - 1; cow >= 0; cow--) {
                dp[row][cow] = arr[row][cow] +
                        Math.min(dp[row + 1][cow], dp[row][cow + 1]);

            }
        }

        return dp[0][0];
    }


    public static int minPath3(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }

        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = arr[0][0];
        //首列
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }

        //首行
        for (int i = 1; i < col; i++) {
            dp[0][i] = arr[0][i] + dp[0][i-1];
        }


        for (int i = 1; i < row; i++) {

            for (int j = 1; j < col; j++) {
                dp[i][j] = arr[i][j] +
                        Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.println(JSONArray.toJSONString(dp));
        return dp[row-1][col-1];

    }


    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}};

        System.out.println(minPath3(m));
    }


}
