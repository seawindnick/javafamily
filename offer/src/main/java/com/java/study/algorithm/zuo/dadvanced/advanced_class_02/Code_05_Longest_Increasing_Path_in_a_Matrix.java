package com.java.study.algorithm.zuo.dadvanced.advanced_class_02;

/**
 * 给定一个整数矩阵matrix，每个位置你可以向左、右、下、上移动，找到其中最长的递增路径 例如:
 * matrix = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 返回4
 * 最长路径是[1, 2, 6, 9].
 * <p>
 * matrix = [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 返回4
 * 最长路径是[3，4，5，6].
 */
public class Code_05_Longest_Increasing_Path_in_a_Matrix {


    public static int Longest_Increasing_Path_in_a_Matrix(int[][] martix) {
        if (martix == null || martix.length == 0 || martix[0] == null || martix[0].length == 0) {
            return 0;
        }


        int columnLength = martix[0].length;
        int rowLength = martix.length;

        int[][] dp = new int[rowLength][columnLength];
        int max = 0;

        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                // 上
                max = Math.max(max, incrment(martix, row - 1, column, rowLength, columnLength, martix[row][column], dp) + 1);
                //下
                max = Math.max(max, incrment(martix, row + 1, column, rowLength, columnLength, martix[row][column], dp) + 1);
                //左
                max = Math.max(max, incrment(martix, row, column - 1, rowLength, columnLength, martix[row][column], dp) + 1);
                //右
                max = Math.max(max, incrment(martix, row, column + 1, rowLength, columnLength, martix[row][column], dp) + 1);
            }

        }

        return max;
    }

    private static int incrment(int[][] martix, int row, int column, int rowLength, int columnLength, int checkValue, int[][] dp) {
        if (row < 0 || column < 0 || row >= rowLength || column >= columnLength || martix[row][column] >= checkValue) {
            return 0;
        }

        if (dp[row][column] == 0) {
            dp[row][column] = incrment(martix, row - 1, column, rowLength, columnLength, martix[row][column], dp) + 1;
            //下
            dp[row][column] = Math.max(dp[row][column], incrment(martix, row + 1, column, rowLength, columnLength, martix[row][column], dp) + 1);
            //左
            dp[row][column] = Math.max(dp[row][column], incrment(martix, row, column - 1, rowLength, columnLength, martix[row][column], dp) + 1);
            //右
            dp[row][column] = Math.max(dp[row][column], incrment(martix, row, column + 1, rowLength, columnLength, martix[row][column], dp) + 1);
        }

        return dp[row][column];
    }

    public static void main(String[] args) {
        int[][] martix = new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };

        System.out.println(Longest_Increasing_Path_in_a_Matrix(martix));

        System.out.println(com.java.study.answer.zuo.dadvanced.advanced_class_02.Code_05_Longest_Increasing_Path_in_a_Matrix.longestIncreasingPath(martix));
    }

}