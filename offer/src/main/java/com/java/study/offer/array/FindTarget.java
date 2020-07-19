package com.java.study.offer.array;

import com.alibaba.fastjson.JSONArray;

public class FindTarget {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int[] targetValue = findTarget(arr,11);
        System.out.println(JSONArray.toJSONString(targetValue));
    }

    private static int[] findTarget(int[] arr,int target) {
        if (arr == null || arr.length < 2){
            return null;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex < endIndex){
            int value = arr[startIndex] + arr[endIndex];
            if (value == target){
                int[] values = new int[]{arr[startIndex],arr[endIndex]};
                return values;
            }

            if (value > target){
                endIndex --;
            }
            if (value < target){
                startIndex ++;
            }
        }

        return null;
    }
}
