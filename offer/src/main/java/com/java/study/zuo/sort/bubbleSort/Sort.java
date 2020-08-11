package com.java.study.zuo.sort.bubbleSort;

import com.java.study.zuo.sort.ArrayUtil;

import java.util.Arrays;

/**
 * <Description>
 * 冒泡排序
 *
 * @author hushiye
 * @since 2020-08-06 00:06
 */
public class Sort {

    //冒泡 排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int length = arr.length - 1;
        for (int i = length; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtil.swap(arr, j, j + 1);
                }

            }
        }
    }


    //选择排序
    public static void selectSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }
        int length = arr.length - 1;

        for (int i = 0; i <= length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= length; j++) {
                if (arr[minIndex] > arr[j]) {
                    ArrayUtil.swap(arr, minIndex, j);
                    ;
                }
            }

        }

    }


    //插入排序
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    ArrayUtil.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }


    //归并排序
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int length = arr.length - 1;
        mergeSort(arr, 0, length);
    }

    private static void mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int midIndex = startIndex + ((endIndex - startIndex) >> 1);
        mergeSort(arr, startIndex, midIndex);
        mergeSort(arr, midIndex + 1, endIndex);
        merge(arr, startIndex, midIndex, endIndex);
    }

    private static void merge(int[] arr, int startIndex, int midIndex, int endIndex) {

        int[] tempArr = new int[endIndex - startIndex + 1];
        int curIndex = 0;
        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;

        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            tempArr[curIndex++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }


        while (leftIndex <= midIndex) {
            tempArr[curIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= endIndex) {
            tempArr[curIndex++] = arr[rightIndex++];
        }

        for (int i = 0; i < tempArr.length; i++) {
            arr[startIndex + i] = tempArr[i];
        }

    }


//    public static void main(String[] args) {
//        int[] arr = {5, 3, 4, 2};
//        mergeInsert(arr);
//        System.out.println(JSONArray.toJSONString(arr));
//    }


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
//        int[] arr = {5, 4, 6, 7, 2};
//        mergeSort(arr, 0, arr.length-1);
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }

}
