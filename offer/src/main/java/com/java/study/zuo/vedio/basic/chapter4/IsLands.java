package com.java.study.zuo.vedio.basic.chapter4;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-25 23:45
 */
public class IsLands {


    public static int countIslands(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }

        int sum = 0;
        int row = arr.length;
        int cloumn = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cloumn; j++) {
                if (arr[i][j] == 1) {
                    sum++;
                    infection(arr, row, cloumn, i, j);
                }

            }
        }
        return sum;
    }

    private static void infection(int[][] arr, int row, int cloumn, int indexRow, int indexCloumn) {
        if (indexRow == row || indexCloumn == cloumn || indexCloumn < 0 || indexRow < 0 || arr[indexRow][indexCloumn] != 1) {
            return;
        }
        arr[indexRow][indexCloumn] = 2;
        infection(arr, row, cloumn, indexRow - 1, indexCloumn);
        infection(arr, row, cloumn, indexRow + 1, indexCloumn);
        infection(arr, row, cloumn, indexRow, indexCloumn - 1);
        infection(arr, row, cloumn, indexRow, indexCloumn + 1);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));

    }
}
