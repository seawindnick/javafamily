package com.java.study.zuo.vedio.advanced.chapter6;

/**
 * <Description>
 * 数组中子数组的最大累乘积
 * 【题目】 给定一个double类型的数组arr，
 * 其中的元素可正、可负、可0，返回 子数组累乘的最大乘积。
 * 例如，arr=[-2.5，4，0，3，0.5，8，-1]，
 * 子数组[3，0.5，8]累乘可以获得最大的乘积12，所以返回12。
 *
 * @author hushiye
 * @since 2020-09-17 17:45
 */
public class SubArrayMaxProduct {

    public static double subArrayMaxProduct(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }


        double max = arr[0];
        double min = arr[0];

        double res = arr[0];

        double maxEnd = 0;
        double minEnd = 0;

        for (int i = 1; i < arr.length; i++) {

            maxEnd = max * arr[i];

            minEnd = min * arr[i];

            max = Math.max(arr[i], Math.max(maxEnd, minEnd));
            min = Math.min(arr[i], Math.min(maxEnd, minEnd));
            res = Math.max(res, max);
        }

        return res;
    }

    public static void main(String[] args) {
        double[] arr = {-2.5, 4, 1, 3, 0.5, 8};
        System.out.println(subArrayMaxProduct(arr));
    }
}
