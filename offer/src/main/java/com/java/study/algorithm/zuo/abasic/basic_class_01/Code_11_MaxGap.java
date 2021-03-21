package com.java.study.algorithm.zuo.abasic.basic_class_01;

import java.util.Arrays;

public class Code_11_MaxGap {

    public static int MaxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int value : arr) {
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        }

        if (maxValue == minValue) {
            return 0;
        }


        /**
         * 怎么确定桶的数量 以及每个桶的范围
         * 桶的数量是元素个数+1，这个是明确的
         * 那么怎么确定一个桶的区间，让每个计算的数量多落入桶中？
         * -3 -66
         * 差值是63 ， 落入三个桶中， 均值是21
         * 0             1         2
         * -66，-45    -44，-23  -22  0
         *
         */
        int bucketNum = arr.length + 1;

        int gapValue = maxValue - minValue;

        int bucketValue = gapValue / (arr.length + 1) + 1;


        Statistic[] bucketResult = new Statistic[bucketNum];
        for (int value : arr) {
            int bucket = (value - minValue) / bucketValue;
            Statistic statistic = bucketResult[bucket];
            if (statistic == null) {
                statistic = new Statistic();
                bucketResult[bucket] = statistic;
            }

            statistic.maxValue = Math.max(statistic.maxValue, value);
            statistic.minValue = Math.min(statistic.minValue, value);
        }


        Statistic preStatistic = bucketResult[0];
        int maxResult = preStatistic.maxValue - preStatistic.minValue;
        for (int i = 1; i < bucketResult.length; i++) {
            if (bucketResult[i] == null) {
                continue;
            }
            Statistic indexStatistic = bucketResult[i];
            int indexMinValue = indexStatistic.minValue;
            int preMaxValue = preStatistic.maxValue;
            maxResult = Math.max(maxResult, indexMinValue - preMaxValue);
            preStatistic = indexStatistic;
        }

        return maxResult;
    }

    public static class Statistic {
        public int minValue = Integer.MAX_VALUE;
        public int maxValue = Integer.MIN_VALUE;


    }


    private static int calculateBucket(int value, int minValue, int maxValue, int length) {
        return (value - minValue) * length / (maxValue - minValue);
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
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (MaxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}