package com.java.study.algorithm.zuo.abasic.basic_class_01;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 查询不包含的数据
 * 二分查找
 */
public class Code_10_GetAllNotIncluded {


    public static List GetAllNotIncluded(int[] arr, int[] brr) {
        if (brr == null || brr.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>(brr.length);
        for (int indexValue : brr) {
            if (searchIndex(arr, indexValue) == -1) {
                list.add(indexValue);
            }
        }

        return list;

    }

    private static int searchIndex(int[] arr, int indexValue) {
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int midIndex = L + (R - L) / 2;
            if (arr[midIndex] == indexValue) {
                return midIndex;
            } else if (arr[midIndex] > indexValue) {
                R = midIndex - 1;
            } else if (arr[midIndex] < indexValue) {
                L = midIndex + 1;
            }
        }

        return -1;
    }


    // for test
    public static List<Integer> comparator(int[] A, int[] B) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            boolean contains = false;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == B[i]) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                res.add(B[i]);
            }
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static boolean isEqual(List<Integer> l1, List<Integer> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : l1) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
        }
        for (Integer i : l2) {
            if (!map.containsKey(i)) {
                return false;
            }
            map.put(i, map.get(i) - 1);
            if (map.get(i) < 0) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 300000;
        int sortedArrayMaxSize = 300;
        int unsortedArrayMaxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] A = generateRandomArray(sortedArrayMaxSize, maxValue);
            int[] B = generateRandomArray(unsortedArrayMaxSize, maxValue);
            Arrays.sort(A);
            List<Integer> res1 = GetAllNotIncluded(A, B);
            List<Integer> res2 = comparator(A, B);
            if (!isEqual(res1, res2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }

}