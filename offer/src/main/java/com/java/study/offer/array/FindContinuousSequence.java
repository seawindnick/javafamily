package com.java.study.offer.array;

public class FindContinuousSequence {

    public static void main(String[] args) {
        findContinuousSequence(9);
    }

    private static void findContinuousSequence(int targetValue) {
        if (targetValue < 3) {
            return;
        }

        int small = 1;
        int big = 2;
        int middle = (1 + targetValue) / 2;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == targetValue) {
                print(small, big);
            }

            while (curSum > targetValue && small < middle) {
                curSum = curSum - small;
                small++;

                if (curSum == targetValue) {
                    print(small, big);
                }
            }

            big++;
            curSum = curSum + big;

        }

    }

    private static void print(int small, int big) {
        for (; small <= big; small++) {
            System.out.printf(small + ",");
        }
        System.out.println();
    }
}
