package com.java.study.algorithm.zuo.dadvanced.advanced_class_03;

/**
 * 将整数字符串转成整数值
 * 【题目】 给定一个字符串str，如果str符合日常书写的整数形式，并且属于32 位整数的范围，返回str所代表的整数值，否则返回0。
 * 【举例】
 * str="123"，返回123。 str="023"，因为"023"不符合日常的书写习惯，所以返回0。 str="A13"，返回0。
 * str="0"，返回0。
 * str="2147483647"，返回2147483647。 str="2147483648"，因为溢出了，所以返回0。 str="-123"，返回-123。
 */
public class Code_03_ConvertStringToInteger {


    public static int convert2(String str) {

        boolean validFlag = checkValid(str);
        if (validFlag) {
            return 0;
        }

        boolean negative = str.charAt(0) == '-';

        int startIndex = negative ? 1 : 0;

        int minValue = Integer.MIN_VALUE;

        int negativePre = minValue / 10;

        int negativeAfter = minValue % 10;


        int sum = 0;
        for (int i = startIndex; i < str.length(); i++) {
            int value = '0' - str.charAt(i);
            // sum < negativePre 此时还没有累加到最后一位，说明是 Integer.MIN_VALUE 的倒数第二位，此时就比原来的 Integer.MIN_VALUE 倒数第二位小，那么就溢出了
            if (sum < negativePre || (sum == negativePre && value < negativeAfter)) {
                return 0;
            }

            sum = sum * 10 + value;
        }

        if (!negative && sum == minValue) {
            return 0;
        }

        return negative ? sum : -sum;


    }


    private static boolean checkValid(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        if (str.charAt(0) != '-' && str.charAt(0) < '0' || str.charAt(0) > '9') {
            return true;
        }


        if ((str.charAt(0) == '-' && (str.length() == 1 || str.charAt(1) == '0')) || (str.charAt(0) == '0' && str.length() > 1)) {
            return true;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return true;
            }

        }

        return false;

    }


    public static int convert(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        if (str.charAt(0) == '0' || str.charAt(0) == '-' && (str.length() == 1 || str.charAt(1) == '0')) {
            return 0;
        }


        boolean flag = validateEffective(str);
        if (!flag) {
            return 0;
        }

        boolean negative = str.charAt(0) == '-';
        int startIndex = str.charAt(0) == '-' ? 1 : 0;

        if (!negative) {
            //判断比 Integer.MAX小
            String maxValue = String.valueOf(Integer.MAX_VALUE);
            if (str.length() > maxValue.length()) {
                return 0;
            }

            if (str.length() == maxValue.length()) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == maxValue.charAt(i)) {
                        continue;
                    }

                    if (str.charAt(i) < maxValue.charAt(i)) {
                        break;
                    }

                    return 0;
                }
            }

            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum = sum * 10 + (str.charAt(i) - '0');
            }
            return sum;
        } else {
            //与 Integer.MIN 比较
            String minValue = String.valueOf(Integer.MIN_VALUE);
            if (str.length() == minValue.length()) {

                for (int i = 1; i < str.length(); i++) {
                    if (str.charAt(i) == minValue.charAt(i)) {
                        continue;
                    }

                    if (str.charAt(i) < minValue.charAt(i)) {
                        break;
                    }
                    return 0;
                }
            }

            int sum = 0;
            for (int i = 1; i < str.length(); i++) {
                sum = sum * 10 - (str.charAt(i) - '0');
            }
            return sum;
        }


    }

    private static boolean validateEffective(String str) {

        int negativeCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                if (i != 0) {
                    return false;
                }
                negativeCount++;
                continue;
            }

            if (str.charAt(i) < 0 || str.charAt(i) > '9') {
                return false;
            }
        }

        return negativeCount <= 1;
    }

    public static void main(String[] args) {


//        int minValue = Integer.MAX_VALUE;
//
//        int negativePre = minValue / 10;
//
//        int negativeAfter = minValue % 10;
//
//        System.out.println(negativePre);
//        System.out.println(negativeAfter);


        String test1 = "2147483647"; // max in java
        System.out.println(convert(test1));

        String test2 = "-2147483688"; // min in java
        System.out.println(convert(test2));

        String test3 = "2147483648"; // overflow
        System.out.println(convert(test3));

        String test4 = "-2147483649"; // overflow
        System.out.println(convert(test4));

        String test5 = "-123";
        System.out.println(convert(test5));

    }
}