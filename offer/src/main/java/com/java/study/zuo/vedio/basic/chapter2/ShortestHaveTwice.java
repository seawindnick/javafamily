package com.java.study.zuo.vedio.basic.chapter2;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-19 08:48
 */
public class ShortestHaveTwice {


    public static String getShortestHaveTwice(String shortStr) {
        if (shortStr == null) {
            return null;
        }


        if (shortStr.length() == 1) {
            return shortStr + shortStr;
        }

        char[] array = shortStr.toCharArray();
        int[] next = getNext(array);
        int maxEqualsIndex = next[shortStr.length()];

        String str2 = shortStr;
        for (int i = maxEqualsIndex; i < shortStr.length(); i++) {
            str2 += array[i];
        }
        return str2;
    }

    private static int[] getNext(char[] array) {
        if (array.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[array.length + 1];

        next[0] = -1;
        next[1] = 0;
        int curIndex = 2;
        int cn = 0;
        while (curIndex < next.length) {
            if (array[curIndex - 1] == array[cn]) {
                next[curIndex++] = ++cn;
            } else if (cn == 0) {
                next[curIndex++] = 0;
            } else {
                cn = next[cn];
            }
        }
        return next;
    }


    public static void main(String[] args) {
        String test1 = "a";
        System.out.println(getShortestHaveTwice(test1));

        String test2 = "aa";
        System.out.println(getShortestHaveTwice(test2));

        String test3 = "ab";
        System.out.println(getShortestHaveTwice(test3));

        String test4 = "abcdabcd";
        System.out.println(getShortestHaveTwice(test4));

        String test5 = "abracadabra";
        System.out.println(getShortestHaveTwice(test5));

    }

}
