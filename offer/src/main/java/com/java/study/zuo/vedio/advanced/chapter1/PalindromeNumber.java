package com.java.study.zuo.vedio.advanced.chapter1;

/**
 * <Description>
 * 判断一个整数是否是回文数
 *
 * @author hushiye
 * @since 2020-08-31 10:38
 */
public class PalindromeNumber {


    /**
     * 1.转成字符，然后首尾进行对比操作
     *
     * @param x
     * @return
     */
    public static boolean ialindromeNumber(Integer x) {
        if (x == null) {
            return Boolean.FALSE;
        }

        String valueStr = String.valueOf(x);

        int startIndex = 0;
        int endIndex = valueStr.length() - 1;

        char[] array = valueStr.toCharArray();
        while (startIndex < endIndex) {
            if (array[startIndex++] != array[endIndex--]) {
                return Boolean.FALSE;
            }

        }

        return Boolean.TRUE;

    }


    public static boolean ialindromeNumber(int x) {
        if (x < 0) {
            return Boolean.FALSE;
        }

        int temp = x;

        int help = 1;
        while (temp / 10 != 0) {
            help = help * 10;
            temp = temp / 10;
        }


        while (x != 0) {
            int first = x / help;
            int last = x % 10;
            if (first != last) {
                return Boolean.FALSE;
            }
            x = (x % help) / 10;
            help = help / 100;

        }
        return Boolean.TRUE;

    }


}
