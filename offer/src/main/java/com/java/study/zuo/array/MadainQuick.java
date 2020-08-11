package com.java.study.zuo.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <Description>
 * 快速输出中位数
 * <p>
 * 使用大堆和小堆两种结构
 * 进入数据大于小根堆的头节点，放在大根堆
 * 小于小根堆头节点的数据，放在小根堆
 * 如果两个堆数量相差大于1 ，取多的堆头节点，放到另外一个堆上
 *
 * @author hushiye
 * @since 2020-08-05 22:06
 */
public class MadainQuick {

    public static class MadainHelper{
        private PriorityQueue<Integer> minQueue = new PriorityQueue<>(new MinCompartor());
        private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new MaxCompartor());

        public void add(int num) {
            if (maxQueue.isEmpty()) {
                maxQueue.add(num);
                return;
            }

            if (num >= maxQueue.peek()) {
                minQueue.add(num);
            } else {
                maxQueue.add(num);
            }
            modify();
        }

        //平衡
        private  void modify() {
            if (maxQueue.size() - minQueue.size() == 2) {
                minQueue.add(maxQueue.poll());
            }

            if (minQueue.size() - maxQueue.size() == 2) {
                maxQueue.add(minQueue.poll());
            }
        }


        private Integer getMadainQuick() {

            if (maxQueue.size() + minQueue.size() == 0) {
                return null;
            }

            Integer maxElement = maxQueue.peek();
            Integer minElement = minQueue.peek();

            //偶数位
            if (((maxQueue.size() + minQueue.size()) & 1) == 0) {
                return (maxElement + minElement) >> 1;
            }

            if (maxQueue.size() > minQueue.size()) {
                return maxElement;
            }

            return minElement;
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
            MadainHelper medianHold = new MadainHelper();
            for (int j = 0; j != arr.length; j++) {
                medianHold.add(arr[j]);
            }
            if (medianHold.getMadainQuick() != getMedianOfArray(arr)) {
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

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


}
