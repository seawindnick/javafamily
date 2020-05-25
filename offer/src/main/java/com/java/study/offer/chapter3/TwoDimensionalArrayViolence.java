package com.java.study.offer.chapter3;

import java.util.Objects;

public class TwoDimensionalArrayViolence {

    public static void main(String[] args) {
        int rowNumber = 5;
        int columnNumber = 6;
        int[][] arr = new int[rowNumber][columnNumber];
        for (int row = 1; row < (rowNumber + 1); row++) {
            for (int column = 1; column < (columnNumber + 1); column++) {
                arr[row - 1][column - 1] = row * 10 + column;
            }
        }

        Integer targetValue = 33;
        Boolean flag = findValue(arr, targetValue);
        System.out.println(flag);
    }

    private static Boolean findValue(int[][] arr, int targetValue) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return Boolean.FALSE;
        }


        for (int[] rows : arr) {
            for (int columnValue : rows) {
                if (columnValue == targetValue) {
                    return Boolean.TRUE;
                }

                if (columnValue < targetValue) {
                    continue;
                }
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }
}
