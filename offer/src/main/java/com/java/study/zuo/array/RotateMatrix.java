package com.java.study.zuo.array;

/**
 * 旋转矩阵
 * 给定一个正方形矩阵，将矩阵顺时针旋转90度
 */
public class RotateMatrix {


    public static void rotateMatrix(int[][] arr) {
        if (arr.length == 0) {
            return;
        }

        int[] row = arr[0];

        //左上点坐标
        int SR = 0;
        int SC = 0;

        //右下点坐标
        int ER = arr.length - 1;
        int EC = row.length - 1;

        while (SR <= ER) {
            rotateMatrix(arr, SR++, SC++, ER--, EC--);
        }
    }

    /**
     * @param arr
     * @param SR  左上行
     * @param SC  左上列
     * @param ER  右下行
     * @param EC  右下列
     */
    private static void rotateMatrix(int[][] arr, int SR, int SC, int ER, int EC) {


        //最终列与起始列相减,即为一圈需要替换的次数
        int length = EC - SC;

        for (int i = 0; i < length; i++) {

            /**
             * 左上点 SR，SC+i
             * 右上点 SR+i  ,EC
             * 右下点 ER,EC-i
             * 左下点 ER-i ,SC
             */

            //左上点
            int temp = arr[SR][SC + i];

            //左上点值=左下点值
            arr[SR][SC + i] =  arr[ER - i][SC];

            //左下点值= 右下点值
            arr[ER - i][SC] =  arr[ER][EC - i];

            //右下点值=右上点值
            arr[ER][EC - i] = arr[SR + i][EC];

            //右上点值= 左上点值
            arr[SR + i][EC] = temp;

        }

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateMatrix(arr);

    }

}
