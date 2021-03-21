package com.java.study.zuo.basic.chaptertemp;

/**
 * <Description>
 * 在一个数组中,每一个数左边比当前数小的数累加起来,叫做这个数组的小和
 *
 * @author hushiye
 * @since 3/17/21 23:29
 */
public class SmallSum {


    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;
        int[] copyArray = new int[arr.length];

        return smallSum(arr, startIndex, endIndex, copyArray);
    }

    private static int smallSum(int[] arr, int startIndex, int endIndex, int[] copyArray) {
        if (startIndex >= endIndex) {
            return 0;
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;

        int leftSum = smallSum(arr, startIndex, midIndex, copyArray);
        int rightSum = smallSum(arr, midIndex + 1, endIndex, copyArray);
        int mergeSum = merge(arr, startIndex, midIndex, endIndex, copyArray);
        return leftSum + rightSum + mergeSum;
    }

    private static int merge(int[] arr, int startIndex, int midIndex, int endIndex, int[] copyArray) {
        int l = startIndex;
        int r = midIndex + 1;

        int curIndex = startIndex;

        int sum = 0;
        while (l <= midIndex && r <= endIndex) {
            if (arr[l] < arr[r]) {
                sum += arr[l] * (endIndex - r + 1);
            }
            copyArray[curIndex++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        }


        while (l <= midIndex) {
            copyArray[curIndex++] = arr[l++];
        }

        while (r <= endIndex) {
            copyArray[curIndex++] = arr[r++];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            arr[i] = copyArray[i];
        }

        return sum;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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

    // for test
    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
