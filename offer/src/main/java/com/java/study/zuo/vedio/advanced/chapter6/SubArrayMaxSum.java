package com.java.study.zuo.vedio.advanced.chapter6;

/**
 * <Description>
 * <p>
 * 子数组的最大累加和问题
 * 【题目】
 * 给定一个数组arr，返回子数组的最大累加和。 例如，arr=[1,-2,3,5,-2,6,-1]，所有的子数组中，[3,5,-2,6] 可以累加出最大的和12，所以返回12。
 * 【要求】 如果arr长度为N，要求时间复杂度为O(N)，额外空间复杂度为 O(1)。
 * 【补充题目】 给定一个数组arr，返回两个不相容子数组的最大累加和。
 *
 * @author hushiye
 * @since 2020-09-17 17:08
 */
public class SubArrayMaxSum {

    public static int subArrayMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int indexValue = arr[i];
            sum += indexValue;
            max = Math.max(sum, max);

            sum = sum > 0 ? sum : 0;
        }
        return max;
    }


    public static int subArrayMaxSum2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] leftSubMaxValue = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int indexValue = arr[i];
            sum += indexValue;
            max = Math.max(sum, max);
            leftSubMaxValue[i] = max;
            sum = sum > 0 ? sum : 0;
        }

        int[] rightSubMaxValue = new int[arr.length];
        max = Integer.MIN_VALUE;
        sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int indexValue = arr[i];
            sum += indexValue;
            max = Math.max(sum, max);
            rightSubMaxValue[i] = max;
            sum = sum > 0 ? sum : 0;
        }

        max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            int value = leftSubMaxValue[i] + rightSubMaxValue[i + 1];
            max = Math.max(value,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, -3, -5, 40, 20, 10, 100, 1};
//        System.out.println(subArrayMaxSum(arr1));
        System.out.println(subArrayMaxSum2(arr1));

//        int[] arr2 = {-2, -3, -5, 0, 1, 2, -1};
//        System.out.println(subArrayMaxSum(arr2));
//
//        int[] arr3 = {-2, -3, -5, -1};
//        System.out.println(subArrayMaxSum(arr3));
    }
}
