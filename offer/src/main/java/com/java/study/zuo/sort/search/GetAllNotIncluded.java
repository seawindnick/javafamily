package com.java.study.zuo.sort.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GetAllNotIncluded {

    /**
     * 计算 B数组中在A数组中不存在的元素
     * @param A
     * @param B
     * @return
     */
    public static List<Integer> getAllNotIncluded(int[] A, int[] B) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            int AStartIndex = 0;
            int AEndIndex = A.length - 1;
            boolean containsFlag = false;
            while (AStartIndex <= AEndIndex) {
                int midIndex = AStartIndex + ((AEndIndex - AStartIndex) >> 1);
                if (A[midIndex] == B[i]) {
                    containsFlag = true;
                    break;
                }

                if (A[midIndex] > B[i]) {
                    AEndIndex = midIndex - 1;
                }

                if (A[midIndex] < B[i]) {
                    AStartIndex = midIndex + 1;
                }
            }

            if (!containsFlag) {
                list.add(B[i]);
            }
        }

        return list;
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
            List<Integer> res1 = getAllNotIncluded(A, B);
            List<Integer> res2 = comparator(A, B);
            if (!isEqual(res1, res2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

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
}
