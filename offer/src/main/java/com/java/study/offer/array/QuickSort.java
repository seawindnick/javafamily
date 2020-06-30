package com.java.study.offer.array;

import com.alibaba.fastjson.JSONArray;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{6,7,4,3,2,9,8,1};
        sort(array, 0, array.length - 1);
        System.out.println(JSONArray.toJSONString(array));

    }

    private static void sort(int[] array, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return;
        }

        int left = beginIndex;
        int right = endIndex;
        int checkValue = array[beginIndex];
        while (left < right) {
            while (left < right && array[right] >= checkValue) {
                right--;
            }

            array[left] = array[right];
            while (left < right && array[left] <= checkValue) {
                left++;
            }
            array[right] = array[left];

        }

        array[left] = checkValue;
        sort(array, beginIndex, left - 1);
        sort(array, left + 1, endIndex);


    }

}
