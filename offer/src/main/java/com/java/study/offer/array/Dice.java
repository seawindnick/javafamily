package com.java.study.offer.array;

import com.alibaba.fastjson.JSONArray;

public class Dice {

    public static void main(String[] args) {

        int n = 4;

        boolean flag = (n & n - 1) == 0;

        System.out.println(flag);

//        int num = 6;
//        int targetValue = 35;
//
//        //用于统计每个骰子的点数
//        int[] arr = new int[num];
//        int count = castDice(arr, 0, num, targetValue);
//        int total = (int) Math.pow(6, num);
//        System.out.println(count + "/" + total);
    }

    private static int castDice(int[] arr, int index, int num, int targetValue) {
        if (index == num) {
            if (valueCompare(arr, targetValue)) {
                return 1;
            }
            return 0;
        }
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            arr[index] = i;
            sum += castDice(arr, index + 1, num, targetValue);
        }
        return sum;
    }

    private static boolean valueCompare(int[] arr, int targetValue) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum == targetValue;
    }
}
