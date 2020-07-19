package com.java.study.offer.array;

public class CalculateShowCount {

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        Integer count = calculateShowCountHalf(arr, 1);
//        Integer count = calculateShowCount(arr, 3);
        System.out.println(count);
    }

    private static Integer calculateShowCountHalf(int[] arr, int targetValue) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Integer firstKeyIndex = findFirstKeyIndex(arr, targetValue);

        if (firstKeyIndex == null) {
            return 0;
        }


        Integer lastKeyIndex = findLastKeyIndex(arr, targetValue);

        return lastKeyIndex - firstKeyIndex + 1;

    }

    private static Integer findLastKeyIndex(int[] arr, int targetValue) {
        int midIndex = 0;
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            midIndex = (startIndex + endIndex) >> 1;
            if (arr[midIndex] == targetValue && (midIndex == arr.length - 1 || arr[midIndex + 1] != targetValue)) {
                return midIndex;
            }

            if (arr[midIndex] > targetValue) {
                endIndex = midIndex - 1;
                continue;
            }
            startIndex = midIndex + 1;

        }

        return null;
    }

    private static Integer findFirstKeyIndex(int[] arr, int targetValue) {
        int midIndex = 0;
        int startIndex = 0;

        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            midIndex = (startIndex + endIndex) >> 1;
            if (arr[midIndex] == targetValue && (midIndex == 0 || arr[midIndex - 1] != targetValue)) {
                return midIndex;
            }

            if (arr[midIndex] < targetValue) {
                startIndex = midIndex + 1;
                continue;
            }

            endIndex = midIndex - 1;
        }
        return null;
    }

//    private static Integer calculateShowCount(int[] arr, int targetValue) {
//        if (arr == null || arr.length == 0) {
//            return 0;
//        }
//
//
//        Integer index = findTargetValueIndex(arr, targetValue);
//        if (index == null) {
//            return 0;
//        }
//
//        int count = 1;
//        int leftIndex = index - 1;
//        while (leftIndex >= 0 && arr[leftIndex] == targetValue) {
//            count++;
//            leftIndex--;
//        }
//
//        int rigthIndex = index + 1;
//        while (rigthIndex < arr.length && arr[rigthIndex] == targetValue) {
//            count++;
//            rigthIndex++;
//        }
//
//        return count;
//    }
//
//    private static Integer findTargetValueIndex(int[] arr, int targetValue) {
//
//        int startIndex = 0;
//        int endIndex = arr.length - 1;
//        int midIndex;
//
//        while (startIndex <= endIndex) {
//            midIndex = (startIndex + endIndex) >> 1;
//
//            if (arr[midIndex] == targetValue) {
//                return midIndex;
//            }
//
//            if (arr[midIndex] > targetValue) {
//                endIndex = midIndex - 1;
//            }
//
//            if (arr[midIndex] < targetValue) {
//                startIndex = midIndex + 1;
//            }
//        }
//
//        return null;
//    }


}
