package com.java.study.algorithm.zuo.bbasic.basic_class_02;

import static com.java.study.answer.zuo.abasic.basic_class_02.Code_04_Manacher.maxLcpsLength;

public class Code_04_Manacher {

    public static int Manacher(String str) {
        char[] array = getManacher(str);
        int max = getMax2(array);

        return max;
    }

    private static int getMax(char[] array) {
        int[] dp = new int[array.length];
        int maxRight = -1;
        int centerIndex = -1;
        int max = -1;
        int index = 0;

        while (index < array.length) {
            dp[index] = 1;

            if (maxRight > index) {
                dp[index] = Math.min(dp[2 * centerIndex - index], maxRight - index);
            }

            while (index - dp[index] >= 0 && index + dp[index] <= array.length - 1) {
                if (array[index - dp[index]] == array[index + dp[index]]) {
                    dp[index]++;
                } else {
                    break;
                }
            }

            if (index + dp[index] >= maxRight) {
                maxRight = index + dp[index];
                centerIndex = index;
            }

            max = Math.max(max, dp[index]);
            index++;


        }

        // TODO 问什么返回max-1?
        /***
         *
         * # a # b # c # b # a #
         * 以c为中心的回文半径为 6，其回文总长度为  abcba 为5
         *
         */
        return max - 1;
    }

    private static int getMax2(char[] array) {
        int[] dp = new int[array.length];
        int maxRight = -1;
        int centerIndex = -1;
        int max = Integer.MIN_VALUE;

        for (int index = 0; index < array.length; index++) {
            dp[index] = maxRight > index ? Math.min(dp[2 * centerIndex - index], maxRight - index) : 1;

            while (index - dp[index] > -1 && index + dp[index] < array.length) {
                if (array[index - dp[index]] == array[index + dp[index]]) {
                    dp[index]++;
                } else {
                    break;
                }
            }

            if (index + dp[index] > maxRight) {
                maxRight = index + dp[index];
                centerIndex = index;
            }

            max = Math.max(max, dp[index]);
        }


        return max - 1;
    }

    private static char[] getManacher(String str) {
        char[] array = new char[str.length() * 2 + 1];
        int curIndex = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (i & 1) == 0 ? '#' : str.charAt(curIndex++);
        }
        return array;
    }


    public static void main(String[] args) {
        String str1 = "abc12343";
        System.out.println(maxLcpsLength(str1));
        System.out.println(Manacher(str1));
    }
}