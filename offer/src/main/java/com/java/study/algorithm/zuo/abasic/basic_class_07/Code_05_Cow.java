package com.java.study.algorithm.zuo.abasic.basic_class_07;

/**
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只 母牛，假设不会死。求N年后，母牛的数量。
 * 如果每只母牛只能活10年，求N年后，母牛的数量。
 */
public class Code_05_Cow {


    public static int cow(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 3];
        }

        return arr[arr.length - 1];
    }

    public static int cow2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n; i++) {
            int value = arr[i - 1] + arr[i - 3];
            if (i >= 10) {
                value = value - arr[i - 10];
            }
            arr[i] = value;
        }

        return arr[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(cow(20));
    }
}