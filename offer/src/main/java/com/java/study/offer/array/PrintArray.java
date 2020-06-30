package com.java.study.offer.array;

public class PrintArray {
    public static void main(String[] args) {
        int rowNum = 3;
        int column = 6;
        int[][] arr = new int[rowNum][column];

        int count = 1;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = count;
                count++;
            }
        }

        printArr(arr, 0);

    }

    private static void printArr(int[][] arr, int i) {
        int rowNum = arr.length;
        int columnNum = arr[0].length;

        int startRow = i;
        int endRowIndex = rowNum - i - 1;
        int startColumn = i;
        int endColumnIndex = columnNum - i - 1;

        //先打印第一行d
        for (int j = startColumn; j <= endColumnIndex; j++) {
            System.out.print(arr[startRow][j] + " ");
        }
        System.out.println();

        //再打印最后一列
        for (int j = startRow + 1; j <= endRowIndex; j++) {
            System.out.print(arr[j][endColumnIndex] + " ");
        }
        System.out.println();

        //如果有两行以上，可以倒序打印
        if (endRowIndex - startRow >= 1){
            //逆序打印最后一行
            for (int j = endColumnIndex - 1; j >= startColumn; j--) {
                System.out.print(arr[endRowIndex][j] + " ");
            }
            System.out.println();
        }

        //如果有两列以上，可以倒序打印
        if (endColumnIndex - startColumn >= 1 ){
            //逆序打印首列
            for (int j = endRowIndex - 1; j > startRow; j--) {
                System.out.print(arr[j][startRow] + " ");
            }

        }
        //循环到最后只有两行
        if (endColumnIndex - startColumn <= 1 || endRowIndex- startRow <= 1){
            return;
        }
        printArr(arr, ++i);

    }

}
