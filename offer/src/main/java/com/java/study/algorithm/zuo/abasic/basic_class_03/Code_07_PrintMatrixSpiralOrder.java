package com.java.study.algorithm.zuo.abasic.basic_class_03;

/**
 * 转圈打印矩阵
 * 【题目】
 * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如:
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 打印结果为:
 * 1，2，3，4，8，12，16，15，14，13，9，5，6，7，11， 10
 * 【要求】 额外空间复杂度为O(1)。
 */
public class Code_07_PrintMatrixSpiralOrder {


    public static void PrintMatrixSpiralOrder(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return;
        }


        int rowLength = arr.length - 1;
        int columnLength = arr[0].length - 1;

        int lc = 0;
        int lr = 0;

        int rc = columnLength;
        int rr = rowLength;

        print(arr, lc, lr, rc, rr);
    }

    /**
     * @param arr
     * @param lc  左上点X坐标
     * @param lr  左上点Y坐标
     * @param rc  右下点X坐标
     * @param rr  右下点Y坐标
     */
    private static void print(int[][] arr, int lc, int lr, int rc, int rr) {
        if (rc < 0 || rr < 0 || lc > arr[0].length || lr > arr.length || lc > rc || lr > lr) {
            return;
        }

        /**
         * 1.只有一行打印
         * 2.只有一列打印
         * 3. 第一行从左向右打印
         *    最后一列从上往下打印
         *    最后一行从右向左打印
         *    第一列从下往上打印
         *
         */

        if (lr == rr) {
            while (lc <= rc) {
                System.out.print(arr[lc++][lr] + " ");
            }
            return;
        }

        if (lc == rc) {
            while (lr <= rr) {
                System.out.print(arr[lc][lr++] + " ");
            }

            return;
        }

        int tempLr = lr;
        int tempLc = lc;

        //打印头一行 行数不变，列数++
        // 左列小于右列 ， 以[左行][列++]
        while (tempLc < rc) {
            System.out.print(arr[lr][tempLc++] + "  ");
        }

        // 打印最后一列 ,列数不变，行数++
        // 左行 < 右行 [行++][右列]
        while (tempLr < rr) {
            System.out.print(arr[tempLr++][rc] + "  ");
        }
        // 打印最后一行，行数不变，列数--
        // 右列 > 左列 [右行][列--]
        while (tempLc > lc) {
            System.out.print(arr[rr][tempLc--] + "  ");
        }


        //打印第一列，列数不变，行数--
        //右行 > 左行 [行--][左列]
        while (tempLr > lr) {
            System.out.print(arr[tempLr--][lc] + "  ");
        }


        print(arr, ++lc, ++lr, --rc, --rr);
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 21},
                         {5, 6, 7, 8, 33},
                        {9, 10, 11, 12, 44},
                        {13, 14, 15, 16, 88}};
        PrintMatrixSpiralOrder(matrix);

    }
}