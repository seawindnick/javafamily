package com.java.study.offer.array;

public class FindOneCountNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6, 7, 7, 8};
        findOneCountNumber(arr);
    }

    private static void findOneCountNumber(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }

        int checkValue = findCheckValue(result);

        int firstValue = 0;
        int lastValue = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            // 第N位不为1
            if ((value & checkValue) == 0) {
                firstValue = firstValue ^ value;
            } else {
                lastValue = lastValue ^ value;
            }
        }

        System.out.println(firstValue);
        System.out.println(lastValue);
    }

    private static int findCheckValue(int result) {
        int checkValue = 1;
        while ((result & checkValue) == 0) {
            checkValue = checkValue << 1;
        }
        return checkValue;
    }
}
