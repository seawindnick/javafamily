package com.java.study.zuo.basic.chaptertemp;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 * 逆序对问题 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序 对
 *
 * @author hushiye
 * @since 3/17/21 23:47
 */
public class ReverseOrderNum {


    public static int reverseOrderNum(int arr[]) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;
        int[] copyArray = new int[arr.length];

        return reverseOrderNum(arr, startIndex, endIndex, copyArray);

    }

    private static int reverseOrderNum(int[] arr, int startIndex, int endIndex, int[] copyArray) {
        if (startIndex >= endIndex) {
            return 0;
        }
        int minIndex = startIndex + (endIndex - startIndex) / 2;
        int leftSum = reverseOrderNum(arr, startIndex, minIndex, copyArray);
        int rightSum = reverseOrderNum(arr, minIndex + 1, endIndex, copyArray);
        int mergedSum = merge(arr, startIndex, minIndex, endIndex, copyArray);

        return leftSum + rightSum + mergedSum;

    }

    private static int merge(int[] arr, int startIndex, int minIndex, int endIndex, int[] copyArray) {
        int L = startIndex;
        int R = minIndex + 1;
        int sum = 0;
        int curIndex = startIndex;
        //左边比右边大，构成逆序对
        while (L <= minIndex && R <= endIndex) {
            if (arr[L] > arr[R]) {
                sum += minIndex - L + 1;
            }
            copyArray[curIndex++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
        }

        while (L <= minIndex) {
            copyArray[curIndex++] = arr[L++];
        }

        while (R <= endIndex) {
            copyArray[curIndex++] = arr[R++];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            arr[i] = copyArray[i];
        }

        return sum;
    }

//    public static void main(String[] args) {
//        int[] arr = new int[]{0, -32};
//        System.out.println(reverseOrderNum(arr));
//    }


    // for test
    public static int comparator(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count;
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
        int maxSize = 4;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (reverseOrderNum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                System.out.println(JSONArray.toJSONString(arr2));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }



}
