package com.java.study.zuo.vedio.basic.chapter4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-23 23:58
 */
public class LessMoney {

    public static int lessMoney(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MinheapComparator());
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }

        int sum = 0;
        while (priorityQueue.size() > 1) {
            int value = priorityQueue.poll() + priorityQueue.poll();
            sum += value;
            priorityQueue.add(value);
        }
        return sum;
    }


    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    }

    public static class MaxheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }


    public static void main(String[] args) {
        // solution
        int[] arr = {6, 7, 8, 9};
        System.out.println(lessMoney(arr));

    }

}
