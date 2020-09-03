package com.java.study.zuo.vedio.basic.chapter3;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 15:48
 */
public class MatrixPrint {

    public static void print(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        //左上点坐标
        int lR = 0;
        int lC = 0;

        //右下点坐标
        int rR = arr.length - 1;
        int rC = arr[0].length - 1;

        while (lR <= rR && lC <= rR) {
            print(arr, lR++, lC++, rR--, rC--);
        }

    }

    /**
     * @param arr
     * @param lR  左上点行号
     * @param lC  左上点列号
     * @param rR  右上点行号
     * @param rC  右上点列号
     */
    private static void print(int[][] arr, int lR, int lC, int rR, int rC) {

        //一行 从前向后打印
        if (lR == rR) {
            for (int i = lC; i <= rC; i++) {
                System.out.print(arr[lR][i] + " ");
            }
            System.out.println();
        } else if (lC == rC) { //一列，从上往下打印
            for (int i = lR; i <= rR; i++) {
                System.out.printf(arr[lR][lC] + " ");
            }
            System.out.println();

        } else {
            for (int i = lC; i < rC; i++) {
                System.out.printf(arr[lR][i] + " ");
            }
            System.out.println();
            for (int i = lR; i < rR; i++) {
                System.out.printf(arr[i][rC] + " ");
            }
            System.out.println();
            for (int i = rC; i > lC; i--) {
                System.out.printf(arr[rR][i] + " ");
            }
            System.out.println();

            for (int i = rR; i > lR; i--) {
                System.out.printf(arr[i][lC]+" ");
            }
            System.out.println();
        }



    }

    public static void main(String[] args) {
        int[][] matrix =  { { 1, 2, 3, 4 },
                            { 5, 6, 7, 8 },
                            { 9, 10, 11, 12 },
                            { 13, 14, 15, 16 } };
        print(matrix);

    }
}
