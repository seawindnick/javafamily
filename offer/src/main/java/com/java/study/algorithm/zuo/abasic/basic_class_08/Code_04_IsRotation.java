package com.java.study.algorithm.zuo.abasic.basic_class_08;

/**
 * 想想一个字符串其实是个循环数组，可以循环右移。 比如”abc”，
 * 向右循环右移一位，得到”cab”， 向右循环右移两位，得到“bca”， 向右循环右移三位，得到“abc”，
 * 给定两个字符串str1和str2，判断str2是不是由str1循环右移得到的
 */
public class Code_04_IsRotation {


    public static boolean IsRotation(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return Boolean.TRUE;
        }

        if (str1 == null && str2 != null || str2 == null && str1 != null || str1.length() != str2.length()) {
            return Boolean.FALSE;
        }

        String checkStr = str1 + str1;

        char[] arr1 = checkStr.toCharArray();
        char[] arr2 = str2.toCharArray();
        return IsRotation(arr1, arr2, 0, 0);
    }

    /**
     * @param arr1
     * @param arr2
     * @param arr1Index
     * @param arr2Index
     * @return
     */
    private static boolean IsRotation(char[] arr1, char[] arr2, int arr1Index, int arr2Index) {
        if (arr1Index == arr1.length) {
            return false;
        }
        if (arr2Index == arr2.length - 1) {
            return arr1[arr1Index] == arr2[arr2Index];
        }

        return arr1[arr1Index] == arr2[arr2Index] && IsRotation(arr1, arr2, arr1Index + 1, arr2Index + 1)
                || IsRotation(arr1, arr2, arr1Index + 1, arr2Index);
    }


    public static boolean IsRotation2(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return Boolean.TRUE;
        }

        if (str1 == null && str2 != null || str2 == null && str1 != null || str1.length() != str2.length()) {
            return Boolean.FALSE;
        }

        String checkStr = str1 + str1;

        char[] arr1 = checkStr.toCharArray();
        char[] arr2 = str2.toCharArray();

        int row = arr2.length;
        int column = arr1.length;
        boolean[][] dp = new boolean[row][column];
        for (int i = 0; i < column; i++) {
            dp[row - 1][i] = arr1[i] == arr2[row - 1];
        }

        //行
        for (int i = row - 2; i >= 0; i--) {
            //列
            for (int j = column - 2; j >= 0; j--) {
                dp[i][j] = arr1[j] == arr2[i] && dp[i + 1][j + 1] == true
                        || dp[i][j + 1] == true;

            }
        }

        return dp[0][0];

    }


    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "cab";

        System.out.println(IsRotation2(str1, str2));

    }
}