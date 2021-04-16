package com.java.study.algorithm.zuo.abasic.basic_class_02;

/**
 * 给定一个字符串str1，只能往str1的后面添加字符变成str2，要求str2 整体都是回文串且最短。
 * 举例:
 * str1 = ABC12321, 返回ABC12321CBA
 */
public class Code_05_Manacher_ShortestEnd {


    public static String ShortestEnd(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() <= 1) {
            return str + str;
        }

        char[] array = getFull(str);
        int curIndex = getCurIndex(array);

        int matchIndex = 2 * curIndex - (array.length-1);
        char[] newChar = new char[matchIndex + 1];

        while (matchIndex >= 0) {
            newChar[matchIndex] = array[matchIndex--];
        }

        for (int i = newChar.length - 1; i >= 0; i--) {
            if ((i & 1) != 0) {
                str = str + newChar[i];
            }
        }

        return str;

    }

    private static int getCurIndex(char[] array) {

        int[] pArray = new int[array.length];

        int curIndex = -1;
        int maxRight = -1;

        for (int i = 0; i < array.length; i++) {
            pArray[i] = maxRight > i ? Math.min(pArray[2 * i - curIndex], maxRight - i) : 1;
            while (i - pArray[i] > -1 && i + pArray[i] < array.length) {
                if (array[i - pArray[i]] == array[i + pArray[i]]) {
                    pArray[i]++;
                } else {
                    break;
                }
            }

            if (i + pArray[i] == array.length) {
                return i;
            }

            if (i + pArray[i] >= maxRight) {
                maxRight = i + pArray[i];
                curIndex = i;
            }
        }
        return curIndex;
    }

    private static char[] getFull(String str) {
        char[] array = new char[str.length() * 2 + 1];
        int curIndex = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (i & 1) == 0 ? '#' : str.charAt(curIndex++);
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(ShortestEnd("ABC12321"));
    }
}