package com.java.study.algorithm.zuo.dadvanced.advanced_class_05;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

/**
 * 你的王国里有n条龙，你希望雇佣一些勇士把它们杀死，王国里一共有m个骑士 可以雇佣。
 * 假定，一个能力值 为x的骑士可以打败战斗力不超过x的恶龙，且 需要支付x个金币。
 * 已知勇士可以重复雇佣，且重复雇佣需要重 复支付金币， 请求出打败所有的恶龙需要的最小金币数目。
 * 例如，你的王国里有三条龙， 战斗力分别为10，11，20，
 * 同时有三个勇士可以雇佣，能力值分别为 20,12,30，
 * 最省钱的方式是能力值12的勇士攻击战斗力10的龙，
 * 能力值12的勇 士攻击战斗力11的龙，
 * 能力值 20的勇士攻击战斗力20的龙，总共付出44金币。
 * 进阶:
 * 一条龙可以被勇士合力杀死，求付出的金币数
 * 举例:
 * int[] knights = { 2, 10, 5 }; int[] dragons = { 3, 8, 6 };
 * 原问题标准下应返回:25 进阶的标准下应返回:22
 */
public class Code_03_Min_Gold {


    public static int minGold(int[] knights, int[] dragons) {
        if (knights == null || knights.length == 0) {
            return -1;
        }

        Arrays.sort(knights);
        // 二分查找 获取对应的勇士信息
        int sum = 0;

        for (int i = 0; i < dragons.length; i++) {
            int indexDragon = dragons[i];
            int left = 0;
            int right = knights.length - 1;

            int targetIndex = -1;
            // 找到大于指定值的元素第一次出现的位置
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (knights[mid] == indexDragon) {
                    targetIndex = mid;
                    break;
                }
                if (knights[mid] < indexDragon) {
                    left = mid + 1;
                } else {
                    targetIndex = mid;
                    right = mid - 1;
                }
            }

            int addValue = targetIndex == -1 ? Integer.MIN_VALUE : knights[targetIndex];
            sum += addValue;
        }

        return sum;

    }


    /**
     * 获取所有能够组成的武力值dp
     *
     * @param knights
     * @param dragons
     * @return
     */
    public static long minGold3(int[] knights, int[] dragons) {
        if (knights == null || knights.length == 0) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < knights.length; i++) {
            sum += knights[i];
        }

        boolean[][] dp = new boolean[knights.length][sum + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i == 0 || i == knights[0];
        }

        /**
         * 计算哪些数值能够被累加出来
         */
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                dp[i][j] = j == knights[i] || dp[i - 1][j];
                if (j >= knights[i]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - knights[i]];
                }
            }
        }

        //统计杀死该数值的恶龙所需要的武力值
        int[] result = new int[dp[0].length];

        // 初始化所需要的武力值信息，能够被累加出来的，说明伤害没有溢出
        for (int i = 0; i < dp[0].length; i++) {
            result[i] = dp[dp.length - 1][i] ? i : Integer.MAX_VALUE;
        }

        // 不能被累加出来的，使用离他最近的溢出武力值进行赋值操作
        int temp = result[result.length - 1];
        for (int i = result.length - 2; i >= 0; i--) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = temp;
            } else {
                temp = result[i];
            }
        }

//        printMatrix(dp);
        int total = 0;
        for (int i = 0; i < dragons.length; i++) {
            if (dragons[i] > sum) {
                return Integer.MAX_VALUE;
            }

            total += result[dragons[i]];
        }
        return total;

    }


    public static long minGold2(int[] knights, int[] dragons) {
        if (knights == null || knights.length == 0) {
            return -1;
        }
        long sum = 0;

        for (int i = 0; i < dragons.length; i++) {
            int indexDragon = dragons[i];
//            long value = findMax(knights, 0, indexDragon);

            long value = findMax(knights, indexDragon);


            sum = sum + value;
        }
        return sum;

    }

    private static long findMax(int[] knights, int indexDragon) {
        int[][] dp = new int[knights.length + 1][indexDragon + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[dp.length - 1][i] = i == 0 ? 0 : Integer.MAX_VALUE;
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i + 1][j];

                if (knights[i] >= j) {
                    dp[i][j] = Math.min(dp[i][j], knights[i]);
                }

                if (j >= knights[i] && dp[i + 1][j - knights[i]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - knights[i]] + knights[i]);
                }

            }
        }

        return dp[0][indexDragon];
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


    private static long findMax(int[] knights, int index, int indexDragon) {

        if (index == knights.length) {
            return indexDragon <= 0 ? 0 : Integer.MAX_VALUE;
        }

        if (indexDragon <= 0) {
            return 0;
        }

        long no = findMax(knights, index + 1, indexDragon);
        long have = knights[index] + findMax(knights, index + 1, indexDragon - knights[index]);
        return Math.min(no, have);
    }


    public static void main(String[] args) {
        int[] knights = {2, 10, 5};
        int[] dragons = {3, 8, 6};
        System.out.println(minGold3(knights, dragons));

    }


}