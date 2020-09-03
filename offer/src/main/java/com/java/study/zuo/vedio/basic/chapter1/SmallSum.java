package com.java.study.zuo.vedio.basic.chapter1;

/**
 * <Description>
 * 小和
 *
 * @author hushiye
 * @since 2020-08-17 23:21
 */
public class SmallSum {

    public static int smallSum(int[] arr) {

        if (arr == null || arr.length < 2) {
            return 0;
        }

        //归并排序
        int l = 0;
        int r = arr.length - 1;
        int[] copyArr = new int[arr.length];
        return parition(arr, l, r, copyArr);
    }

    private static int parition(int[] arr, int l, int r, int[] copyArr) {
        if (l >= r) {
            return 0;
        }
        int midIndex = l + (r - l) / 2;
        int left = parition(arr, l, midIndex, copyArr);
        int right = parition(arr, midIndex + 1, r, copyArr);
        int merge = merge(arr, l, midIndex, r, copyArr);
        return left + right + merge;

    }

    private static int merge(int[] arr, int l, int midIndex, int r, int[] copyArr) {
        int copyCurIndex = l;
        int sum = 0;
        int right = midIndex + 1;
        int left = l;

        while (left <= midIndex && right <= r) {
            sum += arr[right] > arr[left] ? (r - right + 1) * arr[left] : 0;
            copyArr[copyCurIndex++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        }

        while (left <= midIndex) {
            copyArr[copyCurIndex++] = arr[left++];
        }
        while (right <= r) {
            copyArr[copyCurIndex++] = arr[right++];
        }

        for (int i = l; i <= r; i++) {
            arr[i] = copyArr[i];
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
        int maxSize = 100;
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
