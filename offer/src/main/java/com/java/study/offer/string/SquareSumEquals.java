package com.java.study.offer.string;

import com.alibaba.fastjson.JSONArray;

public class SquareSumEquals {

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 2, 3, 3};
        permutation(array);
    }

    private static void permutation(int[] array) {
        combine(array, 0);
    }

    private static Boolean combine(int[] array, int beginIndex) {
        if (beginIndex >= array.length) {
            Boolean flag = checkTarget(array);
            return flag;
        }

        for (int i = beginIndex; i < array.length; i++) {

            Boolean flag = combine(array, beginIndex + 1);
            if (flag) {
                return Boolean.TRUE;
            }
            //数据还原
            swap(array,beginIndex,i);
        }
        return Boolean.FALSE;
    }

    private static void swap(int[] array, int beginIndex, int index) {
        int temp = array[beginIndex];
        array[beginIndex] = array[index];
        array[index] = temp;
    }

    private static Boolean checkTarget(int[] array) {
        int r1 = array[0] + array[1] + array[2] + array[3];
        int r2 = array[4] + array[5] + array[6] + array[7];
        int r3 = array[0] + array[2] + array[4] + array[6];
        int r4 = array[1] + array[3] + array[5] + array[7];
        int r5 = array[0] + array[1] + array[4] + array[5];
        int r6 = array[2] + array[3] + array[6] + array[7];

        if (r1 == r2 && r3 == r4 && r5 == r6){
            System.out.println(JSONArray.toJSONString(array));
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
