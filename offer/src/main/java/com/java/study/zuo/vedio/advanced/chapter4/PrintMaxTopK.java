package com.java.study.zuo.vedio.advanced.chapter4;

import lombok.Data;

import java.util.Arrays;

/**
 * <Description>
 * 打印N个数组整体最大的Top K
 * 【题目】 有N个长度不一的数组，所有的数组都是有序的，请从大到小打 印这N个数组整体最大的前K个数。
 * 例如，输入含有N行元素的二维数组可以代表N个一维数组。
 * 219,405,538,845,971
 * 148,558
 * 52,99,348,691
 * 再输入整数k=5，则打印:
 * Top 5: 971,845,691,558,538
 * 【要求】
 * 1.如果所有数组的元素个数小于K，则从大到小打印所有的数。
 * 2.要求时间复杂度为O(KlogN)。
 *
 * @author hushiye
 * @since 2020-09-09 15:57
 */
public class PrintMaxTopK {

    @Data
    public static class HeapNode {
        //队顶元素值
        private int value;
        //哪行数据
        private int arrNum;
        //角标位置
        private int index;

        public HeapNode(int matrix, int i, int index) {
            this.value = matrix;
            this.arrNum = i;
            this.index = index;
        }

        public HeapNode() {
        }
    }

    public static void printMaxTopK(int[][] arr, int topK) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int heapSize = arr.length;
        HeapNode[] heapNodes = new HeapNode[heapSize];

        int curIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] row = arr[i];
            HeapNode heapNode = new HeapNode();
            heapNode.setValue(row[row.length - 1]);
            heapNode.setArrNum(i);
            heapNode.setIndex(row.length - 1);
            heapInsert(heapNodes, curIndex++, heapNode);
        }


        for (int i = 0; i < topK; i++) {

            if (heapSize == 0) {
                break;
            }
            HeapNode heapNode = heapNodes[0];
            System.out.println(heapNodes[0].value);

            if (heapNode.index != 0) {
                heapNode.index--;
                heapNode.value = arr[heapNode.arrNum][heapNode.index];
            } else {
                swap(heapNodes, 0, --heapSize);
            }
            heapfy(heapNodes, heapSize);
        }

    }

    private static void heapfy(HeapNode[] heapNodes, int heapSize) {
        int curIndex = 0;
        int leftIndex = curIndex * 2 + 1;
        while (leftIndex < heapSize) {
            int maxIndex = leftIndex + 1 >= heapSize ? leftIndex : heapNodes[leftIndex].value > heapNodes[leftIndex + 1].value ? leftIndex : leftIndex + 1;
            maxIndex = heapNodes[curIndex].value >= heapNodes[maxIndex].value ? curIndex : maxIndex;
            if (maxIndex == curIndex) {
                return;
            }
            swap(heapNodes, curIndex, maxIndex);

            curIndex = maxIndex;
            leftIndex = 2 * curIndex + 1;
        }
    }

    private static void heapInsert(HeapNode[] heapNodes, int curIndex, HeapNode heapNode) {
        heapNodes[curIndex] = heapNode;
        while (curIndex != 0) {
            int parentIndex = (curIndex - 1) / 2;
            HeapNode parentNode = heapNodes[parentIndex];
            if (parentNode.value < heapNode.value) {
                swap(heapNodes, parentIndex, curIndex);
                curIndex = parentIndex;
            } else {
                break;
            }
        }

    }

    private static void swap(HeapNode[] heapNodes, int parentIndex, int curIndex) {
        HeapNode firstNode = heapNodes[parentIndex];
        heapNodes[parentIndex] = heapNodes[curIndex];
        heapNodes[curIndex] = firstNode;
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
        int[][] matrix = generateRandomMatrix(5, 10, 1000);
        printMatrix(matrix);
        System.out.println("===========================");
        printMaxTopK(matrix,100);

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


}
