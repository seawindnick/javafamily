package com.java.study.zuo.vedio.basic.chapter1;

import com.java.study.zuo.sort.ArrayUtil;

/**
 * <Description>
 * h荷兰国旗
 *
 * @author hushiye
 * @since 2020-08-17 21:44
 */
public class NetherlandsFlag {


    public static int[] netherlandsFlag(int[] arr, int value) {

        if (arr == null || arr.length < 2) {
            return new int[]{};
        }

        int less = -1;
        int more = arr.length;
        int curIndex = 0;
        while (curIndex < more) {
            if (arr[curIndex] > value) {
                ArrayUtil.swap(arr, curIndex, --more);
            } else if (arr[curIndex] < value) {
                ArrayUtil.swap(arr, curIndex++, ++less);
            } else {
                curIndex++;
            }
        }
        return new int[]{less + 1, more - 1};
    }


    public static int[] netherlandsFlag(int[] arr, int value, int startIndex, int endIndex) {
        if (startIndex >= endIndex || endIndex - startIndex < 2) {
            return new int[]{};
        }

        int less = startIndex - 1;
        int more = endIndex + 1;
        while (startIndex < more) {
            if (arr[startIndex] > value) {
                ArrayUtil.swap(arr, --more, startIndex);
            } else if (arr[startIndex] < value) {
                ArrayUtil.swap(arr, ++less, startIndex++);
            } else {
                startIndex++;
            }

        }
        return new int[]{less + 1, more - 1};

    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = netherlandsFlag(test, 1, 0, test.length - 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
