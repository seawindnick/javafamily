package com.java.study.zuo.vedio.advanced.chapter4;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 * 边界都是1的最大正方形大小
 * 【题目】 给定一个NN的矩阵matrix，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方 形的边长长度。
 * 例如:
 * 0,1,1,1,1
 * 0,1,0,0,1
 * 0,1,0,0,1
 * 0,1,1,1,1
 * 0,1,0,1,1
 * 其中，边框全是1的最大正方形的大小为4*4，所以返回4。
 *
 * @author hushiye
 * @since 2020-09-10 18:40
 */
public class MaxOneBorderSize {


    public static int maxOneBorderSize(int[][] martix) {
        if (martix.length == 0 || martix[0].length == 0) {
            return 0;
        }

        int length = martix.length;
        int column = martix[0].length;
        int[][] downArray = new int[length][column];
        int[][] rightArray = new int[length][column];

        for (int i = 0; i < column; i++) {
            downArray[length - 1][i] = martix[length - 1][i];
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j < column; j++) {
                downArray[i][j] = martix[i][j] == 1 ? downArray[i + 1][j] + 1 : 0;
            }
        }

        for (int i = 0; i < length; i++) {
            rightArray[i][column - 1] = martix[i][column - 1];
        }

        for (int i = 0; i < length; i++) {
            for (int j = column - 2; j >= 0; j--) {
                rightArray[i][j] = martix[i][j] == 1 ? rightArray[i][j + 1] + 1 : 0;
            }
        }

        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < column; j++) {
                if (martix[i][j] == 0) {
                    continue;
                }

                int maxLength = Math.min(length - i, column - j);


                for (int k = 1; k <= maxLength; k++) {
                    boolean flag =  downArray[i][j] >= k && rightArray[i][j] >= k
                            && downArray[i][j+k-1] >= k && rightArray[i+k-1][j] >= k;
                    if (flag) {
                        max = Math.max(max, k);
                    }
                }

            }

        }

        return max;

    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1}};

        System.out.println(maxOneBorderSize(arr));
//        int[][] matrix = generateRandom01Matrix(7, 8);
//        printMatrix(matrix);
//        System.out.println(maxOneBorderSize(matrix));
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
}
