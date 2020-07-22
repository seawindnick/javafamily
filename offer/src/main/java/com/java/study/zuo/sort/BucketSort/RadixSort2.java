package com.java.study.zuo.sort.BucketSort;

import java.util.Arrays;

public class RadixSort2 {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int mabBits = maxBits(arr);
        radixSort(arr, 0, arr.length - 1, mabBits);
    }

    private static void radixSort(int[] arr, int begin, int end, int mabBits) {
        int radix = 10;
        int i = 0;
        int j = 0;
        int count[] = new int[radix];
        int bucket[] = new int[end - begin + 1];
        for (int d = 0; d <= mabBits; d++) {
            //初始化每个桶对应的数量
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }

            //统计各个桶将要装入的数据个数
            for (i = begin; i <= end; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }

            //统计第i个桶的右边界索引
            for ( i = 1; i < radix; i++) {
                count[i] = count[i] + count[i-1];
            }

            //将数据依次装入桶中，从右向左扫描，保证排序稳定性
            for(i = end ; i >= begin;i--){
                //计算 第 K 位数字
                j = getDigit(arr[i],d);
                //元素放入对应的桶中 ,count[j]-1,表示第i个桶
                bucket[count[j]-1] = arr[i];
                count[j]--;
            }

            for (i = begin,j = 0;i <= end;i++,j++){
                arr[i] = bucket[j];
            }
        }


    }

    private static int getDigit(int value, int d) {
        return (int) ((value / Math.pow(10, d)) % 10);
    }

    private static int maxBits(int[] arr) {
        int maxValue = getMaxValue(arr);
        int maxBits = maxBits(maxValue);
        return maxBits;
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        return maxValue;
    }

    private static int maxBits(int maxValue) {
        int maxBits = 0;
        while (maxValue != 0) {
            maxBits++;
            maxValue = maxValue / 10;
        }
        return maxBits;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
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

        int[] arr = new int[]{6,34};
        radixSort(arr);
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100000;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            radixSort(arr1);
//            comparator(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                printArray(arr1);
//                printArray(arr2);
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generateRandomArray(maxSize, maxValue);
//        printArray(arr);
//        radixSort(arr);
//        printArray(arr);

    }


}
