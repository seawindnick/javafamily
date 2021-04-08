package com.java.study.algorithm.zuo.abasic.basic_class_07;

/**
 * 打印一个字符串的全部子序列，包括空字符串
 */
public class Code_03_Print_All_Subsquences {


    public static void printAllSubSquences(String str) {
        if (str == null) {
            return;
        }

        char[] arr = str.toCharArray();

        String result = "";

        printAllSubSquences(arr, 0, result);
    }

    /**
     * 字符数组
     *
     * @param arr
     * @param index
     * @param result
     */
    private static void printAllSubSquences(char[] arr, int index, String result) {
        if (index == arr.length) {
            System.out.println(result);
            return;
        }

        char indexChar = arr[index];
        printAllSubSquences(arr,index+1,result+indexChar);
        printAllSubSquences(arr,index+1,result);
    }

    public static void main(String[] args) {
        printAllSubSquences("abc");
    }
}