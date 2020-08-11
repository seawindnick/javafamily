package com.java.study.zuo.array;

/**
 * <Description>
 * 查询岛数量
 *
 * @author hushiye
 * @since 2020-08-03 14:20
 */
public class Island {


    public static int countIslands(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int rowNum = arr.length;
        int columnNum = arr[0].length;

        int sum = 0;
        for (int row = 0; row < rowNum; row++) {
            for (int cloumn = 0; cloumn < columnNum; cloumn++) {
                if (arr[row][cloumn] == 1) {
                    sum++;
                    infected(arr, row, cloumn, rowNum, columnNum);
                }

            }
        }
        return sum;
    }

    private static void infected(int[][] arr, int row, int cloumn, int rowNum, int columnNum) {
        if (row == rowNum || cloumn == columnNum || row < 0 || cloumn < 0 || arr[row][cloumn] != 1) {
            return;
        }
        arr[row][cloumn] = 2;
        infected(arr, row - 1, cloumn, rowNum, columnNum);
        infected(arr, row + 1, cloumn, rowNum, columnNum);
        infected(arr, row, cloumn - 1, rowNum, columnNum);
        infected(arr, row, cloumn + 1, rowNum, columnNum);
    }


    public static void main(String[] args) {
        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                      {0, 1, 1, 1, 0, 1, 1, 1, 0},
                      {0, 1, 1, 1, 0, 0, 0, 1, 0},
                      {0, 1, 1, 0, 0, 0, 0, 0, 0},
                      {0, 0, 0, 0, 0, 1, 1, 0, 0},
                      {0, 0, 0, 0, 1, 1, 1, 0, 0},
                      {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m1));

        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                      {0, 1, 1, 1, 1, 1, 1, 1, 0},
                      {0, 1, 1, 1, 0, 0, 0, 1, 0},
                      {0, 1, 1, 0, 0, 0, 1, 1, 0},
                      {0, 0, 0, 0, 0, 1, 1, 0, 0},
                      {0, 0, 0, 0, 1, 1, 1, 0, 0},
                      {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(countIslands(m2));

    }

}
