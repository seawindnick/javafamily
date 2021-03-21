package com.java.study.zuo.basic.chaptertemp;

import com.java.study.zuo.sort.ArrayUtil;

/**
 * <Description>
 *
 * @author hushiye
 * @since 3/17/21 00:06
 */
public class ChooseSort {

    public static void choseSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }

            ArrayUtil.swap(arr, i, minIndex);
        }
    }
}
