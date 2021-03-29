package com.java.study.algorithm.zuo.abasic.basic_class_04;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 输入: 参数1，正数数组costs 参数2，正数数组profits 参数3，正数k 参数4，正数m
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你不能并行、只能串行的最多做k个项目
 * m表示你初始的资金
 * 说明:你每做完一个项目，马上获得的收益，可以支持你去做下一个
 * 项目。
 * 输出:
 * 你最后获得的最大钱数。
 */
public class Code_03_IPO {


    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (Capital.length == 0 || Profits.length == 0) {
            return 0;
        }


        //花费小的在上面
        PriorityQueue<Project> costMinPriorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost.compareTo(o2.cost));
        for (int i = 0; i < Capital.length; i++) {
            Project project = new Project(Capital[i], Profits[i]);
            costMinPriorityQueue.add(project);
        }

        //利润高的在上面
        PriorityQueue<Project> profitMaxPriorityQueue = new PriorityQueue<>((o1, o2) -> o2.profit.compareTo(o1.profit));

        int count = 0;
        int money = W;
        while (count < k) {
            while (!costMinPriorityQueue.isEmpty() && costMinPriorityQueue.peek().cost <= money) {
                profitMaxPriorityQueue.add(costMinPriorityQueue.poll());
            }

            if (profitMaxPriorityQueue.isEmpty()) {
                break;
            }
            money = money + profitMaxPriorityQueue.poll().profit;
            count++;

        }
        return money;
    }

    private static List<Project> buildProjectList(int[] costs, int[] profits) {
        List<Project> list = new ArrayList<>(costs.length);
        for (int i = 0; i < costs.length; i++) {
            Project project = new Project(costs[i], profits[i]);
            list.add(project);
        }
        return list;
    }


    public static class Project {
        private Integer cost;
        private Integer profit;

        public Project(Integer cost, Integer profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {

        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));

    }
}