package com.java.study.zuo.vedio.basic.chapter7;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-26 23:18
 */
public class Factorial {


    public static int factorial(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }


    public static void main(String[] args) {
        System.out.println(factorial(6));
        System.out.println(factorial2(6));
    }

    public static int factorial2(int n) {
        if (n == 0) {
            return 0;
        }

        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum * i;
        }

        return sum;
    }


//    private static int factorial(int n) {
//        if (n == 1 || n == 2) {
//            return n;
//        }
//
//        return factorial(n - 1) + factorial(n - 2);
//    }
//
//    public static void main(String[] args) {
//        System.out.println(factorial(10));
//        System.out.println(factorial2(10));
//    }
//
//
//    public static int factorial2(int n){
//        if (n == 1 || n == 2){
//            return n;
//        }
//
//        int firstValue = 1;
//        int secondValue = 2;
//
//        for (int i = 3; i <= n ; i++) {
//            int temp = firstValue + secondValue;
//            firstValue = secondValue;
//            secondValue = temp;
//        }
//
//        return secondValue;
//    }

}
