package com.java.study.algorithm.zuo.dadvanced.advanced_class_01;

/**
 * 给定一个整数，判断该数是否是回文数
 */
public class Code_01_Palindrome_Number {


    public static boolean Palindrome_Number(int number) {
        if (number < 0) {
            return false;
        }

        int highValue = getTenLength(number);
        int lowValue = 10;

        while (number != 0) {
            int highIndexValue = number / highValue;
            int lowIndexValue = number % lowValue;

            if (highIndexValue != lowIndexValue) {
                return false;
            }

            number = number % highValue / lowValue;
            highValue = highValue / 100;

        }

        return true;
    }


    private static int getTenLength(int number) {
        int value = 1;
        while (number / 10 >= 1) {
            value = value * 10;
            number = number / 10;
        }

        return value;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome_Number(11541));
    }


}