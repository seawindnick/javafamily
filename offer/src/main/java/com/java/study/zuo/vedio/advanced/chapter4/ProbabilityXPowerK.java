package com.java.study.zuo.vedio.advanced.chapter4;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-09 14:37
 */
public class ProbabilityXPowerK {
    public static double randXPowerK(int k) {
        double max = Double.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            max = Math.max(max, Math.random());
        }

        return max;
    }

    public static void main(String[] args) {
        double range = 0.5;
        int times = 5000000;
        int count = 0;
        for (int i = 0; i != times; i++) {
            if (randXPowerK(2) < range) {
                count++;
            }
        }
        double p = (double) count / (double) times;
        System.out.println("range [0," + range + "), probability: " + p);
    }
}
