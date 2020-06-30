package com.java.study.offer.string;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class EightQueen {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};
        List<Integer[]> targetList = new ArrayList<>();
        calculate(arr, 0, targetList);
        targetList.forEach(array -> {
            System.out.println(JSONArray.toJSONString(array));
        });
        System.out.println(targetList.size());
    }

    private static void calculate(Integer[] arr, int startIndex, List<Integer[]> targetList) {
        if (startIndex == arr.length - 1) {
            if (!check(arr)) {
                return;
            }
            Integer[] targetArray = arr.clone();
            targetList.add(targetArray);
        } else {
            for (int index = startIndex; index < arr.length; index++) {
                swap(arr, startIndex, index);
                calculate(arr, startIndex + 1, targetList);
                swap(arr, startIndex, index);
            }
        }
    }


    private static boolean check(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(i - j) == Math.abs(arr[i] - arr[j])) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    private static void swap(Integer[] arr, int startIndex, int index) {
        Integer temp = arr[startIndex];
        arr[startIndex] = arr[index];
        arr[index] = temp;
    }
}
