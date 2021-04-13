package com.java.study.algorithm.zuo.abasic.basic_class_07;

/**
 * <Description>
 *
 * @author hushiye
 * @since 4/9/21 16:22
 */
public class Code_09_Knapsack2 {


    public static int KnapsackRecursiveTemp(int[] weight, int[] value, int bag) {
        if (weight == null || weight.length == 0 || value == null || value.length == 0) {
            return 0;
        }

        return KnapsackRecursive(weight, value, bag, 0);
    }

    /**
     * @param weight
     * @param value
     * @param bag    剩余可用包裹重量
     * @param index  角标位置
     * @return
     */
    private static int KnapsackRecursive(int[] weight, int[] value, int bag, int index) {

        if (index == weight.length) {
            return 0;
        }
        if (weight[index] > bag) {
            return KnapsackRecursive(weight, value, bag, index + 1);
        }
        return Math.max(KnapsackRecursive(weight, value, bag, index + 1), value[index] + KnapsackRecursive(weight, value, bag - weight[index], index + 1));
    }


    public static int Knapsack(int[] weight, int[] value, int bag) {
        if (weight == null || weight.length == 0 || value == null || value.length == 0) {
            return 0;
        }

        int[][] dp = new int[weight.length + 1][bag + 1];
        for (int row = dp.length - 2; row >= 0; row--) {
            for (int remainBag = 0; remainBag < dp[0].length; remainBag++) {
                if (remainBag < weight[row]) {
                    dp[row][remainBag] = dp[row + 1][remainBag];
                    continue;
                }
                dp[row][remainBag] = Math.max(dp[row + 1][remainBag], dp[row + 1][remainBag - weight[row]] + value[row]);

            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] c = {3, 2, 4, 7};
        int[] p = {5, 6, 3, 19};

//        int i = 7;
//        System.out.println(KnapsackRecursiveTemp(c, p, i));
//        System.out.println(com.java.study.answer.zuo.abasic.basic_class_07.Code_09_Knapsack.maxValue1(c, p, i));
//        System.out.println(Knapsack(c, p, i));
//
        for (int i = 0; i < 100; i++) {


            int result1 = KnapsackRecursiveTemp(c, p, i);
            int result2 = Knapsack(c, p, i);
            int result3 = com.java.study.answer.zuo.abasic.basic_class_07.Code_09_Knapsack.maxValue1(c, p, i);

            if (result1 != result2 || result2 != result3) {
                System.out.println(i);
            }

        }

    }

}
