package com.java.study.zuo.basic.chaptertemp;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 *
 * @author hushiye
 * @since 3/17/21 23:08
 */
public class MergeSort {


    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int left = 0;
        int rightIndex = arr.length - 1;
        int[] copyArray = new int[arr.length];
        mergeSort(arr, left, rightIndex, copyArray);

    }


    private static void mergeSort(int[] arr, int left, int rightIndex, int[] copyArray) {
        if (left >= rightIndex) {
            return;
        }

        int midIndex = left + (rightIndex - left) / 2;
        mergeSort(arr, left, midIndex, copyArray);
        mergeSort(arr, midIndex + 1, rightIndex, copyArray);
        merge(arr, left, midIndex, rightIndex, copyArray);
    }

    private static void merge(int[] arr, int startIndex, int midIndex, int endIndex, int[] copyArray) {

        int L = startIndex;
        int R = midIndex + 1;

        int curIndex = L;
        while (L <= midIndex && R <= endIndex) {
            copyArray[curIndex++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
        }

        while (L <= midIndex) {
            copyArray[curIndex++] = arr[L++];
        }

        while (R <= endIndex) {
            copyArray[curIndex++] = arr[R++];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            arr[i] = copyArray[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 7, 5, 10, 3, 2, 4};
        mergeSort(arr);
        System.out.println(JSONArray.toJSONString(arr));

    }
}
