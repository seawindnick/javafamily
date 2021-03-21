package com.java.study.algorithm.zuo.abasic.basic_class_01;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

/**
 * 插入排序
 */
public class Code_01_InsertionSort {


    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1 && arr[j] < arr[j - 1]; j--) {
                ArrayUtil.swap(arr, j, j - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertionSort(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }


}