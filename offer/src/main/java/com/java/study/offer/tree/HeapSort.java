package com.java.study.offer.tree;

import com.alibaba.fastjson.JSONArray;

public class HeapSort {


    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 6, 0, 1, 2, 3, 4,};
        heapSort(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int length = arr.length - 1;
        for (int i = length >> 1; i > 0; i--) {
            maxHeapAdjust(arr, i, length);
        }

        for (int i = length; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapAdjust(arr, 1, i - 1);
        }


    }

    private static void maxHeapAdjust(int[] arr, int i, int length) {
        int temp, j;
        temp = arr[i];
        for (j = 2 * i; j < length; j = j * 2) {
            if (j < length && arr[j] < arr[j + 1]) {
                ++j;
            }

            if (temp > arr[j]) {
                break;
            }

            arr[i] = arr[j];
            i = j;
        }
        arr[i] = temp;
    }


    private static void swap(int[] arr, int i, int maxPosition) {
        int temp = arr[i];
        arr[i] = arr[maxPosition];
        arr[maxPosition] = temp;
    }
}
