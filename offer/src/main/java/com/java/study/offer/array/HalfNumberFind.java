package com.java.study.offer.array;

import com.alibaba.fastjson.JSONArray;

public class HalfNumberFind {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 1, 1, 1, 1, 1, 3, 4, 5, 6, 8, 6, 6,1};
//        Integer index = findIndex(arr, 0, arr.length - 1);
        Integer index = findIndex(arr);
        System.out.println(index);
        System.out.println(JSONArray.toJSONString(arr));
    }

    private static Integer findIndex(int[] arr) {
        int count = 0;
        int value = 0;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                value = arr[i];
                count = 1;
            } else {
                if (arr[i] == value) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        if (count > 0 && checkOverHalf(value, arr)) {
            return value;
        }

        return null;

    }


    //    private static Integer findIndex(int[] arr, int beginIndex, int endIndex) {
//        if (arr == null || beginIndex > endIndex) {
//            return null;
//        }
//
//        int left = beginIndex;
//        int right = endIndex;
//        int checkValue = arr[left];
//        while (left < right) {
//            while (left < right && arr[right] >= checkValue) {
//                right--;
//            }
//            arr[left] = arr[right];
//            while (left < right && arr[left] <= checkValue) {
//                left++;
//            }
//
//            arr[right] = arr[left];
//        }
//
//        arr[left] = checkValue;
//        int midIndex = arr.length >> 1;
//        if (midIndex == left) {
//            if (checkOverHalf(arr[left], arr)) {
//                return arr[left];
//            } else {
//                return null;
//            }
//        }
//
//        if (left > midIndex) {
//            return findIndex(arr, beginIndex, left - 1);
//        }
//
//        return findIndex(arr, left + 1, endIndex);
//    }
//
//    // 判断查询的数据是否满足要求
    private static boolean checkOverHalf(int value, int[] arr) {
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] ^ value) == 0) {
                times++;
            }
        }

        return times >= (arr.length >> 1);
    }
}
