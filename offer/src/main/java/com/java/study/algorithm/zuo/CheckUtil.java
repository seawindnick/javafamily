package com.java.study.algorithm.zuo;

import com.java.study.algorithm.zuo.abasic.basic_class_01.*;

import java.util.Arrays;

/**
 * <Description>
 *
 * @author hushiye
 * @since 3/16/21 23:50
 */
public class CheckUtil {



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
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            Code_00_BubbleSort.bubbleSort(arr1);
//            HeapSort2.heapSort2(arr1);
//            Code_01_InsertionSort.insertionSort(arr1);
//            Code_02_SelectionSort.SelectionSort(arr1);
//            Code_03_HeapSort.HeapSort(arr1);
//            Code_04_QuickSort.QuickSort(arr1);
//            Code_04_QuickSort_Old.Code_04_QuickSort_Old(arr1);
            Code_05_MergeSort.MergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
//        Code_00_BubbleSort.bubbleSort(arr);
//        Code_01_InsertionSort.insertionSort(arr);
//        Code_02_SelectionSort.SelectionSort(arr);
//        Code_03_HeapSort.HeapSort(arr);
//        Code_04_QuickSort.QuickSort(arr);
//        Code_04_QuickSort_Old.Code_04_QuickSort_Old(arr);
        Code_05_MergeSort.MergeSort(arr);

        printArray(arr);
    }
}
