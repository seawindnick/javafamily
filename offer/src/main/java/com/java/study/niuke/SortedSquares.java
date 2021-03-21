package com.java.study.niuke;

import com.alibaba.fastjson.JSONArray;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-10-16 15:37
 */
public class SortedSquares {

    public static int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        int leftIndex = 0;
        int rightIndex = A.length - 1;
        int[] target = new int[A.length];
        int targetIndex = target.length - 1;
        while (leftIndex <= rightIndex) {
            int leftValue = A[leftIndex] * A[leftIndex];
            int rightValue = A[rightIndex] * A[rightIndex];
            if (leftValue > rightValue) {
                target[targetIndex--] = leftValue;
                leftIndex++;
            } else {
                target[targetIndex--] = rightValue;
                rightIndex--;
            }
        }

        return target;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{-7,-3,2,3,11};
        System.out.println(JSONArray.toJSONString(sortedSquares(arr)));
    }
}
