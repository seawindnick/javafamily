package com.java.study.zuo.sort.QuickSort;

import com.java.study.zuo.sort.ArrayUtil;

import java.util.Arrays;

public class QuickSort {


    private static void quickSort(int[] arr1) {
        quickSort(arr1, 0, arr1.length - 1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        ArrayUtil.swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] centerIndex = queryCenterIndex(arr, L, R, arr[R]);
        quickSort(arr, L, centerIndex[0] - 1);
        quickSort(arr, centerIndex[1] + 1, R);
    }

    private static int[] queryCenterIndex(int[] arr, int L, int R, int number) {
        int less = L - 1;
        int more = R + 1;

        int currentIndex = L;
        while (currentIndex < more) {
            if (arr[currentIndex] < number) {
                ArrayUtil.swap(arr, ++less, currentIndex++);
            } else if (arr[currentIndex] > number) {
                ArrayUtil.swap(arr, --more, currentIndex);
            } else {
                currentIndex++;
            }

        }

        return new int[]{less + 1, more - 1};
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
//        int[] arr = {5,4,7,3};
//        quickSort(arr);

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        quickSort(arr);
        printArray(arr);

    }

}
