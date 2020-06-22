package com.java.study.offer.chapter5;

public class FindMinIndex {

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,3,1,2};
        int result = findMinIndex(arr);
        System.out.println(result);
    }

    private static int findMinIndex(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int midIndex = startIndex;

        while (arr[startIndex] >= arr[endIndex]){
            if (endIndex - startIndex == 1){
                midIndex = endIndex;
                break;
            }

            midIndex = (startIndex + endIndex)/2;

            if (arr[startIndex] == arr[midIndex] && arr[midIndex] == arr[endIndex]){
                return minInIndex(arr, startIndex, endIndex);
            }

            if (arr[midIndex] >= arr[startIndex]){
                startIndex = midIndex;
            }else {
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
