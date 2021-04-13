package com.java.study.algorithm.zuo.abasic.basic_class_08;

/**
 * 给定一个字符串str，和一个整数k，返回str向右循环右移k位后的结果
 */
public class Code_05_RotateString {


    public static String RotateString(String str, int k) {
        if (str == null) {
            return null;
        }

        int moveLength = k % str.length();
        if (moveLength == 0) {
            return str;
        }

        int spiltIndex = str.length() - 1 - moveLength;

        char[] array = str.toCharArray();
        reverse(0, spiltIndex, array);
        reverse(spiltIndex + 1, str.length() - 1, array);
        reverse(0, str.length() - 1, array);
        return new String(array);

    }

    private static void reverse(int startIndex, int endIndex, char[] array) {

        while (startIndex < endIndex) {
            char temp = array[startIndex];
            array[startIndex++] = array[endIndex];
            array[endIndex--] = temp;
        }
    }


    public static void main(String[] args) {


        char[] chas2 = {'1', '2', '3', '4', '5', 'A', 'B', 'C'};
        com.java.study.answer.zuo.abasic.basic_class_08.Code_05_RotateString.rotate1(chas2, 5);
        System.out.println(String.valueOf(chas2));

        chas2 = new char[]{'1', '2', '3', '4', '5', 'A', 'B', 'C'};
        System.out.println(RotateString(String.valueOf(chas2), 5));

        chas2 = new char[]{'1', '2', '3', '4', '5', 'A', 'B', 'C'};
        com.java.study.answer.zuo.abasic.basic_class_08.Code_05_RotateString.rotate2(chas2, 3);
        System.out.println(String.valueOf(chas2));

        chas2 = new char[]{'1', '2', '3', '4', '5', 'A', 'B', 'C'};
        System.out.println(RotateString(String.valueOf(chas2), 3));

    }
}