package com.java.study.zuo.vedio.advanced.chapter3;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-08 18:40
 */
public class NumberPower {

    public static long calculateNumberPower(int number, int power) {
        int result = 1;
        int basicNumber = number;
        while (power != 0) {
            if ((power & 1) == 1) {
                result = result * basicNumber;
            }
            basicNumber = basicNumber * basicNumber;
            power = power >> 1;

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculateNumberPower(3, 6));
    }


}
