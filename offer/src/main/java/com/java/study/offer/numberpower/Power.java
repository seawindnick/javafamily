package com.java.study.offer.numberpower;

public class Power {
    public static void main(String[] args) {
        double base = 2;
        int exponent = -4;
        double targetValue = power(base, exponent);
        System.out.println(targetValue);
    }

    private static double power(double base, int exponent) {
        if (equal(base, 0) && exponent < 0) {
            throw new RuntimeException("底数不能为0");
        }


        if (exponent == 0) {
            return 1;
        }

        double result = powerWithUnsignedExponent(base, Math.abs(exponent));
        if (exponent < 0) {
            return 1 / result;
        }

        return result;
    }

    private static double powerWithUnsignedExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }
        return result;
    }

    /**
     * 计算机表示小数时有误差，判断两个小数是否相等，需要判断他们之差的绝对值是不是在一个很小的范围内
     *
     * @param number1
     * @param number2
     * @return
     */
    private static boolean equal(double number1, double number2) {
        return Math.abs(number1 - number2) < 0.000000001;
    }

    private static double powerWithUnsignedExponent2(double base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        double haleResult = powerWithUnsignedExponent2(base, exponent >> 1);
        double result = haleResult * haleResult;
        if ((exponent & (exponent - 1)) != 0) {
            result = result * base;
        }

        return result;
    }


}
