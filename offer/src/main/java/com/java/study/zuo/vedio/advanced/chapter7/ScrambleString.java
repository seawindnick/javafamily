package com.java.study.zuo.vedio.advanced.chapter7;

/**
 * <Description>
 * 搅乱串
 *
 * @author hushiye
 * @since 2020-09-23 22:00
 */
public class ScrambleString {


    public static final Boolean checkScrambleString(String target, String result) {


        return fun1(target.toCharArray(), result.toCharArray(), 0, 0, target.length());
    }


    public static boolean fun1(char[] char1, char[] chars2, int l1, int l2, int size) {
        if (size == 1) {
            return char1[l1] == chars2[l2];
        }

        for (int part = 1; part < size; part++) {
            boolean check = (fun1(char1, chars2, l1, l2, part) &&
                    fun1(char1, chars2, l1 + part, l2 + part, size - part)
                    || (fun1(char1, chars2, l1, l2 + size - part, part) &&
                    fun1(char1, chars2, l1 + part, l2, size - part)));

            if (check) {
                return true;
            }

        }
        return false;
    }

    public static boolean fun2(char[] char1, char[] chars2) {
        // l1 l2 size
        boolean[][][] dp = new boolean[char1.length][char1.length][char1.length + 1];

        for (int i = 0; i < char1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                dp[i][j][1] = char1[i] == chars2[j];
            }
        }

        int N = char1.length;

        //size
        for (int size = 2; size <= N; size++) {
            //l1
            for (int L1 = 0; L1 <= N - size; L1++) {
                //l2
                for (int L2 = 0; L2 <= N - size; L2++) {

                    for (int part = 1; part < size; part++) {
                        boolean check = (dp[L1][L2][part] && dp[L1 + part][L2 + part][size - part])
                                ||
                                (dp[L1][L2 + size - part][part] && dp[L1 + part][L2][size - part]);
                        if (check) {
                            dp[L1][L2][size] = check;
                            break;
                        }
                    }

                }
            }
        }

        return dp[0][0][N];

    }

    public static boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int N = s1.length();
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        boolean[][][] dp = new boolean[N][N][N + 1];
        for (int L1 = 0; L1 < N; L1++) {
            for (int L2 = 0; L2 < N; L2++) {
                dp[L1][L2][1] = chs1[L1] == chs2[L2];
            }
        }
        for (int size = 2; size <= N; size++) {
            for (int L1 = 0; L1 <= N - size; L1++) {
                for (int L2 = 0; L2 <= N - size; L2++) {
                    for (int p = 1; p < size; p++) {
                        if ((dp[L1][L2][p] && dp[L1 + p][L2 + p][size - p])
                                || (dp[L1][L2 + size - p][p] && dp[L1 + p][L2][size
                                - p])) {
                            dp[L1][L2][size] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][N];
    }


    private static Boolean checkScrambleString(char[] targetCharArray, char[] resultCharArray) {

        for (int i = 0; i < targetCharArray.length; i++) {
            boolean check = (function(targetCharArray, resultCharArray, 0, 0, i) &&
                    function(targetCharArray, resultCharArray, i + 1, i + 1, targetCharArray.length - 1 - i))
                    || (function(targetCharArray, resultCharArray, 0, targetCharArray.length - 1 - i, i) &&
                    function(targetCharArray, resultCharArray, i + 1, 0, targetCharArray.length - 1 - i));
            if (check) {
                return true;
            }
        }
        return false;
    }

    private static boolean function(char[] targetCharArray, char[] resultCharArray, int targetStartIndex, int resultStartIndex, int length) {
        if (length == 1) {
            return targetCharArray[targetStartIndex] == resultCharArray[resultStartIndex];
        }

        for (int i = 0; i <= length; i++) {
            reverse(targetCharArray, targetStartIndex, targetStartIndex + i);
            if (checkMatch(targetCharArray, resultCharArray, targetStartIndex, resultStartIndex, length)) {
                return true;
            }
            reverse(targetCharArray, targetStartIndex, targetStartIndex + i);
        }

        return false;
    }

    private static boolean checkMatch(char[] targetCharArray, char[] resultCharArray, int targetStartIndex, int resultStartIndex, int length) {
        for (int i = 0; i < length; i++) {
            if (targetCharArray[targetStartIndex + i] != resultCharArray[resultStartIndex + i]) {
                return false;
            }

        }
        return true;
    }


    public static void reverse(char[] arr, int l, int r, int mid) {
        reverse(arr, l, mid);
        reverse(arr, mid + 1, r);
        reverse(arr, l, r);
    }

    public static void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String str1 = "great";
        String str2 = "eatgr";

//        System.out.println(checkScrambleString(str1, str2));
        System.out.println(fun2(str1.toCharArray(), str2.toCharArray()));
        System.out.println(isScramble2(str1, str2));
    }
}
