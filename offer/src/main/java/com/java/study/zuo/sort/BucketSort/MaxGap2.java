package com.java.study.zuo.sort.BucketSort;

import java.util.Arrays;

public class MaxGap2 {

    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            minValue = Math.min(minValue, arr[i]);
        }

        if (maxValue == minValue) {
            return 0;
        }

        int len = arr.length;
        //标记是否有数据
        boolean[] hasNum = new boolean[len + 1];
        //标记最大值信息
        int[] maxBucket = new int[len + 1];
        //标记最小值信息
        int[] minBucket = new int[len + 1];


        for (int i = 0; i < len; i++) {
            int bucketIndex = calculateBucketIndex(arr[i], len, maxValue, minValue);
            maxBucket[bucketIndex] = hasNum[bucketIndex] ? Math.max(maxBucket[bucketIndex], arr[i]) : arr[i];
            minBucket[bucketIndex] = hasNum[bucketIndex] ? Math.min(minBucket[bucketIndex], arr[i]) : arr[i];
            hasNum[bucketIndex] = true;
        }

        int preMaxValue = maxBucket[0];
        int maxGap = 0;
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                maxGap = Math.max(minBucket[i] - preMaxValue, maxGap);
                preMaxValue = maxBucket[i];

            }
        }

        return maxGap;
    }

    private static int calculateBucketIndex(int value, int len, int maxValue, int minValue) {
        return (value - minValue) * len / (maxValue - minValue);
    }


    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
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
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
