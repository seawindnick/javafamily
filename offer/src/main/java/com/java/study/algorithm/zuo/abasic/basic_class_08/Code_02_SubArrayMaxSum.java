package com.java.study.algorithm.zuo.abasic.basic_class_08;

/**
 * 给定一个数组arr，返回所有子数组的累加和中，最大的累加和
 */
public class Code_02_SubArrayMaxSum {


    public static int SubArrayMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            maxSum = Math.max(sum, maxSum);

            /**
             * 相加之后和小于0，总和值回到起点，重新进行计算
             */
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr1 = {-2, -3, -5, 40, -10, -10, 100, 1};
        System.out.println(SubArrayMaxSum(arr1));
        System.out.println(com.java.study.answer.zuo.abasic.basic_class_08.Code_02_SubArrayMaxSum.maxSum(arr1));
        System.out.println("=====================");
        int[] arr2 = {-2, -3, -5, 0, 1, 2, -1};
        System.out.println(SubArrayMaxSum(arr2));
        System.out.println(com.java.study.answer.zuo.abasic.basic_class_08.Code_02_SubArrayMaxSum.maxSum(arr2));
        System.out.println("=====================");

        int[] arr3 = {-2, -3, -5, -1};
        System.out.println(SubArrayMaxSum(arr3));
        System.out.println(com.java.study.answer.zuo.abasic.basic_class_08.Code_02_SubArrayMaxSum.maxSum(arr3));
        System.out.println("=====================");

    }
}