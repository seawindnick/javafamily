package com.java.study.offer.chapter5;

import com.alibaba.fastjson.JSONArray;

public class AgeSort {

    public static void main(String[] args) {
        int[] age = new int[]{50, 24, 21, 23, 45, 7, 32, 23, 45, 65};
        int[] sortAge = sortAge(age);
        System.out.println(JSONArray.toJSONString(sortAge));
    }

    private static int[] sortAge(int[] ageArray) {
        int oldestAge = 99;
        int[] timesOfAge = new int[oldestAge + 1];
        for (int i = 0; i < timesOfAge.length; i++) {
            timesOfAge[i] = 0;
        }


        for (int i : ageArray) {
            if (i < 0 || i > oldestAge) {
                throw new RuntimeException("年龄超出范围");
            }
            timesOfAge[i] = timesOfAge[i] + 1;
        }

        int index = 0;
        for (int i = 0; i < oldestAge; i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                ageArray[index] = i;
                index++;
            }
        }
        return ageArray;
    }
}
