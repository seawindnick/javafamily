package com.java.study.zuo.vedio.basic.chapter7;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-26 23:29
 */
public class Subsquences {


    public static void subsquences(String str) {
        if (str == null || str.length() == 0) {
            return;
        }

        char[] array = str.toCharArray();
        String result = "";
        int index = 0;
        subsquences(array, result, index);
    }

    private static void subsquences(char[] array, String result, int index) {
        if (index == array.length) {
            System.out.println(result);
            return;
        }
        subsquences(array, result, index + 1);
        subsquences(array, result + array[index], index + 1);
    }

    public static void main(String[] args) {
        subsquences("abc");
    }
}
