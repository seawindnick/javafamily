package com.java.study.algorithm.zuo.abasic.basic_class_01;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

public class Code_03_HeapSort {


    public static void HeapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int length = arr.length;
        for (int i = 0; i < length; i++) {
            heapInsert(arr, i);
        }


        int index = length - 1;
        while (index > 0) {
            ArrayUtil.swap(arr, 0, index--);
            heayfiy(arr, 0, index);
        }


    }

    /**
     * 树结构调整，包含最后的边界
     *
     *
     * @param arr
     * @param index
     * @param endIndex
     */
    private static void heayfiy(int[] arr, int index, int endIndex) {
        int left;
        while ((left = (2 * index) + 1) <= endIndex) {
            int targetIndex = left + 1 > endIndex ? left : arr[left] > arr[left + 1] ? left : left + 1;
            if (arr[index] >= arr[targetIndex]) {
                return;
            }

            /**
             * 交换位置适合最后的目标位置进行交换
             */
            ArrayUtil.swap(arr, index, targetIndex);
            /**
             * 交换成功之后，再对目标位置的元素进行考察
             */
            index = targetIndex;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        int temp;
        while (arr[index] > arr[temp = (index - 1) / 2]) {
            ArrayUtil.swap(arr, index, temp);
            index = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 9, 4, 2, 1, 2};
        HeapSort(arr);
        System.out.println(JSONArray.toJSONString(arr));

    }
}