package com.java.study.zuo.vedio.basic.chapter3;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 16:03
 */
public class ZigZagPrintMatrix {

    private static void print(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int dR = 0;
        int dC = 0;

        int tR = 0;
        int tC = 0;

        boolean upFlag = false;

        int rowLength = matrix.length - 1;
        int cloumnLength = matrix[0].length - 1;

        while (dC != cloumnLength + 1) {
            print(matrix, dR, dC, tR, tC, upFlag);

            dC = dR == rowLength ? ++dC : dC;
            dR = dR == rowLength ? dR : ++dR;

            tR = tC == cloumnLength ? ++tR : tR;
            tC = tC == cloumnLength ? tC : ++tC;
            upFlag = !upFlag;

        }

    }

    private static void print(int[][] matrix, int dR, int dC, int tR, int tC, boolean upFlag) {
        while (dC <= tC && tR <= dR) {
            if (upFlag) {
                System.out.printf("" + matrix[dR--][dC++] + " ");
            } else {
                System.out.printf("" + matrix[tR++][tC--] + " ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        print(matrix);

    }
}
