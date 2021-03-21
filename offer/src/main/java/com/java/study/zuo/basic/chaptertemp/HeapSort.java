package com.java.study.zuo.basic.chaptertemp;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

/**
 * <Description>
 * 堆排序
 *
 * @author hushiye
 * @since 3/18/21 18:30
 */
public class HeapSort {


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int length = arr.length;
        for (int i = 0; i < length; i++) {
            heapInsert(arr, i);
        }


        for (int i = length - 1; i >= 1; i--) {
            ArrayUtil.swap(arr, 0, i);
            hapfiy(arr, 0, i - 1);

        }

    }


    private static void hapfiy(int[] arr, int parent, int endIndex) {

        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        while (left <= endIndex) {

            int targetIndex = right > endIndex ? left : arr[left] > arr[right] ? left : right;
            //头节点 < 左右两个元素，进行置换
            if (arr[parent] >= arr[targetIndex]) {
                return;
            }
            ArrayUtil.swap(arr, parent, targetIndex);
            parent = targetIndex;
            left = parent * 2 + 1;
            right = parent * 2 + 2;
        }
    }

    /**
     * 堆添加元素
     *
     * @param arr
     * @param i   添加元素的角标
     */
    private static void heapInsert(int[] arr, int i) {
        int parentIndex = (i - 1) / 2;
        while (arr[i] > arr[(i - 1) / 2]) {
            ArrayUtil.swap(arr, i, parentIndex);
            i = (i - 1) / 2;
            parentIndex = (parentIndex - 1) / 2;
        }

//        while (arr[index] > arr[(index - 1) / 2]) {
//            ArrayUtil.swap(arr, index, (index - 1) / 2);
//            index = (index - 1) / 2;
//        }

    }


    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        heapSort(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }
}
