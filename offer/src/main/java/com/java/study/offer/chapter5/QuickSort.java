package com.java.study.offer.chapter5;

import com.alibaba.fastjson.JSONArray;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 7, 3, 1, 6, 9, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(JSONArray.toJSONString(arr));

    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int key = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left < right) {
            //从位到头查询比key小的数据
            while (left < right && arr[right] >= key) {
                right--;
            }

            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                left++;
            }

            arr[right] = arr[left];
        }

        arr[left] = key;
        quickSort(arr, startIndex, left - 1);
        quickSort(arr, left + 1, endIndex);
    }


}
