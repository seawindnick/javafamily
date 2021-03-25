package com.java.study.algorithm.zuo.abasic.basic_class_03;

/**
 * 之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，例如:
 * <p>
 * 1    2    3    4
 * <p>
 * 5    6    7    8
 * <p>
 * 9   10   11   12
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * “之”字形打印的结果为:1，2，5，9，6，3，4，7，10，11，8，12
 * 【要求】 额外空间复杂度为O(1)。
 */
public class Code_08_ZigZagPrintMatrix {

    public static void ZigZagPrintMatrix(int[][] arr) {
        if (arr == null || arr.length <= 0 || arr[0].length <= 0) {
            return;
        }

        int rowLength = arr.length - 1;
        int columnLength = arr[0].length - 1;

        int lc = 0;
        int lr = 0;
        int rc = 0;
        int rr = 0;
        boolean flag = false;


        while (lc <= columnLength) {
            print(arr, lc, lr, rc, rr, flag = !flag);

            lc = lr == rowLength ? ++lc : lc;
            lr = lr == rowLength ? lr : ++lr;

            rr = rc == columnLength ? ++rr : rr;
            rc = rc == columnLength ? rc : ++rc;

//            //左节点下移，下移到末尾进行右移
//            if (lr == rowLength) {
//                lc++;
//            } else {
//                lr++;
//            }
//            //右节点右移，到最后一列进行下移
//            if (rc == columnLength) {
//                rr++;
//            } else {
//                rc++;
//            }    //左节点下移，下移到末尾进行右移
////            if (lr == rowLength) {
////                lc++;
////            } else {
////                lr++;
////            }
////            //右节点右移，到最后一列进行下移
////            if (rc == columnLength) {
////                rr++;
////            } else {
////                rc++;
////            }
        }

    }

    private static void print(int[][] arr, int lc, int lr, int rc, int rr, boolean up) {
        //左下向右上 行-- 列++
        if (up) {
            while (lc <= rc) {
                System.out.print(arr[lr--][lc++] + "  ");
            }

        } else {
            //右上到左下 列-- 行++
            while (lc <= rc) {
                System.out.print(arr[rr++][rc--] + "  ");
            }

        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        ZigZagPrintMatrix(matrix);

    }


}