package com.java.study.algorithm.zuo.abasic.basic_class_07;

/**
 * 给定两个数组w和v，
 * 两个数组长度相等，w[i]表示第i件商品的 重量，
 * v[i]表示第i件商品的价值。 再给定一个整数bag，
 * 要求你挑选商品的重量加起来一定不能超 过bag，返回满足这个条件下，你能获得的最大价值
 */
public class Code_09_Knapsack {


    public static int Knapsack(int[] weight, int[] value, int bag) {
        if (weight == null || weight.length == 0 || value == null || value.length == 0) {
            return 0;
        }

        int[][] dp = new int[weight.length + 1][bag + 1];


        // 行
        for (int i = dp.length - 2; i >= 0; i--) {
            //列
            for (int j = 0; j < dp[0].length; j++) {

                if (j < weight[i]) {
                    dp[i][j] = dp[i + 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - weight[i]] + value[i]);
            }
        }
        return dp[0][bag];
    }


    public static int KnapsackRecursive(int[] weight, int[] value, int bag) {
        if (weight == null || weight.length == 0 || value == null || value.length == 0) {
            return 0;
        }

        return KnapsackRecursive(weight, value, bag, 0, 0);
    }


    private static int KnapsackRecursive(int[] weight, int[] value, int remainBag, int index, int result) {

        if (index == weight.length) {
            return result;
        }

        if (weight[index] > remainBag) {
            return KnapsackRecursive(weight, value, remainBag, index + 1, result);
        }

        return Math.max(KnapsackRecursive(weight, value, remainBag, index + 1, result), KnapsackRecursive(weight, value, remainBag - weight[index], index + 1, result + value[index]));
    }




    public static void main(String[] args) {
        int[] c = {3, 2, 4, 7};
        int[] p = {5, 6, 3, 19};

        for (int i = 0; i < 100; i++) {
            int result1 = KnapsackRecursive(c, p, i);
            int result2 = Knapsack(c, p, i);
            int result3 = com.java.study.answer.zuo.abasic.basic_class_07.Code_09_Knapsack.maxValue1(c, p, i);

            if (result1 != result2 || result2 != result3){
                System.out.println(i);
            }

        }

//        System.out.println(maxValue2(c, p, bag));
    }
}