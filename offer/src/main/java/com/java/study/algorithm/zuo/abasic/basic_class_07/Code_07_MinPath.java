package com.java.study.algorithm.zuo.abasic.basic_class_07;

import static com.java.study.answer.zuo.abasic.basic_class_07.Code_07_MinPath.minPath1;

/**
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 * 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 * 加起来。返回最小的路径和。
 * <p>
 * {
 * {1, 3, 5, 9},
 * {8, 1, 3, 4},
 * {5, 0, 6, 1},
 * {8, 8, 4, 0}
 * }
 *
 * 矩阵
 */
public class Code_07_MinPath {

    public static int MinPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];

        //第一行数据初始化
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < column; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i - 1];
        }

        //第一列数据初始化
        for (int i = 1; i < row; i++) {
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }

        //行
        for (int i = 1; i < row; i++) {
            //列
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + matrix[i][j];
            }
        }

        return dp[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        m = com.java.study.answer.zuo.abasic.basic_class_07.Code_07_MinPath.generateRandomMatrix(6, 7);
        System.out.println(com.java.study.answer.zuo.abasic.basic_class_07.Code_07_MinPath.minPath2(m));
        System.out.println(MinPath(m));
    }
}