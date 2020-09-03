package com.java.study.zuo.vedio.basic.chapter1;

import java.util.Arrays;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-17 22:15
 */
public class MaxGap {


    public static int getMaxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minValue = Math.min(minValue, arr[i]);
            maxValue = Math.max(maxValue, arr[i]);
        }

        if (minValue == maxValue){
            return 0;
        }

        //桶的数量比元素的数量多一
        int bucketCount = arr.length + 1;
        boolean[] existArray = new boolean[bucketCount];
        int[] minArray = new int[bucketCount];
        int[] maxArray = new int[bucketCount];

        for (int i = 0; i < arr.length; i++) {
            //计算桶位置
            /**
             * (maxValue-minValue)/arr.length  每个桶的平均值
             * (arr[i]-minValue)/((maxValue-minValue)/arr.length ) 元素所在的位置
             * 整理得 (arr[i]-minValue) * arr.length / (maxValue-minValue)
             *
             */
            int index = (arr[i] - minValue) * arr.length / (maxValue - minValue);
            minArray[index] = existArray[index] ? Math.min(minArray[index], arr[i]) : arr[i];
            maxArray[index] = existArray[index] ? Math.max(maxArray[index], arr[i]) : arr[i];
            existArray[index] = true;
        }

        /**
         * 间隔最大的空隙为下一个桶的最小值，减去上一个桶的最大值，由于有空桶，必存在此类数据
         * 让最大Gap不在桶内产生，在相邻桶之间产生
         */
        int preMinResult = maxArray[0];
        int maxGapResult = Integer.MIN_VALUE;
        for (int i = 1; i < existArray.length; i++) {
            if (existArray[i]) {
                int temp = minArray[i] - preMinResult;
                maxGapResult = Math.max(maxGapResult, temp);
                preMinResult = maxArray[i];
            }
        }
        return maxGapResult;

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
            if (getMaxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
