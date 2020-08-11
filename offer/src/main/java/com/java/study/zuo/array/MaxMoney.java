package com.java.study.zuo.array;

import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-04 10:40
 */
public class MaxMoney {

    /**
     * @param costs     花费列表
     * @param profits   利润列表
     * @param times     允许做的次数
     * @param principal 本金
     * @return
     */
    public static int maxMoney(int[] costs, int[] profits, int times, int principal) {

        if (costs == null || profits == null || costs.length != profits.length) {
            return principal;
        }

        PriorityQueue<Node> minNodeQueue = new PriorityQueue<>(new MinComparator());
        PriorityQueue<Node> maxNodeQueue = new PriorityQueue<>(new MaxComparator());

        for (int i = 0; i < costs.length; i++) {
            Node node = new Node(costs[i], profits[i]);
            minNodeQueue.add(node);
        }


        for (int i = 0; i < times; i++) {
            while (!minNodeQueue.isEmpty() && minNodeQueue.peek().getCosts() <= principal) {
                maxNodeQueue.add(minNodeQueue.poll());
            }

            if (maxNodeQueue.isEmpty()) {
                return principal;
            }

            principal += maxNodeQueue.poll().profits;

        }
        return principal;
    }


    public static class MinComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.getCosts() - o2.getCosts();
        }
    }


    public static class MaxComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.getProfits() - o1.getProfits();
        }
    }


    @Data
    public static class Node {
        private int costs;
        private int profits;

        public Node(int costs, int profits) {
            this.costs = costs;
            this.profits = profits;
        }
    }

    public static void main(String[] args) {
        int[] costs = {1, 2, 3, 4, 5};
        int[] profits = {1, 2, 3, 4, 5};
        System.out.println(maxMoney(costs, profits, 3, 5));

    }
//
//    /**
//     * @param costs     每个项目花费
//     * @param profits   每个项目利润
//     * @param times     最大次数
//     * @param principal 本金
//     * @return
//     */
//    public static int maxMoney(int[] costs, int[] profits, int times, int principal) {
//        if (costs == null || profits == null || costs.length != profits.length) {
//            return 0;
//        }
//
//
//        // 本金从小达到堆排序
//        PriorityQueue<Integer> minCosts = new PriorityQueue(new MinComparator(costs));
//        for (int i = 0; i < costs.length; i++) {
//            minCosts.add(i);
//        }
//
//        //利润从大到小堆排序
//        PriorityQueue<Integer> maxProfits = new PriorityQueue<>(new MaxComparator(profits));
//
//        for (int i = 0; i < times; i++) {
//
//            //每次做项目之前，都查询是否有新的项目可以做
//            while (minCosts.size() != 0 && costs[minCosts.peek()] <= principal) {
//                maxProfits.add(minCosts.poll());
//            }
//
//            if (maxProfits.isEmpty()) {
//                return principal;
//            }
//            //每次选择利润最大的项目做
//            principal += profits[maxProfits.poll()];
//        }
//
//        return principal;
//    }
//
//
//    public static class MinComparator implements Comparator<Integer> {
//        private int[] costs;
//
//        public MinComparator(int[] costs) {
//            this.costs = costs;
//        }
//
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return costs[o1] - costs[o2];
//        }
//    }
//
//    public static class MaxComparator implements Comparator<Integer> {
//        private int[] profits;
//
//        public MaxComparator(int[] profits) {
//            this.profits = profits;
//        }
//
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return profits[o2] - profits[o1];
//        }
//    }


}
