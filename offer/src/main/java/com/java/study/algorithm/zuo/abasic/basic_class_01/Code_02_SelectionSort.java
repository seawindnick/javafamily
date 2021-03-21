package com.java.study.algorithm.zuo.abasic.basic_class_01;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

/**
 * 选择排序
 */
public class Code_02_SelectionSort {

    public static void SelectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            ArrayUtil.swap(arr, i, minIndex);
        }


    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
        SelectionSort(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }

}