package com.java.study.offer.array;

public class Dice2 {

    private static final int g_maxValue = 6;

    public static void main(String[] args) {
        printProbability(20);
    }

    private static void printProbability(int number) {
        long[][] pProbabilities = new long[2][g_maxValue * number + 1];

        for (int i = 0; i < g_maxValue; i++) {
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }

        //初始化第一个骰子各个面出现的数量
        int flag = 0;
        for (int i = 1; i <= g_maxValue; i++) {
            pProbabilities[flag][i] = 1;
        }


        for (int k = 2; k <= number; k++) {
            //第K次掷骰子，其和最小为K，小于K的情况不可能发生，将小于K的次数重置为0
            for (int i = 0; i < k; i++) {
                pProbabilities[1 - flag][i] = 0;
            }

            //第K次掷骰子，最小值为K，最大值为 g_maxValue * k
            for (int i = k; i <= g_maxValue * k; i++) {
                //上一次信息重置为0
                pProbabilities[1 - flag][i] = 0;
                //新一轮和为i 等于上一轮 几个和为 (i-1),(i-2),(i-3),(i-4),(i-5),(i-6)的和
                for (int j = 1; j <= i && j <= g_maxValue; j++) {
                    pProbabilities[1 - flag][i] = pProbabilities[1 - flag][i] + pProbabilities[flag][i - j];
                }
            }
            //翻转使用的数组
            flag = 1 - flag;
        }

        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            double ratio = pProbabilities[flag][i] / total;
            System.out.println("sum: " + i + " ratio: " + ratio + ",count:" + pProbabilities[flag][i]);
        }

    }
}
