package com.java.study.algorithm.zuo.abasic.basic_class_01;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

/**
 * <Description>
 * 传统快排
 *
 * @author hushiye
 * @since 3/20/21 22:43
 */
public class Code_04_QuickSort_Old {


    public static void Code_04_QuickSort_Old(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        refresh(arr, 0, arr.length - 1);
    }

    private static void refresh(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int L = startIndex;
        int R = endIndex;

        int targetValue = arr[endIndex];
        /**
         * 先从小的方向找起，找到小的，将目的值转换到小的那一方，最后的位置元素是大于目的值的
         * 如果先从大的放小找起，那么最后找的是小于目的值的数据，进行交换之后，最后一位是小于目的值的
         *
         */
        while (L < R) {

            while (arr[L] <= targetValue && L < R) {
                L++;
            }
            ArrayUtil.swap(arr, L, R);

            while (arr[R] >= targetValue && L < R) {
                R--;
            }

            ArrayUtil.swap(arr, L, R);
        }

        refresh(arr, startIndex, L - 1);
        refresh(arr, L + 1, endIndex);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 7, 9, 0, 2, 1};
        Code_04_QuickSort_Old(arr);
        System.out.println(JSONArray.toJSONString(arr));

    }
}
