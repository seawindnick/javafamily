package com.java.study.algorithm.zuo.dadvanced.advanced_class_04;

/**
 * 题目一
 * 只用位运算不用算术运算实现整数的加减乘除运算
 * 【题目】 给定两个32位整数a和b，可正、可负、可0。不能使用算术运算 符，分别实现a和b的加减乘除运算。
 * 【要求】 如果给定的a和b执行加减乘除的某些结果本来就会导致数据的 溢出，那么你实现的函数不必对那些结果负责
 */
public class Code_01_AddMinusMultiDivideByBit {
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }


    public static int sub(int a, int b) {
        return add(a, add(~b, 1));
    }

    public static int multiplication(int a, int b) {
        int sum = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                sum = add(sum, a);
            }
            a = a << 1;
            b = b >>> 1;
        }

        return sum;
    }

//    public static int negNum(int a) {
//        return add(~a, 1);
//    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("divisor is 0");
        }

        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        }

        if (b == Integer.MIN_VALUE) {
            return 0;
        }

        if (a == Integer.MIN_VALUE) {
            int res = div(add(a, 1), b);

            int multiplication1 = multiplication(res, b);
            int sub = sub(a, multiplication1);
            int division1 = div(sub, b);
            return add(res, division1);
        }

        return div(a, b);

    }


    public static int div(int a, int b) {
        int tempa = a > 0 ? a : negNum(a);
        int tempb = b > 0 ? b : negNum(b);

        int sum = 0;

        for (int i = 31; i >= 0; i = sub(i, 1)) {
            if ((tempa >> i) >= tempb) {
                sum = add(sum, 1 << i);
                tempa = sub(tempa, multiplication(tempb, 1 << i));
            }
        }

        return ((a >= 0 && b > 0) || (a < 0 && b < 0)) ? sum : (~sum + 1);
    }

    private static int getMaxBit(int a, int b) {
        int maxBit = 1;
        while (a >= b) {
            maxBit = add(maxBit, 1);
            b = b << 1;
        }
        return maxBit;
    }

    public static void main(String[] args) {

        System.out.println(divide(33401, -12269));
        System.out.println(33401 / -12269);

        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * 100000) - 50000;
            int b = (int) (Math.random() * 100000) - 50000;
//            System.out.println(a + "============" + b);
//            System.out.println(divide(a,b));
//            System.out.println(a/b);
            if (divide(a, b) != (a / b)) {

                System.out.println(a + "============" + b);
            }
        }
    }
}