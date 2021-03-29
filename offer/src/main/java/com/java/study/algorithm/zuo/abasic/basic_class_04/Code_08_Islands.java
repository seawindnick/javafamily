package com.java.study.algorithm.zuo.abasic.basic_class_04;

/**
 * 岛数量
 */
public class Code_08_Islands {


    public static int countIsLand(int[][] martix) {
        if (martix == null || martix.length == 0 || martix[0].length == 0) {
            return 0;
        }

        int rowLength = martix.length;
        int colLength = martix[0].length;

        int count = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (martix[row][col] == 1) {
                    count++;
                    infection(martix, row, col, rowLength, colLength);
                }

            }
        }

        restoreMartic(martix);
        return count;
    }

    private static void restoreMartic(int[][] martix) {
        int rowLength = martix.length;
        int colLength = martix[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (martix[row][col] == 2) {
                    martix[row][col] = 1;
                }

            }
        }

    }

    private static void infection(int[][] martix, int row, int col, int rowLength, int colLength) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || martix[row][col] == 0 || martix[row][col] == 2) {
            return;
        }
        martix[row][col] = 2;
        //下
        infection(martix, row + 1, col, rowLength, colLength);
        //上
        infection(martix, row - 1, col, rowLength, colLength);
        //左
        infection(martix, row, col - 1, rowLength, colLength);
        //右
        infection(martix, row, col + 1, rowLength, colLength);
    }

    public static void main(String[] args) {
        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIsLand(m1));

        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIsLand(m2));

    }


}