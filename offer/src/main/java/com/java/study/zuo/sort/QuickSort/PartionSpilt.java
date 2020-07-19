package com.java.study.zuo.sort.QuickSort;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

/**
 * 将一个数组中小于num的数据放在左边，大于num的数据放在右边
 */
public class PartionSpilt {


    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 7, 2, 3, 0, 10, 5, 7};
        partionSpilt(arr, 2);
        System.out.println(JSONArray.toJSONString(arr));

    }

    public static void partionSpilt(int[] arr, int number) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int lessIndex = -1;
        int startIndex = 0;
        while (startIndex < arr.length - 1) {
            if (arr[startIndex] < number) {
                ArrayUtil.swap(arr, ++lessIndex, startIndex);
            }
            startIndex++;

        }

    }


}
