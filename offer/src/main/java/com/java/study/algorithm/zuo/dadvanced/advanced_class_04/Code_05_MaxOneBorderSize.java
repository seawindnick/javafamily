package com.java.study.algorithm.zuo.dadvanced.advanced_class_04;

import com.alibaba.fastjson.JSONArray;

/**
 * 边界都是1的最大正方形大小
 * 【题目】 给定一个NN的矩阵matrix，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方 形的边长长度。
 * 例如:
 * 0 1 1 1 1
 * 0 1 0 0 1
 * 0 1 0 0 1
 * 0 1 1 1 1
 * 0 1 0 1 1
 * 其中，边框全是1的最大正方形的大小为4*4，所以返回4。
 * <p>
 * dpcolumn
 * 0 1 2 3 4
 * 0 1 0 0 1
 * 0 1 0 0 1
 * 0 1 2 3 4
 * 0 1 0 1 2
 * <p>
 * dprow
 * 0 1 1 1 1
 * 0 2 0 0 2
 * 0 3 0 0 3
 * 0 4 1 1 4
 * 0 5 0 2 5
 * <p>
 * <p>
 * dpDowm
 * 0 5 1 1 5
 * 0 4 0 0 4
 * 0 3 0 0 3
 * 0 2 1 2 2
 * 0 1 0 1 1
 * <p>
 * <p>
 * dpRight
 * <p>
 * 0 4 3 2 1
 * 0 1 0 0 1
 * 0 1 0 0 1
 * 0 4 3 2 1
 * 0 1 0 2 1
 */
public class Code_05_MaxOneBorderSize {


//    public static int MaxOneBorderSize(int[][] martix) {
//        if (martix == null || martix.length == 0 || martix[0].length == 0) {
//            return 0;
//        }
//
//        int row = martix.length;
//        int column = martix[0].length;
//        int[][] dpDowm = new int[row][column];
//        int[][] dpRight = new int[row][column];
//
//
//    }


    public static int MaxOneBorderSize(int[][] martix) {
        if (martix == null || martix.length == 0 || martix[0].length == 0) {
            return 0;
        }

        int row = martix.length;
        int column = martix[0].length;
        int[][] dprow = new int[row][column];
        int[][] dpcolumn = new int[row][column];

        //统计第一列的数据，用于统计行信息
        for (int i = 0; i < row; i++) {
            dpcolumn[i][0] = martix[i][0] == 1 ? 1 : 0;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (martix[i][j] == 0) {
                    dpcolumn[i][j] = 0;
                } else {
                    dpcolumn[i][j] = dpcolumn[i][j - 1] + 1;
                }
            }
        }

        for (int i = 0; i < column; i++) {
            dprow[0][i] = martix[0][i] == 1 ? 1 : 0;
        }


        for (int i = 1; i < row; i++) {

            for (int j = 0; j < column; j++) {
                if (martix[i][j] == 0) {
                    dprow[i][j] = 0;
                } else {
                    dprow[i][j] = dprow[i - 1][j] + 1;
                }
            }
        }

        int maxsize = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 1; k < Math.min(row, column); k++) {

                    int leftUpRow = i;
                    int leftUpCol = j;

                    int rightDownRow = i + k - 1;
                    int rightDownCol = j + k - 1;

                    if (rightDownRow >= row || rightDownCol >= column) {
                        break;
                    }


                    if (dpcolumn[rightDownRow][rightDownCol] >= k && dpcolumn[leftUpRow][rightDownCol] >= k
                            && dprow[rightDownRow][leftUpCol] >= k && dprow[rightDownRow][rightDownCol] >= k) {
                        maxsize = Math.max(maxsize, k);

                    }
                }

            }
        }

        return maxsize;

    }


    public static int[][] generateRandom01Matrix(int rowSize, int colSize) {
        int[][] res = new int[rowSize][colSize];
        for (int i = 0; i != rowSize; i++) {
            for (int j = 0; j != colSize; j++) {
                res[i][j] = (int) (Math.random() * 2);
            }
        }
        return res;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}};
//        int[][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
//        char[][] matrix ={{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};

        for (int i = 0; i < 1000; i++) {
            int[][] matrix = generateRandom01Matrix(100, 90);
            int num1 = MaxOneBorderSize(matrix);
            int num2 = com.java.study.answer.zuo.dadvanced.advanced_class_04.Code_05_MaxOneBorderSize.getMaxSize(matrix);
            System.out.println(num1 == num2);
            if (num1 != num2) {
                System.out.println("出错啦");
            }
        }


    }
}