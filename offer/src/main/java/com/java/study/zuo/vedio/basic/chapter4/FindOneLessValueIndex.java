package com.java.study.zuo.vedio.basic.chapter4;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-26 21:17
 */
public class FindOneLessValueIndex {


    public static int findOneLessValueIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }


        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int startIndex = 1;
        int endIndex = arr.length - 2;
        int mid = 0;
        while (startIndex < endIndex) {
            mid = startIndex + (endIndex - startIndex) / 2;
            if (arr[mid] > arr[mid - 1]) {
                endIndex = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                startIndex = mid + 1;
            } else {
                return mid;
            }

        }
        return startIndex;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1, 7};
        System.out.println(findOneLessValueIndex(arr));
    }


}
