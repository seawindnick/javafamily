package com.java.study.zuo.vedio.basic.chapter2;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-21 22:19
 */
public class ShortestEnd2 {


    public static String shortestEnd(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        char[] array = str.toCharArray();
        char[] manacherArray = getManacherArray(array);

        int[] pArr = new int[manacherArray.length];
        int centerIndex = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;

        for (int index = 0; index < manacherArray.length; index++) {
            pArr[index] = pR > index ? Math.min(pArr[2 * centerIndex - index], pR - index) : 1;
            while (index + pArr[index] < manacherArray.length && index - pArr[index] > -1) {
                if (manacherArray[index + pArr[index]] == manacherArray[index - pArr[index]]) {
                    pArr[index]++;
                } else {
                    break;
                }
            }

            if (pArr[index] + index > pR) {
                pR = pArr[index] + index;
                centerIndex = index;
            }
            max = Math.max(max, pArr[index]);
            if (pArr[index] + index == manacherArray.length) {
                break;
            }

        }

        int lcpsLength = max - 1;

        //不是回文串的终点位置
        int remainLength = array.length - 1 - lcpsLength;

        while (remainLength >= 0){
            str = str + array[remainLength--];
        }

        return str;
    }

    public static char[] getManacherArray(char[] array) {
        char[] manacherArray = new char[array.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < manacherArray.length; i++) {
            manacherArray[i] = (i & 1) == 0 ? '$' : array[index++];
        }

        return manacherArray;
    }


    public static void main(String[] args) {
        System.out.println(shortestEnd("accabba"));
    }


}
