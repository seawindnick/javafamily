package com.java.study.algorithm.zuo.dadvanced.advanced_class_01;

import java.util.Objects;

/**
 * 给一个字符串str，代表一个整数，找到除了这个数之外，绝对值和这个数相差 最小的回文数。
 * 例如:
 * str = “123”
 * 返回“121”
 * 注意: 假设字符串str一定能变成long类型
 * <p>
 * <p>
 * 中间或者偏右增加
 * 中间或者偏左减少
 */
public class Code_07_Find_the_Closest_Palindrome3 {

    public static String Find_the_Closest_Palindrome(String str) {
        long value = Long.parseLong(str);
        long raw = getRaw(str);
        System.out.println("ansmer:raw:----------------" + raw);
        long maxValue = raw > value ? raw : getMaxValue(raw);
        System.out.println("ansmer:big:----------------" + maxValue);
        long smallValue = raw < value ? raw : getMinValue(raw);
        System.out.println("ansmer:small:----------------" + smallValue);
        return String.valueOf(maxValue - value >= value - smallValue ? smallValue : maxValue);
    }

    /**
     * 获取大的值
     * 增加，从中间位置偏下进行增加
     * 0 1 2 3 4 从2位置增加
     * 0 1 2 3   从2位置增加
     * <p>
     * 为什么增加值是从 中间位置偏下增加？
     * <p>
     * 054345
     * 获取大的值时，从3位置开始增加，因为3位置是原回文数据的最中间位置，改动其一个值即可
     * <p>
     * 0543345
     * 获取最大值时，从3位置开始增加，因为该位置是原回文数据中间偏上的位置，改动其之后，将前半部分复制到后半部分即可
     *
     * @param raw
     * @return
     */
    private static long getMaxValue(long raw) {
        char[] array = String.valueOf(raw).toCharArray();
        char[] help = new char[array.length + 1];
        help[0] = '0';
        for (int i = 0; i < array.length; i++) {
            help[i + 1] = array[i];
        }

        int centerIndex = help.length / 2;
        for (int i = centerIndex; i >= 0; i--) {
            if (++help[i] > '9') {
                help[i] = '0';
            } else {
                break;
            }
        }

        int startIndex = help[0] == '0' ? 1 : 0;
        int endIndex = help.length - 1;
        while (startIndex < endIndex) {
            help[endIndex--] = help[startIndex++];
        }


        return Long.parseLong(String.valueOf(help));
    }


    /**
     * 奇数从中间位置减少
     * 偶数从第二个中间位置减少
     * 0  1  2  3  4   从2位置减少
     * 0  1  2  3      从1位置减少
     * 为什么减少值从从简位置偏上减少？
     * <p>
     * 826628
     * 如果从中间位置偏上减少即从2位置开始减少  826528  前半部分复制到后半部分 826628
     * 如果从中间位置偏下减少 825628 前半部分复制到后半部分 825528
     * <p>
     * 那么不能把后半部分的数据复制到前半部分吗？
     * <p>
     * 1650561
     * 此时中间位置元素是0，进行减法操作之后 其变为 1649561 ,再将后面半部分复制到前半部分为 1659561 TMD 我是要找小的啊，有没有搞错
     * 此时后半部分没有进行变动，应该将前半部分复制到后半部分的
     * <p>
     * 奇数时，将前半部分复制到后半部分
     * 偶数时，将后半部分复制到前半部分，搞死了
     * <p>
     * 既然是回文，对称的结构，因此偶数时操作前面的操作后面的结果一致，因此减少时
     * 偶数操作 中间位置偏上
     *
     * <p>
     *
     * <p>
     *
     * @param raw
     * @return
     */
    private static long getMinValue(long raw) {
        char[] array = String.valueOf(raw).toCharArray();
        int centerIndex = (array.length - 1) / 2;
        for (int i = centerIndex; i >= 0; i--) {
            if (--array[i] < '0') {
                array[i] = '9';
            } else {
                break;
            }
        }

        // 如果首位减到0，则后面都是 99 离他最近的最小回文数
        if (array[0] == '0') {
            // 只有一位，说明就是一个1，直接返回0即可
            if (array.length == 1) {
                return 0;
            }

            for (int i = 1; i < array.length; i++) {
                array[i] = '9';
            }
            return Long.parseLong(String.valueOf(array));

        } else {
            int startIndex = 0;
            int endIndex = array.length - 1;
            while (startIndex < endIndex) {
                array[endIndex--] = array[startIndex++];
            }
            return Long.parseLong(String.valueOf(array));
        }

    }


    /**
     * 将前半部分直接拷贝到后半部分
     *
     * @param str
     * @return
     */
    private static long getRaw(String str) {
        char[] array = str.toCharArray();
        int centerIndex = (array.length) / 2;
        int length = array.length - 1;
        int index = 0;
        while (index < centerIndex) {
            array[length - index] = array[index];
            index++;

        }
        return Long.parseLong(String.valueOf(array));
    }


    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++) {
            long value = (long) (Math.random() * 10000000L + 1);
//            System.out.println(value);
            String value1 = String.valueOf(com.java.study.answer.zuo.dadvanced.advanced_class_01.Code_07_Find_the_Closest_Palindrome.nearestPalindromic(String.valueOf(value)));
            String value2 = Find_the_Closest_Palindrome(String.valueOf(value));

            if (!Objects.equals(value1, value2)) {
                System.out.println("fuck!" + value);
                break;
            }
////            System.out.println("ok");
        }


    }
//


}