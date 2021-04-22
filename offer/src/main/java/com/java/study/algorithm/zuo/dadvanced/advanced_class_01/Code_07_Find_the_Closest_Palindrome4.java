package com.java.study.algorithm.zuo.dadvanced.advanced_class_01;

import java.util.Objects;

/**
 * 给一个字符串str，代表一个整数，找到除了这个数之外，绝对值和这个数相差 最小的回文数。
 * 例如:
 * str = “123”
 * 返回“121”
 * 注意: 假设字符串str一定能变成long类型
 */
public class Code_07_Find_the_Closest_Palindrome4 {

    public static String Find_the_Closest_Palindrome(String str) {
        long value = Long.parseLong(str);
        long raw = getRawCheck(str);
        System.out.println("ansmer:raw:----------------" + raw);
        long maxValue = raw > value ? raw : getMaxValueCheck(raw);
        System.out.println("ansmer:big:----------------" + maxValue);
        long smallValue = raw < value ? raw : getMinValueCheck(raw);
        System.out.println("ansmer:small:----------------" + smallValue);
        return String.valueOf(maxValue - value >= value - smallValue ? smallValue : maxValue);
    }

    private static long getMinValueCheck(long raw) {
        long minValue1 = getMinValue(raw);
        long minValue2 = getSmallPalindrome(raw);
        if (minValue1 != minValue2) {
            minValue1 = getMinValue(raw);
            minValue2 = getSmallPalindrome(raw);
        }
        return minValue1;
    }

    private static long getMaxValueCheck(long raw) {
        long maxValue1 = getMaxValue(raw);
        long maxValue2 = getBigPalindrome(raw);

        if (maxValue1 != maxValue2) {
            maxValue1 = getMaxValue(raw);
            maxValue2 = getBigPalindrome(raw);
        }
        return maxValue1;
    }

    private static long getRawCheck(String str) {
        return getRaw(str);
    }

    /**
     * 获取大的值
     * 增加，从中间位置偏上进行增加
     * 0 1 2 3 4 从2位置增加
     * 0 1 2 3   从1位置增加
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


    public static Long getBigPalindrome(Long raw) {
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length + 1];
        res[0] = '0';
        for (int i = 0; i < chs.length; i++) {
            res[i + 1] = chs[i];
        }
        int size = chs.length;
        for (int j = (size - 1) / 2 + 1; j >= 0; j--) {
            if (++res[j] > '9') {
                res[j] = '0';
            } else {
                break;
            }
        }
        int offset = res[0] == '1' ? 1 : 0;
        size = res.length;
        for (int i = size - 1; i >= (size + offset) / 2; i--) {
            res[i] = res[size - i - offset];
        }
        return Long.valueOf(String.valueOf(res));
    }


    /**
     * 奇数从中间位置减少
     * 偶数从第二个中间位置减少
     * 0  1  2  3  4   从2位置减少
     * 0  1  2  3      从1位置减少
     *
     * @param raw
     * @return
     */
    private static long getMinValue(long raw) {
        char[] array = String.valueOf(raw).toCharArray();
        int centerIndex = array.length / 2;
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
                array[startIndex++] = array[endIndex--];
            }

            return Long.parseLong(String.valueOf(array));
        }

    }


    public static Long getSmallPalindrome(Long raw) {
        char[] chs = String.valueOf(raw).toCharArray();
        char[] res = new char[chs.length];
        int size = res.length;
        for (int i = 0; i < size; i++) {
            res[i] = chs[i];
        }
        for (int j = (size - 1) / 2; j >= 0; j--) {
            if (--res[j] < '0') {
                res[j] = '9';
            } else {
                break;
            }
        }
        if (res[0] == '0') {
            res = new char[size - 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = '9';
            }
            return size == 1 ? 0 : Long.parseLong(String.valueOf(res));
        }
        for (int k = 0; k < size / 2; k++) {
            res[size - 1 - k] = res[k];
        }
        return Long.valueOf(String.valueOf(res));
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
//
//        long value = 289234;
//
//        System.out.println(value);
//        String value1 = String.valueOf(com.java.study.answer.zuo.dadvanced.advanced_class_01.Code_07_Find_the_Closest_Palindrome.nearestPalindromic(String.valueOf(value)));
//        System.out.println(value1 + "-------" + (Long.parseLong(value1) - value));
//
//        String value2 = Find_the_Closest_Palindrome(String.valueOf(value));
//        System.out.println(value2 + "-------" + (Long.parseLong(value2) - value));
////

        for (int i = 0; i < 1000000; i++) {
            long value = (long) (Math.random() * 10000000L + 1);
//            System.out.println(value);
            String value1 = String.valueOf(com.java.study.answer.zuo.dadvanced.advanced_class_01.Code_07_Find_the_Closest_Palindrome.nearestPalindromic(String.valueOf(value)));
            String value2 = Find_the_Closest_Palindrome(String.valueOf(value));

            if (!Objects.equals(value1, value2)) {
                System.out.println("fuck!" + value);
                break;
            }
            System.out.println("ok");
        }


    }
//
//    public static String mirroring(String s) {
//        String x = s.substring(0, (s.length()) / 2);
//        return x + (s.length() % 2 == 1 ? s.charAt(s.length() / 2) : "") + new StringBuilder(x).reverse().toString();
//    }
//
//    public static String nearestPalindromic(String n) {
//        if (n.equals("1")) {
//            return "0";
//        }
//
//
//        String a = mirroring(n);
//        long diff1 = Long.MAX_VALUE;
//        diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
//        if (diff1 == 0) {
//            diff1 = Long.MAX_VALUE;
//        }
//        StringBuilder s = new StringBuilder(n);
//        int i = (s.length() - 1) / 2;
//        while (i >= 0 && s.charAt(i) == '0') {
//            s.replace(i, i + 1, "9");
//            i--;
//        }
//        if (i == 0 && s.charAt(i) == '1') {
//            s.delete(0, 1);
//            int mid = (s.length() - 1) / 2;
//            s.replace(mid, mid + 1, "9");
//        } else {
//            s.replace(i, i + 1, "" + (char) (s.charAt(i) - 1));
//        }
//
//        String b = mirroring(s.toString());
//        long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));
//
//
//        s = new StringBuilder(n);
//        i = (s.length() - 1) / 2;
//        while (i >= 0 && s.charAt(i) == '9') {
//            s.replace(i, i + 1, "0");
//            i--;
//        }
//        if (i < 0) {
//            s.insert(0, "1");
//        } else {
//            s.replace(i, i + 1, "" + (char) (s.charAt(i) + 1));
//        }
//
//        String c = mirroring(s.toString());
//        long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));
//
//        if (diff2 <= diff1 && diff2 <= diff3) {
//            return b;
//        }
//
//        if (diff1 <= diff3 && diff1 <= diff2) {
//            return a;
//        } else {
//            return c;
//        }
//
//    }


}