package com.java.study.offer.array;

import com.alibaba.fastjson.JSONArray;

public class MinNum {
    public static void main(String[] args) {
        int[] arr = new int[]{24, 3, 5, 0, 1};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(JSONArray.toJSONString(arr));

    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex){
            return;
        }

        int startValue = arr[startIndex];
        int leftIndex = startIndex;
        int rightIndex = endIndex;

        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && !isSmall(String.valueOf(arr[rightIndex]), String.valueOf(startValue))) {
                rightIndex--;
            }

            arr[leftIndex] = arr[rightIndex];

            while (leftIndex < rightIndex && isSmall(String.valueOf(arr[leftIndex]), String.valueOf(startValue))) {
                leftIndex++;
            }

            arr[rightIndex] = arr[leftIndex];
        }

        arr[leftIndex] = startValue;
        quickSort(arr, startIndex, leftIndex - 1);
        quickSort(arr, leftIndex + 1, endIndex);

    }

    private static boolean isSmall(String checkValue, String targetValue) {

        String checkLeftValue = checkValue + targetValue;
        String checkRightValue = targetValue + checkValue;

        int len = checkLeftValue.length();
        for (int i = 0; i < len; i++) {
            if (checkLeftValue.charAt(i) == checkRightValue.charAt(i)) {
                continue;
            }
            return checkLeftValue.charAt(i) < checkRightValue.charAt(i);
        }

        return true;

    }

//    private static void printMinNumber(int[] arr, int leftIndex, int rightIndex) {
//        System.out.println(leftIndex + "------" + rightIndex);
//        if (leftIndex < rightIndex) {
//            int mainNumber = arr[rightIndex];
//            int smallIndex = leftIndex;
//
//            for (int i = leftIndex; i < rightIndex; i++) {
//                if (isSmall(String.valueOf(arr[i]), String.valueOf(mainNumber))) {
//                    swap(arr, i, smallIndex);
//                    smallIndex++;
//                }
//            }
//
//            arr[rightIndex] = arr[smallIndex];
//            arr[smallIndex] = mainNumber;
//            printMinNumber(arr, 0, smallIndex - 1);
//            printMinNumber(arr, smallIndex + 1, rightIndex);
//        }
//
//    }
//
//    private static void swap(int[] arr, int i, int smallIndex) {
//        int temp = arr[i];
//        arr[i] = arr[smallIndex];
//        arr[smallIndex] = temp;
//    }
//
//    private static boolean isSmall(String m, String n) {
//        String left = m + n;
//        String right = n + m;
//        for (int i = 0; i < left.length(); i++) {
//            if (left.charAt(i) == right.charAt(i)) {
//                continue;
//            }
//            return left.charAt(i) < right.charAt(i);
//        }
//        return Boolean.FALSE;
//    }


//    private static String findMinStr(int[] arr) {
//        if (arr == null || arr.length == 0){
//            return "";
//        }
//
//        int len = arr.length;
//        String[] str = new String[len];
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (int i = 0; i < len ; i++) {
//            str[i] = String.valueOf(arr[i]);
//
//        }
//
//        Arrays.sort(str, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String c1 = o1 + o2;
//                String c2 = o2 + o1;
//                return c1.compareTo(c2);
//            }
//        });
//
//        for (int i = 0; i < len; i++) {
//            stringBuilder.append(str[i]);
//        }
//        System.out.println(stringBuilder.toString());
//        return stringBuilder.toString();
//
//    }

//    private static String findMinStr(int[] arr) {
//        qucikSortArr(arr, 0, arr.length - 1);
//        System.out.println(JSONArray.toJSONString(arr));
//        return null;
//    }
//
//    private static void qucikSortArr(int[] arr, int startIndex, int endIndex) {
//        if (arr == null || arr.length == 0 || startIndex > endIndex) {
//            return;
//        }
//
//        int startValue = arr[startIndex];
//        int leftIndex = startIndex;
//        int rightIndex = endIndex;
//        while (leftIndex < rightIndex) {
//            while (leftIndex < rightIndex && arr[rightIndex] >= startValue) {
//                rightIndex--;
//            }
//
//            arr[leftIndex] = arr[rightIndex];
//
//
//            while (leftIndex < rightIndex && arr[leftIndex] <= startValue) {
//                leftIndex++;
//            }
//            arr[rightIndex] = arr[leftIndex];
//        }
//
//        arr[leftIndex] = startValue;
//        qucikSortArr(arr, startIndex, leftIndex - 1);
//        qucikSortArr(arr, leftIndex + 1, endIndex);
//
//
//    }
}
