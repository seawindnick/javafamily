package com.java.study.algorithm.zuo.dadvanced.advanced_class_01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组arr，和一个整数aim，请返回哪两个位置的数可 以加出aim来。
 * 例如
 * arr = {2, 7, 11, 15}，target = 9
 * 返回{0,1}，因为arr[0] + arr[1] = 2 + 7 = 9 可以假设每个数组里只有一组答案
 */
public class Code_02_Tow_Sum {

    public static int[] Tow_Sum(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Map<Integer/*value*/, Integer/*index*/> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(sum - arr[i])) {
                return new int[]{map.get(sum - arr[i]), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return null;
    }


    public static int[] Tow_Sum2(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == sum) {
                return new int[]{left, right};
            } else if (arr[left] + arr[right] > sum) {
                right--;
            } else {
                left++;
            }

        }
        return null;
    }
}