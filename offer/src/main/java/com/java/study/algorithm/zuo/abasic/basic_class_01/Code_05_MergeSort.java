package com.java.study.algorithm.zuo.abasic.basic_class_01;

import com.alibaba.fastjson.JSONArray;

/**
 * 归并排序
 */
public class Code_05_MergeSort {

    public static void MergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int[] array = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, array);

    }

    /**
     * @param arr
     * @param startIndex 开始Index
     * @param endIndex
     */
    private static void mergeSort(int[] arr, int startIndex, int endIndex, int[] array) {
        if (startIndex >= endIndex) {
            return;
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;
        mergeSort(arr, startIndex, midIndex, array);
        mergeSort(arr, midIndex + 1, endIndex, array);
        merge(arr, startIndex, midIndex, endIndex, array);


    }

    private static void merge(int[] arr, int startIndex, int midIndex, int endIndex, int[] arrayCopy) {
        int L = startIndex;
        int R = midIndex + 1;

        int curIndex = startIndex;
        while (L <= midIndex && R <= endIndex) {
            arrayCopy[curIndex++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
        }

        while (L <= midIndex) {
            arrayCopy[curIndex++] = arr[L++];
        }

        while (R <= endIndex) {
            arrayCopy[curIndex++] = arr[R++];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            arr[i] = arrayCopy[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 6, 0, 1, 2, 6, 8, 3};
        MergeSort(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }
}