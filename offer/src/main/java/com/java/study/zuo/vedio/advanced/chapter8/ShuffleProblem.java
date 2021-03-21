package com.java.study.zuo.vedio.advanced.chapter8;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-25 15:38
 */
public class ShuffleProblem {


    public static void shuffleProblem(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }

        shuffleProblem(arr, 0, (arr.length & 1) == 1 ? arr.length - 2 : arr.length - 1);
    }

    private static void shuffleProblem(int[] arr, int startIndex, int endIndex) {

        int beginIndex = startIndex;
        while (beginIndex < endIndex) {
            int length = endIndex - beginIndex + 1;
            int times = 0;
            int basic = 3;
            while (length >= basic - 1) {
                times++;
                basic = basic * basic;
            }

            //一次能处理的长度半径
            int handleLength = ((int) Math.pow(3, times) - 1);

            int handleMidIndex = beginIndex + handleLength / 2;

            //中点位置
            int midIndex = beginIndex + (endIndex - beginIndex) / 2;
            reverse(arr, handleMidIndex, midIndex, midIndex + handleLength / 2);

            circle(arr, beginIndex, handleMidIndex, endIndex, times);

            beginIndex = beginIndex + handleLength - 1;
        }

    }

    private static void circle(int[] arr, int beginIndex, int handleMidIndex, int endIndex, int times) {
        while (times > 0) {
            int start = beginIndex + (int) Math.pow(3, times - 1) - 1;
            int replaceIndex = start;

            int circly = start;
            int replaceValue = arr[start];
            while (replaceIndex != start) {
                if (circly < handleMidIndex) {
                    int index = replaceIndex * 2 + 1;
                    int temp = arr[index];
                    arr[index] = replaceValue;
                    replaceValue = temp;
                } else {
                    int index = 2 * (replaceIndex - handleMidIndex);
                    int temp = arr[index];
                    arr[index] = replaceValue;
                    replaceValue = temp;
                }
            }
            times--;
        }
    }


    private static void reverse(int[] arr, int beginIndex, int midIndex, int endIndex) {
        reverse(arr, beginIndex, midIndex);
        reverse(arr, midIndex + 1, endIndex);
        reverse(arr, beginIndex, endIndex);
    }

    private static void reverse(int[] arr, int beginIndex, int endIndex) {
        while (beginIndex < endIndex) {
            int temp = arr[beginIndex];
            arr[beginIndex] = arr[endIndex];
            arr[endIndex] = temp;
            beginIndex++;
            endIndex--;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        sort(arr);
        System.out.println(JSONArray.toJSONString(arr));
//        shuffleProblem(arr);
//        System.out.println(JSONArray.toJSONString(arr));
    }

    private static void sort(int[] arr) {

        int length = (arr.length & 1) == 1 ? arr.length - 1 : arr.length;

        int[] temp = new int[length];
        int midIndex = (length - 1) / 2;
        for (int i = 0; i < length; i++) {
            temp[(2 * i) % (length)] = arr[i];
        }
        for (int i = 0; i < length; i++) {
            arr[i] = temp[i];
        }

//        int length = (arr.length & 1) == 1 ? arr.length - 1 : arr.length;
//
//        int[] temp = new int[length];
//        int midIndex = (length - 1) / 2;
//        for (int i = 0; i < length; i++) {
//            if (i <= midIndex) {
//                temp[2 * i + 1] = arr[i];
//            } else {
//                temp[2 * i - length] = arr[i];
//            }
//        }
//        for (int i = 0; i < length; i++) {
//            arr[i] = temp[i];
//        }

//        int length = (arr.length & 1) == 1 ? arr.length - 1 : arr.length;
//
//        int[] temp = new int[length];
//        int midIndex = (length - 1) / 2;
//        for (int i = 0; i < length; i++) {
//            if (i <= midIndex) {
//                temp[2 * i + 1] = arr[i];
//            } else {
//                temp[2 * (i - midIndex - 1)] = arr[i];
//            }
//        }
//        for (int i = 0; i < length; i++) {
//            arr[i] = temp[i];
//        }

//        int[] temp = new int[length];
//        int midIndex = (length - 1) / 2;
//        for (int i = 0; i < length; i++) {
//            if (i <= midIndex) {
//                temp[2 * i] = arr[i];
//            } else {
//                temp[2 * (i - midIndex - 1) + 1] = arr[i];
//            }
//        }
//        for (int i = 0; i < length; i++) {
//            arr[i] = temp[i];
//        }
    }
}
