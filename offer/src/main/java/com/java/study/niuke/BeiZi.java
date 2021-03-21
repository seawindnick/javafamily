package com.java.study.niuke;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-29 14:46
 */
public class BeiZi {


    public static int getTimes2(int level, int kChness) {
        if (level < 1 || kChness < 0) {
            return 0;
        }
        return process(level, kChness);
    }

    private static int process(int level, int kChess) {
        if (level == 0) {
            return 0;
        }

        if (kChess == 1) {
            return level;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < level + 1; i++) {
            min = Math.min(min, Math.max(process(i - 1, kChess - 1), process(level - i, kChess)));
        }

        return min + 1;
    }

    public static int getTimes3(int level, int kChness) {
        if (level < 1 || kChness < 0) {
            return 0;
        }
        int[][] dp = new int[level + 1][kChness + 1];
        for (int i = 0; i < level + 1; i++) {
            dp[i][1] = i;
        }

        for (int i = 1; i < level + 1; i++) {
            for (int j = 2; j < kChness + 1; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= i; k++) {
                    min = Math.min(min, Math.max(dp[k - 1][j - 1], dp[i - k][j]));
                }
                dp[i][j] = min + 1;
            }

        }


        return dp[level][kChness];

    }


    public static void main(String[] args) {

        for (int i = 0; i < 10 ; i++) {
            System.out.println(getTimes3(i, 2));
            System.out.println(getTimes2(i, 2));
        }


    }
}