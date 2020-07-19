package com.java.study.offer.number;

public class UglyNumber {


    public static void main(String[] args) {
        int targetValue = 1500;
        long value = findUglyNumber(targetValue);
        System.out.println(value);
    }

    private static long findUglyNumber(int targetValue) {
        int[] arr = new int[targetValue];
        arr[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        int nextUglyInex = 1;

        while (nextUglyInex < targetValue) {
            int nextUglyNum = getMin(arr[p2] * 2, arr[p3] * 3, arr[p5] * 5);
            arr[nextUglyInex] = nextUglyNum;
            if (arr[p2] * 2 == nextUglyNum) {
                p2++;
            }
            if (arr[p3] * 3 == nextUglyNum) {
                p3++;
            }

            if (arr[p5] * 5 == nextUglyNum) {
                p5++;
            }

            nextUglyInex++;


        }
        return arr[targetValue - 1];
    }

    private static int getMin(int num1, int num2, int num3) {
        int min = Math.min(num1, num2);
        return Math.min(min, num3);
    }

//    private static long findUglyNumber(int targetValue) {
//
//        int number = 1;
//        long count = 0;
//        for (; count < targetValue; number++) {
//            if (isUgly(number)) {
//                System.out.println(number);
//                count++;
//            }
//
//        }
//
//        return number;
//
//    }
//
//
//    public static boolean isUgly(long number) {
//        while (number % 2 == 0) {
//            number = number / 2;
//        }
//
//        while (number % 3 == 0) {
//            number = number / 3;
//        }
//
//        while (number % 5 == 0) {
//            number = number / 5;
//        }
//
//        return number == 1;
//
//    }

}
