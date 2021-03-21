package com.java.study.zuo.vedio.advanced.chapter3;

import java.util.Objects;

/**
 * <Description>
 * 字符串转整数
 * <p>
 * str="123"，返回123。
 * str="023"，因为"023"不符合日常的书写习惯，所以返回0。
 * str="A13"，返回0。
 * str="0"，返回0。
 * str="2147483647"，返回2147483647。
 * str="2147483648"，因为溢出了，所以返回0。
 * str="-123"，返回-123。
 *
 * @author hushiye
 * @since 2020-09-08 17:03
 */
public class ConvertStringToInteger {


    public static int convertStringToInteger(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] array = str.toCharArray();
        Boolean negativeFlag = array[0] == '-';

        Boolean checkEffective = checkEffective(array, negativeFlag);
        if (!checkEffective) {
            return 0;
        }

        Integer min = Integer.MIN_VALUE;
        int divisor = min / 10;
        int remainder = min % 10;

        int result = 0;

        for (int i = negativeFlag ? 1 : 0; i < array.length; i++) {
            int value = 0 - (array[i] - '0');
            if (result < divisor || (result == divisor && value < remainder)) {
                return 0;
            }

            result = result * 10 + value;
        }

        return negativeFlag ? result : Objects.equals(min,result) ? 0 : Math.abs(result);

    }

    private static Boolean checkEffective(char[] array, Boolean negativeFlag) {
        if (negativeFlag && array.length == 1) {
            return Boolean.FALSE;
        }

        if (array[0] == '0' && array.length > 1 || (negativeFlag && array[1] == '0')) {
            return Boolean.FALSE;
        }


        for (int i = negativeFlag ? 1 : 0; i < array.length; i++) {
            char indexChar = array[i];
            if (indexChar < '0' || indexChar > '9') {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        String test1 = "2147483647"; // max in java
        System.out.println(convertStringToInteger(test1));

        String test2 = "-2147483648"; // min in java
        System.out.println(convertStringToInteger(test2));

        String test3 = "2147483648"; // overflow
        System.out.println(convertStringToInteger(test3));

        String test4 = "-2147483649"; // overflow
        System.out.println(convertStringToInteger(test4));

        String test5 = "-123";
        System.out.println(convertStringToInteger(test5));

    }

}
