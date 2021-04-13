package com.java.study.algorithm.zuo.abasic.basic_class_08;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组代表一个容器，
 * 比如[3,1,2,4]，
 * 代表0位置是一个宽度为1，高度为3的直方图。
 * 代表1位置是一个宽度为1，高度为1的直方图。
 * 代表2位置是一个宽度为1，高度为2的直方图。
 * 代表3位置是一个宽度为1，高度为4的直方图。
 * 所有直方图的底部都在一条水平线上，且紧靠着。
 * 把这个图想象成一个容器，这个容器可以装3格的水。
 * 给定一个没有负数的数组arr，返回能装几格水?
 */
public class Code_01_WaterProblem {


    public static int WaterProblem(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] leftMax = new int[arr.length];
        leftMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        int[] rightMax = new int[arr.length];
        rightMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }


        int sum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - arr[i];

        }
        return sum;
    }


    public static int WaterProblem2(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 2) {
            return 0;
        }


        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];

        int leftIndex = 1;
        int rightIndex = arr.length - 2;

        int sum = 0;

        while (leftIndex <= rightIndex) {
            if (leftMax <= rightMax) {
                sum += Math.max(0, leftMax - arr[leftIndex]);
                leftMax = Math.max(leftMax, arr[leftIndex++]);
            } else {
                sum += Math.max(0, rightMax - arr[rightIndex]);
                rightMax = Math.max(rightMax, arr[rightIndex--]);
            }

        }
        return sum;

    }

//
//    public static int getWater4(int[] arr) {
//        if (arr == null || arr.length < 3) {
//            return 0;
//        }
//        int value = 0;
//        int leftMax = arr[0];
//        int rightMax = arr[arr.length - 1];
//        int l = 1;
//        int r = arr.length - 2;
//        while (l <= r) {
//            if (leftMax <= rightMax) {
//                value += Math.max(0, leftMax - arr[l]);
//                leftMax = Math.max(leftMax, arr[l++]);
//            } else {
//                value += Math.max(0, rightMax - arr[r]);
//                rightMax = Math.max(rightMax, arr[r--]);
//            }
//        }
//        return value;
//    }


    public static int[] generateRandomArray() {
        int[] arr = new int[(int) (Math.random() * 98) + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200) + 2;
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{3, 1, 2, 4};
//        System.out.println(WaterProblem2(arr));

        for (int i = 0; i < 100; i++) {
            int[] arr = generateRandomArray();
            int r1 = com.java.study.answer.zuo.abasic.basic_class_08.Code_01_WaterProblem.getWater1(arr);
            int r2 = com.java.study.answer.zuo.abasic.basic_class_08.Code_01_WaterProblem.getWater2(arr);
            int r3 = com.java.study.answer.zuo.abasic.basic_class_08.Code_01_WaterProblem.getWater3(arr);
            int r4 = WaterProblem(arr);
            int r5 = WaterProblem2(arr);
            if (r1 != r2 || r3 != r4 || r1 != r3 || r1 != r5) {
                System.out.println("What a fucking day! fuck that! man!");
            }
        }

        HashMap<String, String> map = new HashMap<String, String>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " , " + entry.getValue());
        }

    }


}