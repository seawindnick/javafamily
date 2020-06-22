package com.java.study.offer.chapter5;

public class CalculateSum {

    public static void main(String[] args) {
        int sum = add(50000);
        System.out.println(sum);
    }

    private static int add(int i) {
        return i <=0 ? 0 : (i + add(i-1));
    }
}
