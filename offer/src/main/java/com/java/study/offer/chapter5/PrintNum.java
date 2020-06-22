package com.java.study.offer.chapter5;

public class PrintNum {

    public static void main(String[] args) {
        int n = 6;
        printNum(n);
    }

    private static void printNum(int n) {
        if (n <= 0) {
            throw new RuntimeException("要打印的数据位数需要大于0");
        }

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        while (couldAddOne(arr)) {
            addOne(arr);
        }
    }

    private static void addOne(int[] arr) {
        for (int index = arr.length - 1; index >= 0; index--) {
            int value = arr[index];
            if (index == arr.length - 1) {
                value = value + 1;
            }

            if (value != 10) {
                arr[index] = value;
                break;
            } else {
                arr[index - 1] = arr[index - 1] + 1;
                arr[index] = 0;
            }

        }
        printNum(arr);
    }

    private static void printNum(int[] arr) {
        Boolean filterZero = Boolean.TRUE;
        StringBuilder builder = new StringBuilder();
        for (int i : arr) {
            if (filterZero && i == 0){
                continue;
            }

            builder.append(i);
            filterZero = Boolean.FALSE;
        }

        System.out.println(builder.toString());

    }

    private static boolean couldAddOne(int[] arr) {
        if (arr[arr.length - 1] != 9) {
            return Boolean.TRUE;
        }

        for (int i : arr) {
            if (i != 9) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
