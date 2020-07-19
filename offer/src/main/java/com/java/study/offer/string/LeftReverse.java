package com.java.study.offer.string;

import com.alibaba.fastjson.JSONArray;

public class LeftReverse {

    public static void main(String[] args) {
        String str = "abcdefg";
        leftRotateString(str, 2);
    }

    private static void leftRotateString(String str, int n) {
        if (str == null) {
            return;
        }
        char[] array = str.toCharArray();
        int length = str.length() - 1;
        if (length > 0 && n > 0 && n < length) {
            int startIndex = 0;
            int reverseIndex = n - 1;
            int endIndex = length;
            reverse(array, startIndex, reverseIndex);
            reverse(array, n, endIndex);
            reverse(array, 0, length);
        }
    }

    private static void reverse(char[] array, int startIndex, int endLength) {

        while (startIndex < endLength) {
            char temp = array[startIndex];
            array[startIndex] = array[endLength];
            array[endLength] = temp;
            startIndex++;
            endLength--;
        }
    }
}
