package com.java.study.zuo.sort.MergeSort;

import com.alibaba.fastjson.JSONArray;

public class ReverseOrderNum {

    public static int calculateReverseOrderNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int[] copyArray = new int[arr.length];
        int sum = calculateReverseOrderNum(arr, 0, arr.length - 1, copyArray);
        return sum;
    }

    private static int calculateReverseOrderNum(int[] arr, int L, int R, int[] copyArray) {
        if (L == R) {
            return 0;
        }

        int midIndex = L + ((R - L) >> 1);

        int leftSum = calculateReverseOrderNum(arr, L, midIndex, copyArray);
        int rightSum = calculateReverseOrderNum(arr, midIndex + 1, R, copyArray);
        int mergeSum = mergeSum(arr, L, R, midIndex, copyArray);
        return leftSum + rightSum + mergeSum;

    }

    private static int mergeSum(int[] arr, int L, int R, int midIndex, int[] copyArray) {
        int LStartIndex = L;
        int RStartIndex = midIndex + 1;
        int copyStartIndex = L;
        int sum = 0;
        while (LStartIndex <= midIndex && RStartIndex <= R) {
            /**
             * 如果左边的数据 > 右边的数据，则 [LStartIndex - midIndex] 之间的数据都大于 右边的数据
             * 计算逆序对数条件与 merge 条件需要一致
             */
            sum += arr[LStartIndex] > arr[RStartIndex] ? (midIndex - LStartIndex + 1) : 0;
            copyArray[copyStartIndex++] = arr[LStartIndex] > arr[RStartIndex] ? arr[RStartIndex++] : arr[LStartIndex++];
        }

        while (LStartIndex <= midIndex) {
            copyArray[copyStartIndex++] = arr[LStartIndex++];
        }
        while (RStartIndex <= R) {
            copyArray[copyStartIndex++] = arr[RStartIndex++];
        }

        for (int i = L; i <= R; i++) {
            arr[i] = copyArray[i];
        }
        return sum;
    }

    // for test
    public static int comparator(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count;
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
        int maxSize = 4;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (calculateReverseOrderNum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                System.out.println(JSONArray.toJSONString(arr2));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }


}
