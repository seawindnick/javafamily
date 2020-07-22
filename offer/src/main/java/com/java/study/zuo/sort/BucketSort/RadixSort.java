package com.java.study.zuo.sort.BucketSort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int maxTimes = calculateMaxTimes(arr);
        radixSort(arr, maxTimes);
    }

    private static void radixSort(int[] arr, int maxTimes) {
        int length = arr.length;

        //共计19行  1-9 行表示 -9 ～ -1，第10列表示0，11 - 19 行表示  1-9
        Integer[][] bucketArr = new Integer[19][length];

        int dev = 1;
        for (int i = 0; i < maxTimes; i++) {
            for (int j = 0; j < length; j++) {
                int value = arr[j];

                //确定对应的桶位置
                int indexValue = (value / dev) % 10;
                int index;
                if (indexValue < 0) {
                    index = 10 - Math.abs(indexValue) - 1;
                } else {
                    index = indexValue + 10 - 1;
                }

                //找到对应的桶
                Integer[] indexArr = bucketArr[index];
                int targetIndex = 0;

                //找到桶中元素应该处于的位置
                while (indexArr[targetIndex] != null) {
                    targetIndex++;
                }

                indexArr[targetIndex] = value;
            }

            //清理数据
            dev = dev * 10;

            clearBucket(arr, bucketArr);
        }


    }

    /**
     * 清理桶信息
     *
     * @param arr
     * @param bucketArr
     */
    private static void clearBucket(int[] arr, Integer[][] bucketArr) {
        int index = 0;
        for (int i = 0; i < bucketArr.length; i++) {
            for (int j = 0; j < arr.length && (bucketArr[i][j] != null); j++) {
                arr[index++] = bucketArr[i][j];
                bucketArr[i][j] = null;
            }
        }
    }

    private static int calculateMaxTimes(int[] arr) {
        int absMaxValue = getAbsMaxValue(arr);
        int maxDigit = calculateMaxDigit(absMaxValue);
        return maxDigit;
    }

    private static int calculateMaxDigit(int absMaxValue) {
        int count = 0;
        while (absMaxValue != 0) {
            count++;
            absMaxValue = absMaxValue / 10;
        }
        return count;
    }

    private static int getAbsMaxValue(int[] arr) {
        int maxValue = Integer.MIN_VALUE;

        for (int i : arr) {
            maxValue = Math.max(Math.abs(i), maxValue);
        }
        return maxValue;
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
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            radixSort(arr1);
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
        radixSort(arr);
        printArray(arr);

    }


}
