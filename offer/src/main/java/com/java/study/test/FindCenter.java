package com.java.study.test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-09 11:37
 */
public class FindCenter {

    public static class Center {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new MaxCompator());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(new MinCompator());

        public double getCenter(int[] arr, int[] brr) {
            addElement(arr);
            addElement(brr);
            return getCenter();
        }

        private double getCenter() {
            //偶数位
            if (((minQueue.size() + maxQueue.size()) & 1) == 0) {
                double value = ((double) ((minQueue.peek() + maxQueue.peek()) )/ 2);
                return value;
            } else {
                return minQueue.size() > maxQueue.size() ? minQueue.peek() : maxQueue.peek();
            }
        }

        private void addElement(int[] values) {
            if (values != null) {
                for (int value : values) {
                    if (maxQueue.isEmpty()) {
                        maxQueue.add(value);
                    } else {
                        if (value > maxQueue.peek()) {
                            minQueue.add(value);
                        } else {
                            maxQueue.add(value);
                        }
                    }

                    trify();
                }

            }
        }

        private void trify() {
            if (maxQueue.size() == minQueue.size() + 2) {
                minQueue.add(maxQueue.poll());
            } else if (minQueue.size() == maxQueue.size() + 2) {
                maxQueue.add(minQueue.poll());
            }
        }

        public static class MinCompator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }

        public static class MaxCompator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        int[] brr = {3, 4};
        Center center = new Center();
        System.out.println(center.getCenter(arr, brr));

    }

}
