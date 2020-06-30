package com.java.study.offer.array;

public class SubArrayMaxSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, -34, 3, 4, -56, 5, 6, 7, 8, 9, 10, -12};
        int sum = maxSum(arr);
        System.out.println(sum);
    }

    private static int maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxSum = 0x80000000;
        int indexSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (indexSum <= 0) {
                indexSum = arr[i];
            } else {
                System.out.println(arr[i]);
                indexSum = indexSum + arr[i];
            }

            maxSum = Math.max(indexSum, maxSum);
        }
        return maxSum;
    }
}
