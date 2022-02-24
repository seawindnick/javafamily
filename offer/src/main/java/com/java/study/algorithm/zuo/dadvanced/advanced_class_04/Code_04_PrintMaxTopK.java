package com.java.study.algorithm.zuo.dadvanced.advanced_class_04;

import lombok.Data;

import java.util.Arrays;

/**
 * 打印N个数组整体最大的Top K
 * 【题目】 有N个长度不一的数组，所有的数组都是有序的，请从大到小打 印这N个数组整体最大的前K个数。 例如，输入含有N行元素的二维数组可以代表N个一维数组。
 * 219,405,538,845,971
 * 148,558
 * 52,99,348,691
 * 再输入整数k=5，则打印:
 * Top 5: 971,845,691,558,538
 * 【要求】
 * 1.如果所有数组的元素个数小于K，则从大到小打印所有的数。
 * 2.要求时间复杂度为O(KlogN)。
 * <p>
 * 堆排序
 */
public class Code_04_PrintMaxTopK {


    public static void PrintMaxTopK(int[][] martix, int k) {

        if (martix == null || martix.length == 0) {
            return;
        }

        HeapHead[] heapHeadArray = new HeapHead[martix.length];
        int curIndex = 0;

        for (int i = 0; i < martix.length; i++) {
            HeapHead heapHead = new HeapHead();
            heapHead.row = i;
            if (martix[i] != null && martix.length == 0) {
                heapHead.index = -1;
                heapHead.value = Integer.MIN_VALUE;

            } else {
                heapHead.index = martix[i].length - 1;
                heapHead.value = martix[i][heapHead.index];
            }

            heapHeadInsert(heapHeadArray, curIndex, heapHead);
            curIndex++;
        }

        while (k > 0) {
            HeapHead heapHead = heapHeadArray[0];
            if (heapHead.index == -1) {
                return;
            }
            System.out.println(heapHead.value);

            if (heapHead.index != 0) {
                heapHead.index = heapHead.index - 1;
                heapHead.value = martix[heapHead.row][heapHead.index];
            } else {
                heapHead.index = -1;
                heapHead.value = Integer.MIN_VALUE;
            }

            heapHeadHapty(heapHeadArray, 0);
        }


    }

//
//    public static void PrintMaxTopK(int[][] martix, int k) {
//
//        if (martix == null || martix.length == 0) {
//            return;
//        }
//
//        HeapHead[] heapHeadArray = new HeapHead[martix.length];
//        int curIndex = 0;
//
//        for (int i = 0; i < martix.length; i++) {
//            HeapHead heapHead = new HeapHead();
//            heapHead.row = i;
//            if (martix[i] != null && martix.length == 0) {
//                heapHead.index = -1;
//                heapHead.value = Integer.MIN_VALUE;
//
//            } else {
//                heapHead.index = martix[i].length - 1;
//                heapHead.value = martix[i][heapHead.index];
//            }
//
//            heapHeadInsert(heapHeadArray, curIndex, heapHead);
//            curIndex++;
//        }
//
//        while (k > 0) {
//            HeapHead heapHead = heapHeadArray[0];
//            if (heapHead.index == -1) {
//                return;
//            }
//            System.out.println(heapHead.value);
//
//            heapHeadArray[0] = heapHeadArray[heapHeadArray.length - 1];
//            heapHeadHapty(heapHeadArray, 0);
//
//            if (heapHead.index != 0) {
//                heapHead.index = heapHead.index - 1;
//                heapHead.value = martix[heapHead.row][heapHead.index];
//            } else {
//                heapHead.index = -1;
//                heapHead.value = Integer.MIN_VALUE;
//            }
//            heapHeadInsert(heapHeadArray, heapHeadArray.length - 1, heapHead);
//        }
//
//
//    }

    private static void heapHeadHapty(HeapHead[] heapHeadArray, int handleIndex) {

        int leftIndex;
        while ((leftIndex = handleIndex * 2 + 1) < heapHeadArray.length) {
            int checkIndex = leftIndex + 1 >= heapHeadArray.length ? leftIndex : (heapHeadArray[leftIndex].value > heapHeadArray[leftIndex + 1].value) ? leftIndex : leftIndex + 1;
            if (heapHeadArray[handleIndex].value >= heapHeadArray[checkIndex].value) {
                break;
            }

            HeapHead temp = heapHeadArray[handleIndex];
            heapHeadArray[handleIndex] = heapHeadArray[checkIndex];
            heapHeadArray[checkIndex] = temp;
            handleIndex = checkIndex;

        }

    }

    private static void heapHeadInsert(HeapHead[] heapHeadArray, int curIndex, HeapHead heapHead) {
        heapHeadArray[curIndex] = heapHead;
        //父节点和该节点进行比较，如果该节点的值大于父节点的值，向上进行移动
        while (curIndex != 0) {
            int parentIndex = (curIndex - 1) / 2;
            if (heapHeadArray[parentIndex].value < heapHeadArray[curIndex].value) {
                heapHeadArray[curIndex] = heapHeadArray[parentIndex];
                heapHeadArray[parentIndex] = heapHead;
                curIndex = parentIndex;
            } else {
                break;
            }
        }


    }


    @Data
    public static class HeapHead {
        private int value;
        private int row;
        private int index;
    }


    public static int[][] generateRandomMatrix(int maxRow, int maxCol,
                                               int maxValue) {
        if (maxRow < 0 || maxCol < 0) {
            return null;
        }
        int[][] matrix = new int[(int) (Math.random() * maxRow) + 1][];
        for (int i = 0; i != matrix.length; i++) {
            matrix[i] = new int[(int) (Math.random() * maxCol) + 1];
            for (int j = 0; j != matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * maxValue);
            }
            Arrays.sort(matrix[i]);
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix(5, 5, 1000);
        printMatrix(matrix);
        System.out.println("===========================");
        PrintMaxTopK(matrix, 100);
    }
}