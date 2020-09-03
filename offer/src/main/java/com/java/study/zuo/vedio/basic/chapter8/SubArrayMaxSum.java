package com.java.study.zuo.vedio.basic.chapter8;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-28 20:49
 */
public class SubArrayMaxSum {

    public static int getMaxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int sum = 0 ;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }



    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { -2, -3, -5, 40, -10, -10, 100, 1 };
        System.out.println(getMaxSum(arr1));

        int[] arr2 = { -2, -3, -5, 0, 1, 2, -1 };
        System.out.println(getMaxSum(arr2));

        int[] arr3 = { -2, -3, -5, -1 };
        System.out.println(getMaxSum(arr3));

    }

}
