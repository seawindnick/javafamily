package com.java.study.test;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-09 10:39
 */
public class PrintAll {

    public static void printAll(String s) {
        if (s == null || s.length() == 0) {
            return;
        }

        char[] arry = s.toCharArray();
        String indexStr = "";
        printAll(arry, 0, indexStr);

    }

    private static void printAll(char[] arry, int i, String indexStr) {
        if (i == arry.length) {
            System.out.println(indexStr);
            return;
        }

        printAll(arry, i + 1, indexStr);
        printAll(arry, i + 1, indexStr + arry[i]);

    }


    public static void main(String[] args) {
        String s = "hello";
        printAll(s);
    }

}
