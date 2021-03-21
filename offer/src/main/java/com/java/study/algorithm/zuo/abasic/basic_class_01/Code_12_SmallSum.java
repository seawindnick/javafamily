package com.java.study.algorithm.zuo.abasic.basic_class_01;

import com.alibaba.fastjson.JSONArray;

/**
 * 归并求小和
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 */
public class Code_12_SmallSum {


    public static int SmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int[] arrCopy = new int[arr.length];
        return SmallSum(arr, 0, arr.length - 1, arrCopy);

    }

    private static int SmallSum(int[] arr, int left, int right, int[] arrCopy) {
        if (left >= right) {
            return 0;
        }


        int midIndex = left + (right - left) / 2;
        int leftSum = SmallSum(arr, left, midIndex, arrCopy);
        int rightSum = SmallSum(arr, midIndex + 1, right, arrCopy);
        int mergeSum = merge(arr, left, midIndex, right, arrCopy);
        return leftSum + rightSum + mergeSum;
    }

    private static int merge(int[] arr, int startIndex, int midIndex, int endIndex, int[] arrCopy) {
        int L = startIndex;
        int R = midIndex + 1;

        int curIndex = startIndex;
        int sum = 0;
        while (L <= midIndex && R <= endIndex) {
            // 小于时进行小和计算
            if (arr[L] < arr[R]) {
                sum += arr[L] * (endIndex - R + 1);
            }

            //左边等于右边时，优先将右边的数据先进行归并处理

            arrCopy[curIndex++] = arr[L] < arr[R] ? arr[L++] : arr[R++];

        }

        while (L <= midIndex) {
            arrCopy[curIndex++] = arr[L++];
        }

        while (R <= endIndex) {
            arrCopy[curIndex++] = arr[R++];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            arr[i] = arrCopy[i];
        }
        return sum;

    }


    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (SmallSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }


}