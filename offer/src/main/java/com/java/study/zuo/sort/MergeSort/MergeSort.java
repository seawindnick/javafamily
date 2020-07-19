package com.java.study.zuo.sort.MergeSort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int L, int R) {

        if (L >= R) {
            return;
        }
        int midIndex = L + ((R - L) >> 1);
        mergeSort(arr, L, midIndex);
        mergeSort(arr, midIndex + 1, R);
        merge(arr, L, R, midIndex);
    }

    private static void merge(int[] arr, int L, int R, int midIndex) {

        int[] tempArr = new int[R - L + 1];
        int tempStartIndex = 0;
        int LStartIndex = L;
        int RStartIndex = midIndex + 1;
        while (LStartIndex <= midIndex && RStartIndex <= R) {
            tempArr[tempStartIndex++] = arr[LStartIndex] < arr[RStartIndex] ? arr[LStartIndex++] : arr[RStartIndex++];
        }

        while (LStartIndex <= midIndex) {
            tempArr[tempStartIndex++] = arr[LStartIndex++];
        }

        while (RStartIndex <= R) {
            tempArr[tempStartIndex++] = arr[RStartIndex++];
        }
        for (int i = 0; i < tempArr.length; i++) {
            arr[L + i] = tempArr[i];
        }
    }


    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
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
//        int[] arr = {5, 4, 6, 7, 2};
//        mergeSort(arr, 0, arr.length-1);
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }


}
