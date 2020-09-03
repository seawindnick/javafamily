package com.java.study.zuo.vedio.advanced.chapter1;

import com.alibaba.fastjson.JSONArray;

import java.util.LinkedList;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-02 23:21
 */
public class AllLessNumSubArray {

    public static int allLessNumSubArray(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        int sum = 0;


        while (leftIndex < arr.length) {

            while (rightIndex < arr.length) {

                while (!min.isEmpty() && arr[min.peekLast()] >= arr[rightIndex]) {
                    min.pollLast();
                }
                min.addLast(rightIndex);

                while (!max.isEmpty() && arr[max.peekLast()] <= arr[rightIndex]) {
                    max.pollLast();
                }
                max.addLast(rightIndex);


                if (arr[max.peekFirst()] - arr[min.peekFirst()] > target) {
                    break;
                }
                rightIndex++;
            }

            if (leftIndex == max.peekFirst()) {
                max.pollFirst();
            }

            if (leftIndex == min.peekFirst()) {
                min.pollFirst();
            }


            sum = sum + (rightIndex - leftIndex);

            leftIndex++;
        }
        return sum;
    }


//            //添加元素
//            while (rightIndex < arr.length && (max.isEmpty() || (arr[max.peekFirst()] - arr[min.peekFirst()] <= target))) {
//                while (!max.isEmpty() && arr[rightIndex] >= arr[max.pollLast()]) {
//                    max.pollLast();
//                }
//                max.add(rightIndex);
//
//
//                while (!min.isEmpty() && arr[rightIndex] <= arr[min.peekLast()]) {
//                    min.pollLast();
//                }
//                min.add(rightIndex);
//
//                rightIndex++;
//            }
//
//            sum += (rightIndex - leftIndex - 1);
//            System.out.println(JSONArray.toJSONString(max));
//            System.out.println(JSONArray.toJSONString(min));
//
//
//            leftIndex++;


    public static int allLessNumSubArray3(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        int sum = 0;


        while (leftIndex < arr.length) {

            while (rightIndex < arr.length) {

                while (!min.isEmpty() && arr[min.peekLast()] >= arr[rightIndex]) {
                    min.pollLast();
                }
                min.addLast(rightIndex);

                while (!max.isEmpty() && arr[max.peekLast()] <= arr[rightIndex]) {
                    max.pollLast();
                }
                max.addLast(rightIndex);

                if (arr[max.peekFirst()] - arr[min.peekFirst()] > target){
                    break;
                }
                rightIndex++;
            }

            if (leftIndex == max.peekFirst()) {
                max.pollFirst();
            }

            if (leftIndex == min.peekFirst()) {
                min.pollFirst();
            }


            sum = sum + (rightIndex - leftIndex);

            leftIndex++;
        }
        return sum;
    }

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> min = new LinkedList<Integer>();
        LinkedList<Integer> max = new LinkedList<Integer>();
        int leftIndex = 0;
        int rightIndex = 0;
        int sum = 0;
        while (leftIndex < arr.length) {
            while (rightIndex < arr.length) {
                while (!min.isEmpty() && arr[min.peekLast()] >= arr[rightIndex]) {
                    min.pollLast();
                }
                min.addLast(rightIndex);
                while (!max.isEmpty() && arr[max.peekLast()] <= arr[rightIndex]) {
                    max.pollLast();
                }
                max.addLast(rightIndex);
                if (arr[max.getFirst()] - arr[min.getFirst()] > num) {
                    break;
                }
                rightIndex++;
            }
            if (min.peekFirst() == leftIndex) {
                min.pollFirst();
            }
            if (max.peekFirst() == leftIndex) {
                max.pollFirst();
            }

            sum += rightIndex - leftIndex;
            leftIndex++;
        }
        return sum;
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
        int[] arr = {0, 7, 3, 1};
        int num = 2;
        printArray(arr);
//        System.out.println(allLessNumSubArray(arr, num));
//        System.out.println(getNum(arr, num));
        System.out.println(allLessNumSubArray3(arr, num));
    }
}
