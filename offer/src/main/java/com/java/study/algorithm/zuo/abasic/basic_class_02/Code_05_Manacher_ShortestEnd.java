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

        int matchIndex = 2 * curIndex - (array.length - 1);
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


    public static String ShortestEnd2(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() <= 1) {
            return str + str;
        }

        // A B C 1 2 3 2 1
        // 0 1 2 3 4 5 6 7
        //获取最大的回文数量
        int maxNum = getMaxCircle(str);
        int endIndex = str.length() - 1 - maxNum;
        while (endIndex >= 0) {
            str += str.charAt(endIndex--);
        }

        return str;

    }

    /**
     * 获取最后一个元素的最大回文数量
     *
     * @return
     */
    private static int getMaxCircle(String str) {
        if (str.length() == 1) {
            return 1;
        }
        char[] array = full(str);

        int[] pArr = new int[array.length];
        int centerIndex = -1;
        int maxRight = -1;
        int maxRange = Integer.MIN_VALUE;


        for (int i = 0; i < array.length; i++) {
            pArr[i] = maxRight > i ? Math.max(pArr[2 * centerIndex - i], maxRight - i) : 1;
            while (i - pArr[i] > -1 && i + pArr[i] < array.length) {
                if (array[i + pArr[i]] == array[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }

            if (i + pArr[i] == array.length) {
                return pArr[i] - 1;
            }

            if (i + pArr[i] >= maxRight) {
                maxRight = i + pArr[i];
                centerIndex = i;
            }
            maxRange = Math.max(maxRange, pArr[i]);

        }
        return centerIndex;
    }

    private static char[] full(String str) {
        char[] array = new char[str.length() * 2 + 1];
        int curIndex = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (i & 1) == 0 ? '#' : str.charAt(curIndex++);
        }
        return array;
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
        System.out.println(ShortestEnd2("1221"));
    }
}