package com.java.study.zuo.vedio.basic.chapter1;

import java.util.Arrays;

/**
 * <Description>
 * 归并排序
 *
 * @author hushiye
 * @since 2020-08-17 16:06
 */
public class MergeSort {


    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int[] copyArr = new int[arr.length];

        int startIndex = 0;
        int endIndex = arr.length - 1;
        partition(arr, startIndex, endIndex, copyArr);

    }

    private static void partition(int[] arr, int startIndex, int endIndex, int[] copyArr) {
        if (startIndex >= endIndex || endIndex >= arr.length) {
            return;
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;
        partition(arr, startIndex, midIndex, copyArr);
        partition(arr, midIndex + 1, endIndex, copyArr);
        merge(arr, startIndex, midIndex, endIndex, copyArr);
    }

    private static void merge(int[] arr, int startIndex, int midIndex, int endIndex, int[] copyArr) {
        //起于开始，终于中间
        int l = startIndex;
        //起于中间之后，终于末尾
        int r = midIndex + 1;

        int copyCurIndex = startIndex;
        while (l <= midIndex && r <= endIndex) {
            copyArr[copyCurIndex++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
        }

        while (l <= midIndex) {
            copyArr[copyCurIndex++] = arr[l++];
        }

        while (r <= endIndex) {
            copyArr[copyCurIndex++] = arr[r++];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            arr[i] = copyArr[i];
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
