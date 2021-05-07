package com.java.study.algorithm.zuo.dadvanced.advanced_class_03;

/**
 * 跳跃游戏
 * 【题目】 给定数组arr，arr[i]==k代表可以从位置i向右跳1~k个距离。
 * 比如，arr[2]==3，代表从位置2可以跳到位置3、位置4或位置5。
 * 如果从位置0出发，返回最少跳几次能跳到arr最后的位置上。
 * 【举例】
 * arr=[3,2,3,1,1,4]。 arr[0]==3，选择跳到位置2;arr[2]==3，可以跳到最后的位置。 所以返回2。
 * 【要求】 如果arr长度为N，要求实现时间复杂度为O(N)、额外空间复杂 度为O(1)的方法。
 */
public class Code_04_JumpGame {


    public static int JumpGame2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int count = 0;
        int next = 0;
        int cur = 0;


        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                count++;
                cur = next;
            }

            next = Math.max(next, i + arr[i]);
        }

        return count;

    }

//
//    public static int JumpGame(int[] arr) {
//        if (arr == null || arr.length == 0) {
//            return -1;
//        }
//
//        int count = 0;
//        int next = 0;
//
//
//        for (int i = 0; i < arr.length; i++) {
//            int indexValue = i + arr[i];
//            if (indexValue >= arr.length - 1) {
//                count++;
//                break;
//            }
//
//            if (indexValue > next) {
//                count++;
//                next = indexValue;
//            }
//        }
//
//        return count;
//
//    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 1, 4};
        System.out.println(JumpGame2(arr));

    }
}