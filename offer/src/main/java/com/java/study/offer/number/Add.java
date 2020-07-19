package com.java.study.offer.number;

public class Add {
    public static void main(String[] args) {
        int sum = addSum(1,-2);
        System.out.println(sum);
    }

    private static int addSum(int num1, int num2) {
        int sum ,carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        }while (num2 != 0);
        return sum;

    }
}
