package com.java.study.zuo.vedio.basic.chapter4;

import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-24 00:05
 */
public class IPO {


    private int getMaxValue(int[] costs, int[] profilles, int times, int value) {
        if (costs == null || costs.length == 0) {
            return value;
        }

        PriorityQueue<Case> costPriorityQueue = new PriorityQueue(new MinCostCompartor());
        PriorityQueue<Case> proflePriorityQueue = new PriorityQueue(new MaxProfileCompartor());

        for (int i = 0; i < costs.length; i++) {
            Case caseObject = new Case(costs[i], profilles[i]);
            costPriorityQueue.add(caseObject);
        }

        while (times > 0) {
            while (!costPriorityQueue.isEmpty() && value >= costPriorityQueue.peek().cost) {
                proflePriorityQueue.add(costPriorityQueue.poll());
            }

            if (proflePriorityQueue.isEmpty()) {
                return value;
            }
            value += proflePriorityQueue.poll().profile;
            times--;
        }
        return value;
    }

    @Data
    private static class Case {
        private int cost;
        private int profile;

        public Case(int cost, int profile) {
            this.cost = cost;
            this.profile = profile;
        }
    }


    private static class MinCostCompartor implements Comparator<Case> {
        @Override
        public int compare(Case o1, Case o2) {
            return o1.cost - o2.cost;
        }
    }

    private static class MaxProfileCompartor implements Comparator<Case> {
        @Override
        public int compare(Case o1, Case o2) {
            return o2.profile - o1.profile;
        }
    }
}
