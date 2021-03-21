package com.java.study.zuo.basic.chaptertemp;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

/**
 * <Description>
 *
 * @author hushiye
 * @since 3/16/21 23:46
 */
public class ChaRuSort {



    public static void chaRuSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j > 0 && arr[j] <= arr[j - 1]; j--) {
//                ArrayUtil.swap(arr, j, j - 1);
//            }
//        }

        //第一张牌本来就是有序的，从第二张牌开始，已经排好序的牌与前面的一张牌进行比较，如果大于，发生置换
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] >= arr[j + 1]; j--) {
                ArrayUtil.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{34, 60, 50, -12, 50};
        chaRuSort(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }
}
