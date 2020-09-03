package com.java.study.zuo.vedio.basic.chapter2;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-18 08:56
 */
public class KMP {


    public static Boolean isContains(String firstStr, String secondStr) {
        if (firstStr == null || firstStr.length() == 0 || secondStr == null || secondStr.length() == 0) {
            return Boolean.FALSE;
        }

        int[] next = buildNext(secondStr);


        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < firstStr.length() && secondIndex < secondStr.length()) {

            if (firstStr.charAt(firstIndex) == secondStr.charAt(secondIndex)) {
                firstIndex++;
                secondIndex++;
            } else if (next[secondIndex] == -1) {
                firstIndex++;
            } else {
                secondIndex = next[secondIndex];
            }
        }

        return secondIndex == secondStr.length();

    }

    private static int[] buildNext(String firstStr) {

        if (firstStr.length() == 1) {
            return new int[]{-1};
        }

        int[] next = new int[firstStr.length()];
        next[0] = -1;
        next[1] = 0;
        int curIndex = 2;
        int preIndex = 0;
        char[] arr = firstStr.toCharArray();

        while (curIndex < arr.length) {
            if (arr[curIndex - 1] == arr[preIndex]) {
                next[curIndex++] = ++preIndex;
            } else if (preIndex > 0) {
                // abckbabcef abckbabckb
                preIndex = next[preIndex];
            } else {
                next[curIndex++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abckbabcdabckbabckb";
        String str2 = "abckbabckd";
        System.out.println(isContains(str, str2));
    }
}
