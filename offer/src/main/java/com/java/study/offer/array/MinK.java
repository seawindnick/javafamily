package com.java.study.offer.array;

import com.alibaba.fastjson.JSONArray;

public class MinK {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 8, 9, 1, 2, 0, 23, 54, 2, 23423, 121, 123, 45, 56, 78};
        int mink = 4;
        findMink(arr, mink);
        System.out.println(JSONArray.toJSONString(arr));
    }

    private static void findMink(int[] arr, int mink) {
        if (arr == null || arr.length < mink) {
            throw new RuntimeException("数组长度不够");
        }

        if (arr.length == mink) {
            return;
        }


        int startIndex = 0;
        int endIndex = arr.length - 1;
        int index = sort(arr, startIndex, endIndex);
        int targetIndex = mink - 1;


        while (index != targetIndex) {
            if (targetIndex < index) {
                index = sort(arr, startIndex, index - 1);
            } else {
                index = sort(arr, index + 1, endIndex);
            }
        }

    }

    private static int sort(int[] arr, int startIndex, int endIndex) {
        int targetValue = arr[startIndex];
        while (startIndex < endIndex) {
            while (startIndex < endIndex && arr[endIndex] >= targetValue) {
                endIndex--;
            }

            arr[startIndex] = arr[endIndex];
            while (startIndex < endIndex && arr[startIndex] <= targetValue) {
                startIndex++;
            }
            arr[endIndex] = arr[startIndex];
        }

        arr[startIndex] = targetValue;
        return startIndex;
    }
}
