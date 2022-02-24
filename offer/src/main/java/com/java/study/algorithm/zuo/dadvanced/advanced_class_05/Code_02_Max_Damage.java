package com.java.study.algorithm.zuo.dadvanced.advanced_class_05;

/**
 * 某游戏是一个卡牌类游戏，玩家通过战斗或抽牌可以拿到一些 技能牌，
 * 每张技能牌都有对应的伤害值(伤 害值>=0)，
 * 当你有 了组合技属性之后，你可以在自己手头上选择任意张技能牌，
 * 以组合技的方式来攻击 boss，
 * 组合技的总伤害将等于所组合的 各张技能牌的伤害值的乘积(只有一张牌时，组合技伤害值等于 这张牌 本身的伤害值)，
 * 但是能发动组合技必须有个前提:
 * 所有 被选择的技能牌的伤害系数之和必须等于m(m>0) 以解开封印;
 * 你为了能赢得最终胜利，需要在所有技能牌中挑出若干张技能 牌触发组合技(每张牌只能用一 次)，
 * 以形成最大威力的组合技 攻击效果。
 * 例如:你有伤害值分别为1,2,3,4,5的五张牌，
 * 给定 的解开封印的阈值(m)为10，那形成最大组合攻击效果 的组合 为30(5*3*2)，
 * 而不是24(4*3*2*1)，也不是20(5*4*1)，需要输 出的结果即30。
 */
public class Code_02_Max_Damage {


    public static int Max_Damage(int[] arr, int m) {
        int startIndex = 0;
        return maxDamage(arr, m, startIndex);
    }

//    private static int maxDamage(int[] arr, int m, int sum, int startIndex, int totalPackage) {
//        if (totalPackage == m) {
//            return sum;
//        }
//
//        if (startIndex == arr.length) {
//            return Integer.MIN_VALUE;
//        }
//
//        int no = maxDamage(arr, m, sum, startIndex + 1, totalPackage);
//        int yes = maxDamage(arr, m, sum * arr[startIndex], startIndex + 1, totalPackage + arr[startIndex]);
//        return Math.max(no, yes);
//
//    }


    private static int maxDamage(int[] arr, int m, int startIndex) {

        if (m < 0) {
            return -1;
        }

        if (startIndex == arr.length) {
            return m == 0 ? 1 : -1;
        }


        int no = maxDamage(arr, m, startIndex + 1);
        int yes = arr[startIndex] * maxDamage(arr, m - arr[startIndex], startIndex + 1);
        return Math.max(no, yes);

    }


    public static int Max_Damage2(int[] arr, int m) {

        int row = arr.length;
        int[][] dp = new int[row + 1][m + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[row][i] = i == 0 ? 1 : -1;
        }


        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= arr[i]) {
                    dp[i][j] = Math.max(dp[i][j], arr[i] * dp[i + 1][j - arr[i]]);
                }

            }

        }


        printMatrix(dp);
        return dp[0][m];
    }


    public static int Max_Damagee(int[] arr, int m) {

        int row = arr.length;
        int[][] dp = new int[row][m + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[row - 1][i] = i >= arr[row - 1] ? arr[row - 1] : 1;
        }


        printMatrix(dp);

        for (int i = row - 2; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                int indexValue = arr[i];
                int maxValue = dp[i + 1][j];
                if (j >= indexValue) {
                    System.out.println(indexValue * dp[i + 1][j - indexValue]);
                    maxValue = maxValue < indexValue * dp[i + 1][j - indexValue] ? indexValue * dp[i + 1][j - indexValue] : maxValue;
                }
                dp[i][j] = maxValue;

                printMatrix(dp);
            }
        }

        printMatrix(dp);

        return dp[0][m];
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Max_Damage2(arr, 10));
        System.out.println(Max_Damagee(arr, 10));
    }


}