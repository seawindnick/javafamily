package com.java.study.algorithm.zuo.dadvanced.advanced_class_04;

/**
 * 调整[0,x)区间上的数出现的概率
 * 【题目】
 * 假设函数Math.random()等概率随机返回一个在[0,1)范围上的 数，那么我们知道，在[0,x)区间上的数出现的概率为x (0<x≤1)。
 * 给定一个大于0的整数k，并且可以使用 Math.random()函数，请实现一个函数依然返回在[0,1)范围上 的数，但是在[0,x)区间上的数出现的概率为xk(0<x≤1)。
 */
public class Code_02_ProbabilityXPowerK {

    public static double ProbabilityXPowerK(int k) {
        double result = 0;
        for (int i = k; i > 0; i--) {
            result = random();
            if (result < 0.5) {
                return result;
            }
        }

        return result;
    }


    public static double ProbabilityXPowerK2(int k) {
        if (k < 1) {
            return 0;
        }

        double res = -1;
        for (int i = 0; i != k; i++) {
            res = Math.max(res, Math.random());
        }
        return res;
    }


    public static double random() {
        return Math.random();
    }

    public static void main(String[] args) {
        Integer lessHalf = 0;
        Integer moreHalf = 0;
        for (int i = 0; i < 10000; i++) {
            Double result = ProbabilityXPowerK2(4);
            if (result < 0.5) {
                lessHalf++;
            } else {
                moreHalf++;
            }
        }

        System.out.println(lessHalf);
        System.out.println(moreHalf);
    }
}