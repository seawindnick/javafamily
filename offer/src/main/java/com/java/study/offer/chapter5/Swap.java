package com.java.study.offer.chapter5;

import com.alibaba.fastjson.JSONArray;

import java.util.Objects;

public class Swap {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 6, 7, 8, 2, 10, 3, 12};
        //奇数在前，偶数在后s
        swap(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }

    private static void swap(int[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex < endIndex){
            while (startIndex < endIndex && isEvent(arr[startIndex])) {
                startIndex++;
            }

            while (startIndex < endIndex && !isEvent(arr[endIndex])) {
                endIndex--;
            }

            if (startIndex < endIndex) {
                int tempValue = arr[startIndex];
                arr[startIndex] = arr[endIndex];
                arr[endIndex] = tempValue;
                startIndex++;
                endIndex--;
            }

        }

    }

    private static boolean isEvent(int value) {
        return (value % 3) == 0;
    }

}
