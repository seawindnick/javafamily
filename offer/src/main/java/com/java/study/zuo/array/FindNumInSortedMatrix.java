package com.java.study.zuo.array;

/**
 * 排序矩阵中查询数字是否存在
 */
public class FindNumInSortedMatrix {


    public static boolean findNum(int[][] arr, int tagetNum) {
        if (arr == null || arr.length < 1) {
            return Boolean.FALSE;
        }


        int[] firstRow = arr[0];

        int RR = 0;
        int RC = firstRow.length - 1;

        while (RR <= arr.length - 1 && RC >= 0) {
            if (arr[RR][RC] == tagetNum) {
                return Boolean.TRUE;
            }
            if (arr[RR][RC] > tagetNum) {
                RC--;

            } else {
                RR++;
            }
        }

        return Boolean.FALSE;

    }


    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(findNum(matrix, K));
    }


}
