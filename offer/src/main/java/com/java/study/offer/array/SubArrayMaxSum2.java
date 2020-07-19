package com.java.study.offer.array;

public class SubArrayMaxSum2 {

    public static void main(String[] args) {
        int[] array = new int[]{5,4,-12,6,7,-5,5,4};

        int sum = calculateMaxSum(array);
        System.out.println(sum);
    }

    private static int calculateMaxSum(int[] array) {


        int curIndexSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (curIndexSum < 0){
                curIndexSum = array[i];
            }else {
                curIndexSum = curIndexSum + array[i];
            }
            maxSum = Math.max(maxSum,curIndexSum);
        }

        return maxSum;
    }
}
