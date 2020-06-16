package com.java.study.offer.chapter5;

public class FindIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,0,1};
        int targetArr = findMinIndex(arr);
        System.out.println(targetArr);
    }

    private static int findMinIndex(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        //用于避免移动0个元素到数组结尾，此时最小的元素在首位
        int midIndex = startIndex;

        while (arr[startIndex] >= arr[endIndex]) {
            if (endIndex - startIndex == 1) {
                midIndex = endIndex;
                break;
            }

            midIndex = (startIndex + endIndex) / 2;

            if (arr[midIndex] == arr[startIndex] && arr[midIndex] == arr[endIndex]) {
                return minInIndex(arr, startIndex, endIndex);
            }


            if (arr[midIndex] >= arr[startIndex]) {
                startIndex = midIndex;
            } else {
                endIndex = midIndex;
            }
        }
        return arr[midIndex];


    }

    private static int minInIndex(int[] arr, int startIndex, int endIndex) {
        int result = arr[startIndex];

        for (int i = startIndex + 1; i <= endIndex; i++) {
            result = Math.min(result, arr[i]);
        }
        return result;
    }


}
