package com.java.study.zuo.sort.BucketSort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 计算无序数组中最大Gap信息
 */
public class MaxGap {


    public static int maxGap(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            minValue = Math.min(minValue, arr[i]);
        }

        if (maxValue == minValue) {
            return 0;
        }

        int len = arr.length;

        //N+1个桶
        int bucketNum = len + 1;


        //最小数据
        int[] bucketMin = new int[bucketNum];
        //最大数据
        int[] bucketMax = new int[bucketNum];

        //存在数据
        boolean[] bucketExist = new boolean[bucketNum];

        for (int i = 0; i < len; i++) {
            int value = arr[i];
            int bucketIndex = calculateBucketIndex(arr[i], len, minValue, maxValue);
            bucketMin[bucketIndex] = bucketExist[bucketIndex] ? Math.min(bucketMin[bucketIndex], value) : value;
            bucketMax[bucketIndex] = bucketExist[bucketIndex] ? Math.max(bucketMax[bucketIndex], value) : value;
            bucketExist[bucketIndex] = true;

        }


        int maxGapSum = Integer.MIN_VALUE;
        int preBucketIndex = 0;
        for (int i = 1; i < bucketNum; i++) {
            if (bucketExist[i]) {
                int gapValue = bucketMin[i] - bucketMax[preBucketIndex];
                maxGapSum = Math.max(maxGapSum, gapValue);
                preBucketIndex = i;
            }
        }
        return maxGapSum;
    }

    private static int calculateBucketIndex(int value, int len, int minValue, int maxValue) {
        return (value - minValue) * len / ((maxValue - minValue));
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
