package com.java.study.algorithm.zuo.dadvanced.advanced_class_03;

/**
 * 波那契系列问题的递归和动态规划
 * 【题目】
 * 给定整数N，返回斐波那契数列的第N项。
 * 【补充题目1】
 * 给定整数N，代表台阶数，一次可以跨2个或者1个台阶，返回有多少种走法。
 * 【举例】
 * N=3，可以三次都跨1个台阶;也
 * 可以先跨2个台阶，再跨1个台阶;
 * 还可以先跨1个台阶，再跨2个台阶。所以有 三种走法，返回3。
 * 【补充题目2】
 * 假设农场中成熟的母牛每年只会生1头小母牛，并且永远不会死。
 * 第一年农场有1只成熟的母牛，从第二年开始， 母牛开始生小母牛。
 * 每只小母牛3年之后成熟又可以生小母牛。给定整数N，求出N年后牛的数量。
 * <p>
 * 【补充题目3】
 */
public class Code_06_FibonacciProblem {


    public static int Fibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("不支持");
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int pre1 = 1;
        int pre2 = 2;
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = pre1 + pre2;
            pre1 = pre2;
            pre2 = sum;


        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
}