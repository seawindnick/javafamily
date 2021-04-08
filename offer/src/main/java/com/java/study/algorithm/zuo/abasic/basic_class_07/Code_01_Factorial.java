package com.java.study.algorithm.zuo.abasic.basic_class_07;

/**
 * 求n!的结果
 */
public class Code_01_Factorial {


    public static long Factorial(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        return n * Factorial(n - 1);
    }

    public static long Factorial2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = i * result;
        }
        return result;

//        long[] arr = new long[n + 1];
//        arr[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            arr[i] = i * arr[i - 1];
//        }
//        return arr[n];
    }


//    public static int Factorial(int n) {
//
//        if (n < 0) {
//            throw new IllegalArgumentException("非法数字");
//        }
//
//        if (n == 0 || n == 1) {
//            return n;
//        }
//
//        return Factorial(n - 1) + Factorial(n - 2);
//    }
//
//
//    public static int Factorial2(int n) {
//        if (n < 0) {
//            throw new IllegalArgumentException("非法数字");
//        }
//
//        if (n == 0 || n == 1) {
//            return n;
//        }
//
//
//        int[] arr = new int[n + 1];
//
//        arr[0] = 0;
//        arr[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            arr[i] = arr[i - 1] + arr[i - 2];
//        }
//
//        return arr[n];
//
//    }


    public static void main(String[] args) {

        for (int i = 0; i <= 30; i++) {
            System.out.println(Factorial(i));
            System.out.println(Factorial2(i));
        }

    }


}