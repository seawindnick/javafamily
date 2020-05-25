package com.java.study.offer.chapter3;

import java.util.Objects;

public class TwoDimensionalArrayExclude {


    public static void main(String[] args) {
        int rowNumber = 5;
        int columnNumber = 6;
        int[][] arr = new int[rowNumber][columnNumber];
        for (int row = 1; row < (rowNumber + 1); row++) {
            for (int column = 1; column < (columnNumber + 1); column++) {
                arr[row - 1][column - 1] = row * 10 + column;
            }
        }

        Integer targetValue = 42;
        Boolean flag = findValue(arr, targetValue);
        System.out.println(flag);
    }

    private static Boolean findValue(int[][] arr, Integer targetValue) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return Boolean.FALSE;
        }

        int columnIndex = arr[0].length - 1;
        int rowIndex = 0;
        while (columnIndex >= 0 && rowIndex <= arr.length - 1) {
            int indexValue = arr[rowIndex][columnIndex];
            if (indexValue == targetValue) {
                return Boolean.TRUE;
            }

            if (indexValue > targetValue) {
                columnIndex--;
            } else {
                rowIndex++;
            }
        }
        return Boolean.FALSE;
    }
}
