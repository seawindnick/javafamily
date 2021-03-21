package com.java.study.zuo.vedio.advanced.chapter5;

import java.util.Arrays;

/**
 * <Description>
 * 你的王国里有n条龙，你希望雇佣一些勇士把它们杀死，王国里一共有m个骑士 可以雇佣。假定，一个能力值 为x的骑士可以打败战斗力不超过x的恶龙，且 需要支付x个金币。已知勇士可以重复雇佣，且重复雇佣需要重 复支付金币， 请求出打败所有的恶龙需要的最小金币数目。 例如，你的王国里有三条龙， 战斗力分别为10，11，20，同时有三个勇士可以雇佣，能力值分别为 20,12,30，最省钱的方式是能力值12的勇士攻击战斗力10的龙，能力值12的勇 士攻击战斗力11的龙，能力值 20的勇士攻击战斗力20的龙，总共付出44金币。
 * 进阶: 一条龙可以被勇士合力杀死，求付出的金币数
 * 举例:
 * int[] knights = { 2, 10, 5 }; int[] dragons = { 3, 8, 6 };
 * 原问题标准下应返回:25 进阶的标准下应返回:22
 *
 * @author hushiye
 * @since 2020-09-14 11:59
 */
public class MinGold {


    public static int minGlod4(int[] knights, int[] dragons) {
        if (dragons == null || dragons.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < dragons.length; i++) {
            sum += dragons[i];
        }

        int[] dp = new int[sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = (i == 0 || i == knights[0]) ? i : Integer.MAX_VALUE;
        }

        for (int j = 1; j < knights.length; j++) {
            int value = knights[j];
            for (int i = dp.length - 1; i >= 0; i--) {
                dp[i] = (i == value || (i - value >= 0 && dp[i - value] != Integer.MAX_VALUE) || dp[i] != Integer.MAX_VALUE) ? i : Integer.MAX_VALUE;
            }
        }

        int indexValue = Integer.MIN_VALUE;
        for (int i = dp.length-1; i >=0 ; i--) {
            if (dp[i] != Integer.MAX_VALUE){
                indexValue = dp[i];
            }
            dp[i] = indexValue;
        }

        printArray(dp);
        int res = 0;
        for (int i = 0; i < dragons.length; i++) {
            int cost = getMaxLeftmost(dp, dragons[i]);
            if (cost == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            res += cost;
        }
        return res;
    }


    public static int minGlod(int[] knights, int[] dragons) {
        if (dragons == null || dragons.length == 0) {
            return 0;
        }

        Arrays.sort(knights);

        int sum = 0;
        for (int i = 0; i < dragons.length; i++) {
            int dragon = dragons[i];
            int left = 0;
            int end = knights.length - 1;
            int mid;
            int targetIndex = -1;
            while (left <= end) {
                mid = left + (end - left) / 2;
                if (knights[mid] < dragon) {
                    left = mid + 1;
                } else {
                    // TODO 每次都记录下大于dragon的位置,如果左边还有大于的数据，那么下一次还会进入该 case,最后会是大于该数值的第一个元素的位置信息
                    targetIndex = mid;
                    end = mid - 1;
                }
            }
            sum = sum + knights[targetIndex];
        }
        return sum;

    }


    public static int minGlod2(int[] knights, int[] dragons) {
        if (dragons == null || dragons.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < dragons.length; i++) {
            sum += dragons[i];
        }

        int[][] dp = new int[knights.length][sum + 1];

        for (int i = 0; i <= sum; i++) {
            if (i == 0 || i == knights[0]) {
                dp[0][i] = i;
            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < dp.length; i++) {

            for (int j = 0; j <= sum; j++) {
                boolean exist = knights[i] == i || dp[i - 1][j] == j || (j - knights[i] >= 0 && dp[i - 1][j - knights[i]] == j - knights[i]);

                dp[i][j] = exist ? j : Integer.MAX_VALUE;
            }
        }
        int indexValue = Integer.MIN_VALUE;
        for (int i = sum; i >= 0; i--) {
            if (dp[knights.length - 1][i] != Integer.MAX_VALUE) {
                indexValue = dp[knights.length - 1][i];
            }

            dp[knights.length - 1][i] = indexValue;
        }

        int total = 0;
        for (int i = 0; i < dragons.length; i++) {
            total += dp[knights.length - 1][dragons[i]];
        }

        printArray(dp[dragons.length - 1]);
        return total;
    }


    // all values is positive.
    public static int minGold2(int[] knights, int[] dragons) {
        int sum = 0;
        for (int i = 0; i < knights.length; i++) {
            sum += knights[i];
        }
        int[] dp = new int[sum + 1];
        for (int i = 1; i <= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[knights[0]] = knights[0];
        printArray(dp);
        for (int i = 1; i < knights.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - knights[i] >= 0
                        && dp[j - knights[i]] < Integer.MAX_VALUE) {
                    dp[j] = j;
                }
            }
            printArray(dp);
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = Math.min(dp[i], dp[i + 1]);
        }
        printArray(dp);
        int res = 0;
        for (int i = 0; i < dragons.length; i++) {
            int cost = getMaxLeftmost(dp, dragons[i]);
            if (cost == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            res += cost;
        }
        return res;
    }

    public static int getMaxLeftmost(int[] sortedArr, int dragon) {
        int L = 0;
        int R = sortedArr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (sortedArr[mid] < dragon) {
                L = mid + 1;
            } else {
                index = mid;
                R = mid - 1;
            }
        }
        return index == -1 ? Integer.MAX_VALUE : sortedArr[index];
    }


    public static void printArray(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print((dp[i] == Integer.MAX_VALUE ? "X" : dp[i]) + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] knights = {2, 5, 10};
        int[] dragons = {3, 8, 6};
//        System.out.println(minGlod(knights, dragons));
//        System.out.println(minGlod2(knights, dragons));
//        System.out.println(minGold2(knights, dragons));
        System.out.println(minGlod4(knights, dragons));

    }


}
