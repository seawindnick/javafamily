package com.java.study.zuo.vedio.basic.chapter1;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

import java.util.Arrays;

/**
 * <Description>
 * 堆排序
 *
 * @author hushiye
 * @since 2020-08-16 23:08
 */
public class HeapSort {


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }


        int size = arr.length;
        ArrayUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapfiy2(arr, 0, size);
            ArrayUtil.swap(arr, --size, 0);
        }


    }

    private static void heapfiy2(int[] arr, int startIndex, int size) {
        int left = startIndex * 2 + 1;
        while (left < size) {
            int right = left + 1;
            //判断左右子节点哪个大
            int lagst = right < size && arr[right] > arr[left] ? right : left;
            //判断父节点与子节点哪个大
            lagst = arr[lagst] > arr[startIndex] ? lagst : startIndex;
            if (startIndex == lagst) {
                break;
            }

            ArrayUtil.swap(arr, lagst, startIndex);
            startIndex = lagst;
            left = startIndex * 2 + 1;
        }

    }

    //大堆头在首位
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            ArrayUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


//
//    public static void heapSort(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return;
//        }
//
//        int[] heap = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr[i], heap, i);
//        }
//        int curentEndIndex = arr.length - 1;
//        for (int i = 0; i < heap.length; i++) {
//            arr[i] = heap[0];
//            heapfiy(heap, 0, curentEndIndex--);
//        }
//    }

    /**
     * 调整堆
     *
     * @param heap
     * @param startIndex
     * @param curentEndIndex
     */
    private static void heapfiy(int[] heap, int startIndex, int curentEndIndex) {
        ArrayUtil.swap(heap, startIndex, curentEndIndex);

        int leftIndex = startIndex * 2 + 1;
        int rightIndex = startIndex * 2 + 2;

        while (leftIndex < curentEndIndex && (heap[leftIndex] < heap[startIndex] || heap[rightIndex] < heap[startIndex])) {
            int replaceIndex = rightIndex >= curentEndIndex ? leftIndex : heap[leftIndex] < heap[rightIndex] ? leftIndex : rightIndex;
            if (heap[replaceIndex] < heap[startIndex]) {
                ArrayUtil.swap(heap, replaceIndex, startIndex);
                startIndex = replaceIndex;
                leftIndex = startIndex * 2 + 1;
                rightIndex = startIndex * 2 + 2;
            } else {
                break;
            }
        }
    }

    //创建堆
    private static void heapInsert(int value, int[] heap, int index) {
        heap[index] = value;
        int parentIndex = (index - 1) >> 1;
        while (parentIndex != -1 && heap[index] < heap[parentIndex]) {
            ArrayUtil.swap(heap, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) >> 1;
        }
    }


    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }


    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
////
//        int[] arr = {1, 6, 7, 8, 2};
//        heapSort(arr);
//        System.out.println(JSONArray.toJSONString(arr));
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println(JSONArray.toJSONString(arr3));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = {7, -47, 16, -7, -73, 26, -6, 5, -80, 5, 40, 0, 65, 3, 22, -1, 32, 55, -18, -11, 43, -46, -2, 89, 47, 72, 62, -29, 62, 34, 22, 48, 43, -11, 57, 75, -6, 23, -19, 15, -90, -44};
        int[] arr2 = copyArray(arr);
        printArray(arr);
        heapSort(arr);
        comparator(arr2);
        printArray(arr);
        printArray(arr2);
    }


}
