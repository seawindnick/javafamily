package com.java.study.zuo.vedio.advanced.chapter4;

import java.util.Objects;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-09 14:13
 */
public class AddMinusMultiDivideByBit {


    public static int add(int num1, int num2) {

        int sum = num1;
        while (num2 != 0) {
            sum = (num1 ^ num2);
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return sum;
    }

    public static int getNagite(int a) {
        return add(~a, 1);
    }


    public static int minus(int num1, int num2) {
        return add(num1, getNagite(num2));

    }


    public static void main(String[] args) {

//        int a = 40816;
//        int b = -5657;
//        System.out.println(a/b);
//        System.out.println(div(a,b));

        for (int i = 0; i < 10000; i++) {
            int a = (int) (Math.random() * 100000) - 50000;
            int b = (int) (Math.random() * 100000) - 50000;
            int sum1 = a / b;
            int sum2 = div(a, b);
            if (!Objects.equals(sum1, sum2)) {
                System.out.println(a);
                System.out.println(b);
                System.out.println("fuck");
            }
        }


//        int a = (int) (Math.random() * 100000) - 50000;
//        int b = (int) (Math.random() * 100000) - 50000;
//        System.out.println("a = " + a + ", b = " + b);
//        System.out.println(add(a, b));
//        System.out.println(a + b);
//        System.out.println("=========");
//        System.out.println(minus(a, b));
//        System.out.println(a - b);
//        System.out.println("=========");
//        System.out.println(a * b);
//        System.out.println(multi(a, b));
//
//        System.out.println("=========");
//        System.out.println(divide(a, b));
//        System.out.println(a / b);
//        System.out.println("=========");
//
//        a = Integer.MIN_VALUE;
//        b = 32;
//        System.out.println(divide(a, b));
//        System.out.println(a / b);
    }

    private static int multi(int a, int b) {
        int sum = 0;
        int basic = a;
        boolean navagit = b < 0;
        b = navagit ? minus(0, b) : b;
        while (b != 0) {
            if ((b & 1) == 1) {
                sum = add(sum, basic);
            }
            basic = basic << 1;
            b = b >> 1;
        }

        return navagit ? minus(0, sum) : sum;
    }

    public static int multi3(int a, int b) {
        int sum = 0;
        int basic = a;
        while (b != 0) {
            if ((b & 1) == 1) {
                sum = add(sum, basic);
            }

            basic = basic << 1;
            b = b >>> 1;
        }

        return sum;

    }


    public static int multi2(int a, int b) {
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


    public static int div(int a, int b) {
        if (a == 0) {
            return 0;
        }

        if (b == 0) {
            throw new IllegalArgumentException("除数不能为0");
        }


        int calculateA = a < 0 ? a : getNagite(a);
        int calculateB = b < 0 ? b : getNagite(b);


        int value = 0;
        while (calculateA <= calculateB) {
            int indexBasicValue = calculateB;
            int indexValue = 1;

            while (calculateA <= indexBasicValue){
                int temp = indexBasicValue << 1;
                if (temp < calculateA ){
                    break;
                }

                indexValue = indexValue << 1;
                indexBasicValue = temp;
            }
            value = add(value, indexValue);
            calculateA = add(calculateA, getNagite(indexBasicValue));
        }

        if (a > 0 && b > 0 || a < 0 && b < 0) {
            return value;
        }

        return getNagite(value);
    }
}
