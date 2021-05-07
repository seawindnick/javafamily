package com.java.study.algorithm.zuo.dadvanced.advanced_class_03;

/**
 * 在有序但含有空的数组中查找字符串
 * 【题目】
 * 给定一个字符串数组strs[]，
 * 在strs中有些位置为null，但在不为null的位置上，
 * 其字 符串是按照字典顺序由小到大依次出现的。
 * 再给定一个字符串str，请返回str在strs中 出现的最左的位置。
 * 【举例】
 * strs=[null,"a",null,"a",null,"b",null,"c"]，str="a"，返回1。
 * strs=[null,"a",null,"a",null,"b",null,"c"]，str=null，只要str为null，就返回-1
 * strs=[null,"a",null,"a",null,"b",null,"c"]，str="d"，返回-1。
 */

/**
 * 字典序，二分
 * <p>
 * 遇空如何处理？判断往左数第一个位置，和往右数第一个位置元素，确定向左走还是向右走
 * 如果确保出现在最左位置的元素？如果相等的话，继续向左或者向右，start或者 end是该元素的位置
 */
public class Code_05_FindStringInContainsNullArray {

    public static int FindStringInContainsNullArray(String[] arr, String target) {

        if (target == null) {
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (arr[midIndex] == null) {
                //获取左Index
                int leftNonNullIndex = getLeftNonNullIndex(arr, midIndex);
                if (leftNonNullIndex != -1) {
                    if (arr[leftNonNullIndex].compareTo(target) < 0) {
                        leftIndex = leftNonNullIndex + 1;
                    } else {
                        rightIndex = leftNonNullIndex - 1;
                    }
                    continue;
                }
                //获取右非空Index
                int rightNonNullIndex = getRightNonNullIndex(arr, midIndex);
                if (rightNonNullIndex == -1 || arr[rightNonNullIndex].compareTo(target) < 0) {
                    leftIndex = rightNonNullIndex + 1;
                } else {
                    return -1;
                }

            } else {
                if (arr[midIndex].compareTo(target) >= 0) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            }

        }

        if (target.equals(arr[leftIndex + 1])) {
            return leftIndex + 1;
        }
        return -1;


    }

    private static int getRightNonNullIndex(String[] arr, int midIndex) {
        for (int i = midIndex + 1; i < arr.length; i++) {
            if (arr[i] != null) {
                return i;
            }
        }
        return -1;
    }

    private static int getLeftNonNullIndex(String[] arr, int midIndex) {
        for (int i = midIndex - 1; i >= 0; i--) {
            if (arr[i] != null) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{null, "a", null, "a", null, "b", null, "c"};
        System.out.println(FindStringInContainsNullArray(arr, "d"));
    }


}