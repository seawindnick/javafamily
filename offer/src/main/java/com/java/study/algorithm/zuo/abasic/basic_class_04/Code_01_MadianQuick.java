package com.java.study.algorithm.zuo.abasic.basic_class_04;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 随时找到数据流的中位数
 * 【题目】 有一个源源不断地吐出整数的数据流，假设你有足够的空间来 保存吐出的数。
 * 请设计一个名叫MedianHolder的结构， MedianHolder可以随时取得之前吐出所有数的中位数。
 * 【要求】
 * 1.如果MedianHolder已经保存了吐出的N个数，那么任意时刻 将一个新数加入到MedianHolder的过程，其时间复杂度是 O(logN)。
 * 2.取得已经吐出的N个数整体的中位数的过程，时间复杂度为 O(1)。
 */
public class Code_01_MadianQuick {

    public static class MadianQuick {
        //小堆上的数字大
        public PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));

        //大堆上的数字小
        public PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<Integer>((o1, o2) -> o1.compareTo(o2));


        public void put(Integer value) {


            if (maxPriorityQueue.isEmpty()) {
                maxPriorityQueue.add(value);
                return;
            }

            if (value < maxPriorityQueue.peek()) {
                minPriorityQueue.add(value);
            } else {
                maxPriorityQueue.add(value);
            }

            if (minPriorityQueue.size() - maxPriorityQueue.size() == 2) {
                maxPriorityQueue.add(minPriorityQueue.poll());
            }

            if (maxPriorityQueue.size() - minPriorityQueue.size() == 2) {
                minPriorityQueue.add(maxPriorityQueue.poll());
            }

        }

        public double getMadianQuick() {
            if (minPriorityQueue.isEmpty() && maxPriorityQueue.isEmpty()) {
                return 0;
            }

            if (maxPriorityQueue.size() > minPriorityQueue.size()) {
                return maxPriorityQueue.peek();
            }

            if (maxPriorityQueue.size() < minPriorityQueue.size()) {
                return minPriorityQueue.peek();
            }
            int value = maxPriorityQueue.peek() + minPriorityQueue.peek();

            double result = (double) (value / 2.0);


            return result;

        }

    }


    // for test
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MadianQuick medianHold = new MadianQuick();
        int[] arrtemp = new int[]{1,2,3,4,5,6,7,8};
        for (int i : arrtemp) {
            medianHold.put(i);
        }

        System.out.println(medianHold.getMadianQuick());
//
//
//
//        boolean err = false;
//        int testTimes = 200000;
//        for (int i = 0; i != testTimes; i++) {
//            int len = 30;
//            int maxValue = 1000;
//            int[] arr = getRandomArray(len, maxValue);
//            MadianQuick medianHold = new MadianQuick();
//            for (int j = 0; j != arr.length; j++) {
//                medianHold.put(arr[j]);
//            }
//
//            int result = medianHold.getMadianQuick();
//            int result2 = getMedianOfArray(arr);
//            if (result != result2) {
//                System.out.println(result + "---------" + result2);
//                int[] newArr = Arrays.copyOf(arr, arr.length);
//                Arrays.sort(newArr);
//                printArray(newArr);
//                err = true;
//                printArray(arr);
//                break;
//            }
//        }
//        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }


}