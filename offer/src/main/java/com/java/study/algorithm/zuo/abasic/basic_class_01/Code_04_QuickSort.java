package com.java.study.algorithm.zuo.abasic.basic_class_01;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

import java.util.Random;

/**
 * 快速排序
 */
public class Code_04_QuickSort {


    public static void QuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        refresh(arr, 0, arr.length - 1);

    }


    public static void refresh(int[] arr, int left, int end) {
        if (left >= end) {
            return;
        }


        int targetIndex = left + (new Random().nextInt(end - left));
        ArrayUtil.swap(arr, targetIndex, end);
        int targetValue = arr[end];
        // 结果是 targetValue 值所在的左右角标

        int[] result = search(arr, left, end, targetValue);
        refresh(arr, left, result[0] - 1);
        refresh(arr, result[1] + 1, end);


    }

    private static int[] search(int[] arr, int left, int end, int targetValue) {
        int L = left - 1;
        int R = end + 1;

        int curIndex = left;
        //遍历left到end的所有元素，与targetValue 进行比较 找到对应的位置进行放置
        while (curIndex < R) {
            if (arr[curIndex] == targetValue) {
                curIndex++;
            } else if (arr[curIndex] < targetValue) {
                ArrayUtil.swap(arr, curIndex++, ++L);
            } else if (arr[curIndex] > targetValue) {
                ArrayUtil.swap(arr, curIndex, --R);
            }
        }

        return new int[]{L + 1, R - 1};
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 6, 5, 6, 8, 9, 3, 2, 1};
        QuickSort(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }
}