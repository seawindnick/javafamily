package com.java.study.algorithm.zuo.abasic.basic_class_08;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目 的宣讲。
 * 给你每一个项目开始的时间和结束的时间(给你一个数组，里面 是一个个具体的项目)，
 * 你来安排宣讲的日程，要求会议室进行 的宣讲的场次最多。
 * 返回这个最多的宣讲场次。
 */
public class Code_07_BestArrange {

    @Data
    public static class Subject {
        private int startTime;
        private int endTime;
    }

    public static class SubjectCompartor implements Comparator<Subject> {

        @Override
        public int compare(Subject o1, Subject o2) {
            return o1.startTime - o2.startTime;
        }
    }


    public static int BestArrange2(Subject[] array) {
        Arrays.sort(array, new SubjectCompartor());

        int startTime = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (startTime <= array[i].startTime) {
                sum++;
                startTime = array[i].endTime;
            }
        }
        return sum;
    }


    public static int BestArrange(int[] startTime, int[] endTime) {
        if (startTime == null || startTime.length == 0 || endTime == null || endTime.length == 0 || endTime.length != startTime.length) {
            return 0;
        }
        MyCompartor myCompartor = new MyCompartor(startTime, endTime);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(myCompartor);
        for (int i = 0; i < startTime.length; i++) {
            priorityQueue.add(i);
        }

        int sum = 0;
        int nextIndex = 0;
        while (!priorityQueue.isEmpty()) {
            while (!priorityQueue.isEmpty() && startTime[priorityQueue.peek()] >= nextIndex) {
                priorityQueue.poll();
            }

            if (!priorityQueue.isEmpty()) {
                sum++;
                nextIndex = endTime[priorityQueue.poll()];
            }

        }
        return sum;
    }

    public static class MyCompartor implements Comparator<Integer> {
        private int[] startTime;
        private int[] endTime;

        public MyCompartor(int[] startTime, int[] endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return startTime[o1] - startTime[o2] == 0 ? startTime[o1] - startTime[o2] : endTime[o1] - endTime[o2];
        }
    }
}