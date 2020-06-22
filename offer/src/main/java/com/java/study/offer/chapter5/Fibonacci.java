package com.java.study.offer.chapter5;

public class Fibonacci {

    public static void main(String[] args) {
        long targetNum = calculate(10);
        System.out.println(targetNum);

    }

    private static long calculate(int i) {
        long  firstNum = 1;
        long  secondNum = 0;
        if (i == 0){
            return secondNum;
        }

        if (i == 1){
            return firstNum;
        }

        long targetValue = 0;
        for (int index = 2; index <= i; index++) {
            targetValue = secondNum + firstNum;
            secondNum = firstNum;
            firstNum = targetValue;
        }

        return targetValue;
    }


//    private static long calculate(int i) {
//        if (i == 0) {
//            return 0;
//        }
//
//        if (i == 1) {
//            return 1;
//        }
//        return calculate(i - 1) + calculate(i - 2);
//    }

}
