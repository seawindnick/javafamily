package com.java.study.algorithm.zuo.dadvanced.advanced_class_01;

import java.util.LinkedList;

/**
 * 给定数组arr和整数num，共返回有多少个子数组满足如下情况:
 * max(arr[i..j]) - min(arr[i..j]) <= num
 * max(arr[i..j])表示子数组arr[i..j]中的最大值，min(arr[i..j])表示子数组arr[i. 中的最小值。
 * 【要求】 如果数组长度为N，请实现时间复杂度为O(N)的解法。
 */
public class Code_05_AllLessNumSubArray {

    public static int AllLessNumSubArray(int[] arr, int m) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        //区间还可以进行移动
        LinkedList<Integer> maxList = new LinkedList<>();
        LinkedList<Integer> minList = new LinkedList<>();
        int res = 0;
        int i = 0;
        int j = 0;

        while (i < arr.length) {
            while (j < arr.length) {

                while (!minList.isEmpty() && arr[j] <= arr[minList.peekLast()]) {
                    minList.pollLast();
                }
                minList.addLast(j);

                while (!maxList.isEmpty() && arr[j] >= arr[maxList.peekLast()]) {
                    maxList.pollLast();
                }
                maxList.addLast(j);

                if (arr[maxList.peekFirst()] - arr[minList.peekFirst()] > m) {
                    break;
                }
                j++;
            }


            if (minList.peekFirst() == i) {
                minList.pollFirst();
            }
            if (maxList.peekFirst() == i) {
                maxList.pollFirst();
            }
            res += j - i;
            i++;
        }


//        public static int getNum(int[] arr, int num) {
//            if (arr == null || arr.length == 0) {
//                return 0;
//            }
//            LinkedList<Integer> qmin = new LinkedList<Integer>();
//            LinkedList<Integer> qmax = new LinkedList<Integer>();
//            int i = 0;
//            int j = 0;
//            int res = 0;
//            while (i < arr.length) {
//                while (j < arr.length) {
//                    while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
//                        qmin.pollLast();
//                    }
//                    qmin.addLast(j);
//                    while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
//                        qmax.pollLast();
//                    }
//                    qmax.addLast(j);
//                    if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
//                        break;
//                    }
//                    j++;
//                }
//                if (qmin.peekFirst() == i) {
//                    qmin.pollFirst();
//                }
//                if (qmax.peekFirst() == i) {
//                    qmax.pollFirst();
//                }
//                res += j - i;
//                i++;
//            }
//            return res;
//        }

//
//        while (left <= curIndex && curIndex < arr.length) {
//
//
//            if (maxList.peekFirst() - minList.peekFirst() <= m) {
//                sum = (curIndex - left);
//            } else {
//                if (maxList.peekFirst() == left) {
//                    maxList.pollFirst();
//                }
//
//                if (minList.peekFirst() == left) {
//                    minList.pollFirst();
//                }
//                left++;
//                continue;
//            }
//
//            if (curIndex < arr.length) {
//                curIndex++;
//            } else {
//                left++;
//            }
//        }

        return res;
    }


    // for test
    public static int[] getRandomArray(int len) {
        if (len < 0) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = getRandomArray(30);
        int num = 5;
        printArray(arr);
        System.out.println(AllLessNumSubArray(arr, num));

        System.out.println(com.java.study.answer.zuo.dadvanced.advanced_class_01.Code_05_AllLessNumSubArray.getNum(arr, num));
    }
}