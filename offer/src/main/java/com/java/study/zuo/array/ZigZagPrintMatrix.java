package com.java.study.zuo.array;

/**
 * 之字形打印矩阵
 */
public class ZigZagPrintMatrix {


    public static void zigZagPrintMatrix(int arr[][]) {
        if (arr == null || arr.length < 1) {
            return;
        }

        int[] firstRow = arr[0];


        int RR = arr.length - 1;
        int RC = firstRow.length - 1;

        int tR = 0;
        int tC = 0;

        int dR = 0;
        int dC = 0;
        boolean upFlag = true;
        while (dC <= RC) {
            zigZagPrintMatrix(arr, tR, tC, dR, dC, upFlag);
            //下一次计算 左下节点与右上节点位置信息

            //右上节点到达最后一列,行下移，否则列后移
            if (tC == RC) {
                tR++;
            } else {
                tC++;
            }

            //左下节点到达最后一行,列后移，否则行下移
            if (dR == RR) {
                dC++;
            } else {
                dR++;
            }

            upFlag = !upFlag;
        }
    }

    /**
     * @param arr
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     * @param upFlag
     */
    private static void zigZagPrintMatrix(int[][] arr, int tR, int tC, int dR, int dC, boolean upFlag) {
        while (tC >= dC) {
            if (upFlag) {
                System.out.printf(arr[dR--][dC++] + " ");
            } else {
                System.out.printf(arr[tR++][tC--] + " ");
            }
        }


        System.out.println();

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}, {16, 17, 18}};
        zigZagPrintMatrix(arr);
    }
}
