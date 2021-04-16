package com.java.study.algorithm.zuo.abasic.basic_class_02;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 查询最大的回文串长度
 */
public class Code_04_Manacher {

    public static int Manacher(String str) {

        if (str == null || str.length() <= 1) {
            return 0;
        }

        char[] manacherArr = getManacherArr(str);

        int max = getMaxManacher(manacherArr);


        return max;

    }

    private static int getMaxManacher(char[] manacherArr) {
        int[] pArr = new int[manacherArr.length];

        int maxRight = -1;
        int curIndex = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < manacherArr.length; i++) {
            pArr[i] = maxRight > i ? Math.max(pArr[2 * curIndex - i], maxRight - i) : 1;

            while (i + pArr[i] < manacherArr.length && i - pArr[i] >= 0) {
                if (manacherArr[i + pArr[i]] == manacherArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }

            if (i + pArr[i] >= maxRight) {
                curIndex = i;
                maxRight = i + pArr[i];
            }

            max = Math.max(max, pArr[i]);

        }
        return max - 1;
    }


//    public static char[] manacherString(String str) {
//        char[] charArr = str.toCharArray();
//        char[] res = new char[str.length() * 2 + 1];
//        int index = 0;
//        for (int i = 0; i != res.length; i++) {
//            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
//        }
//        return res;
//    }
//
//    public static int maxLcpsLength(String str) {
//        if (str == null || str.length() == 0) {
//            return 0;
//        }
//        char[] charArr = manacherString(str);
//        int[] pArr = new int[charArr.length];
//        int index = -1;
//        int pR = -1;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i != charArr.length; i++) {
//            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
//            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
//                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
//                    pArr[i]++;
//                else {
//                    break;
//                }
//            }
//            if (i + pArr[i] > pR) {
//                pR = i + pArr[i];
//                index = i;
//            }
//            max = Math.max(max, pArr[i]);
//        }
//        return max - 1;
//    }


    private static char[] getManacherArr(String str) {
        char[] arr = new char[str.length() * 2 + 1];
        int curIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i & 1) == 0 ? '#' : str.charAt(curIndex++);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Manacher("abbbba"));
    }
}