package com.java.study.zuo.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-04 00:04
 */
public class LessMoney {


    public static int lessMoney(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }


        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new MinCompare());
        for (int i : arr) {
            priorityQueue.add(i);
        }

        int sum = 0;
        while (priorityQueue.size() != 1) {
            int firstLess = priorityQueue.poll();
            int secondLess = priorityQueue.poll();
            int total = firstLess + secondLess;
            priorityQueue.add(total);
            sum += total;
        }
        return sum;
    }

    public static void main(String[] args) {
        // solution
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));

        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };

        // min heap
        PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();

        // min heap use Comparator
        PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinCompare());
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ2.add(arrForHeap[i]);
        }
        while (!minQ2.isEmpty()) {
            System.out.print(minQ2.poll() + " ");
        }
        System.out.println();

        // max heap use Comparator
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxCompare());
        for (int i = 0; i < arrForHeap.length; i++) {
            maxQ.add(arrForHeap[i]);
        }
        while (!maxQ.isEmpty()) {
            System.out.print(maxQ.poll() + " ");
        }
    }


    public static class MinCompare implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {

            return o1 - o2;
        }
    }

    public static class MaxCompare implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }






}
