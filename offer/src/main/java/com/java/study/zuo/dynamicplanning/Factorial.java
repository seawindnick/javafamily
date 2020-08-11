package com.java.study.zuo.dynamicplanning;

/**
 * <Description>
 * 阶乘
 *
 * @author hushiye
 * @since 2020-08-07 09:06
 */
public class Factorial {


    public static int factorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorial(n - 1);
    }

    public static int factorial2(int n) {

        int result = 1;
        int index = 1;
        while (index <= n) {
            result *= index++;
        }
        return result;
    }


//    public static int factorial(int n) {
//        if (n == 1 || n == 2) {
//            return 1;
//        }
//        return factorial(n - 1) + factorial(n - 2);
//    }
//
//    public static int factorial2(int n) {
//        if (n == 1 || n == 2) {
//            return 1;
//        }
//
//        int firstValue = 1;
//        int secondValue = 1;
//
//        for (int i = 3; i <= n; i++) {
//            int indexValue = firstValue + secondValue;
//            firstValue = secondValue;
//            secondValue = indexValue;
//        }
//
//        return secondValue;
//    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(factorial(20));
        long seccondTime = System.currentTimeMillis();
        System.out.println(seccondTime - startTime);
        System.out.println(factorial2(20));
        System.out.println(System.currentTimeMillis() - seccondTime);
    }

}
