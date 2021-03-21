package com.java.study.algorithm.zuo.abasic.basic_class_01;

import com.java.study.zuo.sort.ArrayUtil;

/**
 * 冒泡排序
 */
public class Code_00_BubbleSort {

    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    ArrayUtil.swap(arr,j,j+1);
                }

            }
        }
    }



}