package com.java.study.test;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-09 10:04
 */
public class IsLand {


    public static int landSum(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }

        int sum = 0;

        for (int row = 0; row < arr.length; row++) {
            for (int cloumn = 0; cloumn < arr[0].length; cloumn++) {
                if (arr[row][cloumn] == 1) {
                    sum++;
                    replace(arr, row, cloumn);
                }
            }

        }

        return sum;

    }

    private static void replace(int[][] arr, int row, int cloumn) {
        if (row == arr.length || cloumn == arr[0].length || row < 0 || cloumn < 0 || arr[row][cloumn] != 1) {
            return;
        }

        arr[row][cloumn] = 2;
        replace(arr, row - 1, cloumn);
        replace(arr, row + 1, cloumn);
        replace(arr, row, cloumn - 1);
        replace(arr, row, cloumn + 1);

    }


    public static void main(String[] args) {

        int[][] arr = {{1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 1}};
        System.out.println(landSum(arr));


    }

}
