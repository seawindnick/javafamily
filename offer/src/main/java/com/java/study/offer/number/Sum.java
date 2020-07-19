package com.java.study.offer.number;

public class Sum {

    public static void main(String[] args) {
        int sum = calculateSum(100);
        System.out.println(sum);
    }

    private static int calculateSum(int n) {
        int sum = n;
        //只是为了 n == 0 时跳出递归
        Boolean ans = (n > 0) && (sum = sum + calculateSum(n - 1)) > 0;
        return sum;
    }
}
