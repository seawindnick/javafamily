package com.java.study.zuo.array;

/**
 * 按圈打印矩阵
 */
public class PrintMatrixSpiralOrder {


    public static void printMatrixSpiralOrder(int[][] arr) {
        if (arr.length < 1) {
            return;
        }

        int[] firstRow = arr[0];
        //左上点位置
        int LR = 0;
        int LC = 0;

        //右下点位置
        int RR = arr.length - 1;
        int RC = firstRow.length - 1;

        while (LR <= RR && LC <= RC) {
            printMatrixSpiralOrder(arr, LR++, LC++, RR--, RC--);
        }
    }

    /**
     * @param arr
     * @param LR  左上点行号
     * @param LC  左上点列号
     * @param RR  右上点行号
     * @param RC  右上点列号
     */
    private static void printMatrixSpiralOrder(int[][] arr, int LR, int LC, int RR, int RC) {
        //同一行，只需要按照列数进行打印
        if (LR == RR) {
            while (LC <= RC) {
                System.out.printf(arr[LR][LC++] + " ");
            }
            System.out.println();
        } else if (LC == RC) {
            //同一列，按照行数进行打印
            while (LR <= RR) {
                System.out.printf(arr[LR++][LC] + " ");
            }
            System.out.println();
        } else {
            int curR = LR;
            int curC = LC;

            //打印首行 LC --- RC 数据
            while (curC != RC) {
                System.out.printf(arr[LR][curC++] + " ");
            }
            System.out.println();
            //打印最后列  LR ---- RR 数据
            while (curR < RR) {
                System.out.printf(arr[curR++][RC] + " ");
            }
            System.out.println();
            // 逆序打印最后行  RC ---- LC
            while (curC > LC) {
                System.out.printf(arr[RR][curC--] + " ");

            }
            System.out.println();
            while (curR > LR) {
                System.out.printf(arr[curR--][LC] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}, {13, 14, 15}};
        printMatrixSpiralOrder(arr);

    }
}
