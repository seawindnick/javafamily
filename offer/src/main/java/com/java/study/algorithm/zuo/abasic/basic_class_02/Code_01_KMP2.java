package com.java.study.algorithm.zuo.abasic.basic_class_02;

/**
 * <Description>
 *
 * @author hushiye
 * @since 4/15/21 17:49
 */
public class Code_01_KMP2 {

    public static int getIndex(String originStr, String match) {
        char[] originArray = originStr.toCharArray();
        char[] matchArray = match.toCharArray();

        int[] next = getNext(matchArray);

        int originIndex = 0;
        int matchIndex = 0;
        while (originIndex < originArray.length && matchIndex < matchArray.length) {
            if (originArray[originIndex] == matchArray[matchIndex]) {
                originIndex++;
                matchIndex++;
            } else if (next[matchIndex] < 0) {
                originIndex++;
            } else {
                matchIndex = next[matchIndex];
            }
        }
        return matchIndex == matchArray.length ? originIndex - matchIndex : -1;
    }

    private static int[] getNext(char[] matchArray) {
        if (matchArray.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[matchArray.length];
        next[0] = -1;
        next[1] = 0;

        int cn = 0;
        int pos = 2;

        while (pos < matchArray.length) {
            if (matchArray[pos - 1] == matchArray[cn]) {
                next[pos++] = ++cn;
                // 说明与头部有相同的元素
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(getIndex("aaaaabc", "abcc"));
    }
}
