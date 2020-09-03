package com.java.study.zuo.vedio.basic.chapter7;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-27 09:08
 */
public class MinPath {

    public static int minPath(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int startRow = 0;
        int startCloumn = 0;
        int endRow = arr.length - 1;
        int endCloumn = arr[0].length - 1;
        int result = 0;
        return getMinPath(arr, startRow, startCloumn, endRow, endCloumn);
    }

    private static int getMinPath(int[][] arr, int startRow, int startCloumn, int endRow, int endCloumn) {
        if (startRow == endRow && startCloumn == endCloumn) {
            return arr[startRow][startCloumn];
        }

        if (startRow == endRow) {
            return arr[startRow][startCloumn] + getMinPath(arr, startRow, startCloumn + 1, endRow, endCloumn);
        } else if (startCloumn == endCloumn) {
            return arr[startRow][startCloumn] + getMinPath(arr, startRow + 1, startCloumn, endRow, endCloumn);
        } else {
            return arr[startRow][startCloumn] + Math.min(getMinPath(arr, startRow, startCloumn + 1, endRow, endCloumn),
                    getMinPath(arr, startRow + 1, startCloumn, endRow, endCloumn));
        }
    }


    private static int getMinPath2(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }


        int endRow = arr.length - 1;
        int endCloumn = arr[0].length - 1;
        int[][] deep = new int[endRow+1][endCloumn+1];

        deep[0][0] = arr[0][0];
        for (int i = 1; i < arr[0].length; i++) {
            deep[0][i] = deep[0][i - 1] + arr[0][i];
        }

        for (int i = 1; i < arr.length; i++) {
            deep[i][0] = deep[i-1][0]+arr[i][0];
        }

        for (int i = 1; i <= endRow; i++) {
            for (int j = 1; j <= endCloumn ; j++) {
                deep[i][j] = arr[i][j] + Math.min(deep[i][j-1],deep[i-1][j]);
            }
        }
        return deep[endRow][endCloumn];

    }


    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}};
        System.out.println(getMinPath2(m));
    }
}
