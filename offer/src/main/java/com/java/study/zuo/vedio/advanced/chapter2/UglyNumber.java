package com.java.study.zuo.vedio.advanced.chapter2;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-05 14:58
 */
public class UglyNumber {

    public static long uglyNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("非法参数");
        }
        if (n == 1) {
            return 1;
        }


        int[] help = new int[n];
        help[0] = 1;

        int towIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;


        for (int i = 1; i < n; i++) {
            help[i] = Math.min(help[towIndex] * 2, Math.min(help[threeIndex] * 3, help[fiveIndex] * 5));

            // 不使用if else 是因为有重复数据
            if (help[i] == help[towIndex] * 2) {
                towIndex++;
            }
            if (help[i] == help[threeIndex] * 3) {
                threeIndex++;
            }
            if (help[i] == help[fiveIndex] * 5) {
                fiveIndex++;
            }
        }
        return help[n - 1];
    }



    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(uglyNumber(i));
        }
    }
}
