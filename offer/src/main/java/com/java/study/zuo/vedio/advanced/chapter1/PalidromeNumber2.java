package com.java.study.zuo.vedio.advanced.chapter1;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-05 14:30
 */
public class PalidromeNumber2 {

    public static Boolean palidromeNumber2(int value) {
        if (value < 0) {
            return Boolean.FALSE;
        }
        int initValue = value;
        int help = 1;
        while (initValue / 10 != 0) {
            help = help * 10;
            initValue = initValue / 10;

        }

        while (value != 0) {
            if ((value / help) != (value % 10)) {
                return Boolean.FALSE;
            }
            value = (value % help) / 10;
            help = help / 100;
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        int value = 121;
        System.out.println(palidromeNumber2(value));
    }
}
