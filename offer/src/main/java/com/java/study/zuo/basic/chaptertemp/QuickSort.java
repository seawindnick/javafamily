package com.java.study.zuo.basic.chaptertemp;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

/**
 * <Description>
 * 快速排序 小的放在一边，大的放在另外一边
 *
 * @author hushiye
 * @since 3/17/21 11:17
 */
public class QuickSort {


    public static void quickSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;

        basicQuickSort(arr, startIndex, endIndex);

    }


    public static void basicQuickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex){
            return;
        }

        int L = startIndex;
        int R = endIndex;

        int targetValue = arr[endIndex];
        while (L < R) {
            while (arr[L] < targetValue && L < R) {
                L++;
            }
            ArrayUtil.swap(arr, L, R);
            System.out.println(JSONArray.toJSONString(arr));
            while (arr[R] > targetValue && L < R) {
                R--;
            }
            ArrayUtil.swap(arr, L, R);
            System.out.println(JSONArray.toJSONString(arr));
        }

        arr[L] = targetValue;
        basicQuickSort(arr, startIndex, L - 1);
        basicQuickSort(arr, L + 1, endIndex);
    }


    /**
     * 递归进行快排
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    private static void quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return;
        }

        int targetValue = arr[endIndex];

        int left = startIndex - 1;
        int right = endIndex + 1;
        int index = startIndex;

        while (index < right) {
            if (arr[index] < targetValue) {
                ArrayUtil.swap(arr, ++left, index++);
            } else if (arr[index] > targetValue) {
                ArrayUtil.swap(arr, --right, index);
            } else {
                index++;
            }
        }

        quickSort(arr, startIndex, left);
        quickSort(arr, right, endIndex);
    }


    public static void quickSort2(int[] arr) {
        int L = 0;
        int R = arr.length - 1;
        quickSort2(arr, L, R);

    }

    private static void quickSort2(int[] arr, int L, int R) {
        System.out.println("startIndex:" + L + "----------endIndex:" + R);
        if (L >= R) {
            return;
        }

//        ArrayUtil.swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] sortResult = sort(arr, L, R, arr[R]);

        quickSort2(arr, L, sortResult[0] - 1);
        quickSort2(arr, sortResult[1] + 1, R);
    }

    private static int[] sort(int[] arr, int L, int R, int targetValue) {
        int left = L - 1;
        int right = R + 1;

        int curIndex = L;
        while (curIndex < right) {
            if (arr[curIndex] < targetValue) {
                ArrayUtil.swap(arr, ++left, curIndex++);
            } else if (arr[curIndex] > targetValue) {
                ArrayUtil.swap(arr, --right, curIndex);
            } else {
                curIndex++;
            }

        }
        return new int[]{left + 1, right - 1};
    }


    public static void main(String[] args) {
        int[] arr = new int[]{9, 7, 5, 10, 3, 2, 4};
        quickSort(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }


}
