package com.java.study.offer.array;

import com.alibaba.fastjson.JSONArray;

public class SpiltByNumber {

    public static void main(String[] args) {
        int[] arr = {1,5,4,7,8,3,2};
        spiltByNumber(arr, 6);
        System.out.println(JSONArray.toJSONString(arr));
    }

    private static void spiltByNumber(int[] arr, int number) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int leftIndex = -1;
        int startIndex = 0;
        while (startIndex < arr.length) {
            if (arr[startIndex] >= number) {
                startIndex++;
            } else {
                leftIndex++;
                swap(arr, leftIndex, startIndex);
                startIndex++;
            }
        }

    }

//    private static void spiltByNumber(int[] arr, int number) {
//        if (arr == null || arr.length < 2) {
//            return;
//        }
//
//        int left = 0;
//        int right = arr.length - 1;
//        while (left < right) {
//            while (left < right && arr[left] < number) {
//                left++;
//            }
//
//            while (left < right && arr[right] > number) {
//                right--;
//            }
//
//            if (left < right) {
//                swap(arr, left, right);
//                left++;
//                right--;
//            }
//
//        }


//        int leftIndex = -1;
//        for (int i = 0; i < arr.length ; i++) {
//            if (arr[i] < number){
//                leftIndex ++;
//                if (leftIndex >= 0){
//                    swap(arr,i,leftIndex);
//                }
//            }
//        }
//}

    private static void swap(int[] arr, int index, int targetIndex) {
        int temp = arr[index];
        arr[index] = arr[targetIndex];
        arr[targetIndex] = temp;
    }
}
