package com.java.study.zuo.vedio.basic.chapter8;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-29 16:29
 */
public class IsRotation {

    public static boolean isRotation(String str1, String str2) {
        if (str1 == null || str1.length() == 0) {
            return false;
        }

        String targetStr = str1 + str1;

        return getIndex(targetStr, str2);
    }

    private static boolean getIndex(String targetStr, String str2) {

        int[] next = getNext(str2);

        char[] firstCharray = targetStr.toCharArray();
        char[] secondCharray = str2.toCharArray();

        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < targetStr.length() && secondIndex < str2.length()) {
            if (firstCharray[firstIndex] == secondCharray[secondIndex]) {
                firstIndex++;
                secondIndex++;
            } else if (next[secondIndex] == -1) {
                firstIndex++;
            } else {
                firstIndex = next[firstIndex];
            }
        }

        return secondIndex == str2.length();
    }

    private static int[] getNext(String str2) {
        if (str2 == null || str2.length() == 0) {
            return new int[]{};
        }

        if (str2.length() == 1) {
            return new int[]{-1};
        }

        if (str2.length() == 2) {
            return new int[]{-1, 0};
        }

        char[] array = str2.toCharArray();
        int[] next = new int[str2.length()];
        next[0] = -1;
        next[1] = 0;

        int headIndex = 0;
        int index = 2;
        while (index < str2.length()) {
            if (array[index - 1] == array[headIndex]) {
                next[index++] = ++headIndex;
            } else if (headIndex > 0) {
                headIndex = next[headIndex];
            } else {
                next[index++] = 0;
            }
        }

        return next;
    }

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(isRotation(str, "abcdab"));
    }
}
