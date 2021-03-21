package com.java.study.zuo.vedio.advanced.chapter5;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-11 12:02
 */
public class MaxDamage {


    public static int maxDamage3(int[] arr, int total) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][total + 1];
        if (arr[0] <= total) {
            dp[0][arr[0]] = arr[0];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= total; j++) {
                int no = dp[i - 1][j];
                int yes = j - arr[i] == 0 ? arr[i] : 0;
                int part = j - arr[i] > 0 ? dp[i - 1][j - arr[i]] * arr[i] : 0;
                dp[i][j] = Math.max(no, Math.max(yes, part));
            }

        }
        return dp[dp.length - 1][dp[0].length - 1];

    }


    public static int maxDamage2(int[] arr, int total) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[][] dp = new int[arr.length + 1][total + 1];

        dp[arr.length][0] = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= total; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j - arr[i] >= 0) {
                    int value = arr[i] * dp[i + 1][j - arr[i]];
                    dp[i][j] = Math.max(dp[i][j], value);
                }
            }
        }

        return dp[0][total];
    }

    public static int maxDamage(int[] arr, int total) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return maxDamage(arr, 0, arr.length - 1, total);
    }

    private static int maxDamage(int[] arr, int startIndex, int endIndex, int total) {
        if (startIndex == endIndex + 1) {
            return total == 0 ? 1 : 0;
        }
        if (total == 0) {
            return 1;
        } else if (total < 0) {
            return 0;
        }

        int nonValue = maxDamage(arr, startIndex + 1, endIndex, total);
        int haveValue = arr[startIndex] * maxDamage(arr, startIndex + 1, endIndex, total - arr[startIndex]);
        return Math.max(nonValue, haveValue);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 10;
        System.out.println(maxDamage(arr, target));
        System.out.println(maxDamage3(arr, target));
    }
}
