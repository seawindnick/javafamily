package com.java.study.zuo.vedio.basic.chapter4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-23 23:45
 */
public class MedianHolder {


    private PriorityQueue<Integer> minPriorityQueue;
    private PriorityQueue<Integer> maxPriorityQueue;

    public MedianHolder() {
        //小的放大堆
        minPriorityQueue = new PriorityQueue<>(new MaxCompartor());
        //大的放小堆
        maxPriorityQueue = new PriorityQueue<>(new MinCompartor());
    }


    public void addNumber(Integer value) {
        if (minPriorityQueue.isEmpty()) {
            minPriorityQueue.add(value);
            return;
        }

        if (value > minPriorityQueue.peek()) {
            maxPriorityQueue.add(value);
        } else {
            minPriorityQueue.add(value);
        }
        transfiy();
    }

    private void transfiy() {
        if (minPriorityQueue.size() - maxPriorityQueue.size() == 2) {
            maxPriorityQueue.add(minPriorityQueue.poll());
        }

        if (maxPriorityQueue.size() - minPriorityQueue.size() == 2) {
            minPriorityQueue.add(maxPriorityQueue.poll());
        }
    }

    public Integer getMedian() {
        if (minPriorityQueue.isEmpty() && maxPriorityQueue.isEmpty()) {
            return null;
        }

        if (minPriorityQueue.size() == maxPriorityQueue.size()) {
            return (maxPriorityQueue.peek() + minPriorityQueue.peek()) / 2;
        }
        return maxPriorityQueue.size() > minPriorityQueue.size() ? maxPriorityQueue.peek() : minPriorityQueue.peek();
    }


    public static class MinCompartor implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MaxCompartor implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
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
        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = getRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNumber(arr[j]);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }


}
