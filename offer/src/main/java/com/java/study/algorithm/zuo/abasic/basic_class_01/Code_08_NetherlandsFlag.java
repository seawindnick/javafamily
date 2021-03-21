package com.java.study.algorithm.zuo.abasic.basic_class_01;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

import java.util.ArrayList;

/**
 * 荷兰国旗
 */
public class Code_08_NetherlandsFlag {


    public static void NetherlandsFlag(int[] arr, int value) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int[] result = sort(arr, 0, arr.length - 1, value);

    }

    private static int[] sort(int[] arr, int startIndex, int endIndex, int value) {

        int L = startIndex - 1;
        int R = endIndex + 1;

        int curIndex = startIndex;
        while (curIndex < R) {
            if (arr[curIndex] == value) {
                curIndex++;
            } else if (arr[curIndex] < value) {
                ArrayUtil.swap(arr, curIndex++, ++L);
            } else if (arr[curIndex] > value) {
                ArrayUtil.swap(arr, curIndex, --R);
            }
        }

        return new int[]{L + 1, R - 1};
    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = sort(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}