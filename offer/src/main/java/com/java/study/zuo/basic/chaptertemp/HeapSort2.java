package com.java.study.zuo.basic.chaptertemp;

import com.alibaba.fastjson.JSONArray;
import com.java.study.zuo.sort.ArrayUtil;

/**
 * <Description>
 *
 * @author hushiye
 * @since 3/19/21 14:50
 */
public class HeapSort2 {


    public static void heapSort2(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        int length = arr.length;
        for (int i = 0; i < length; i++) {
            heapInsert(arr, i);
        }

        int index = length;
        ArrayUtil.swap(arr, 0, --index);

        while (index > 0) {
            //调整位置是上一次位置-1
            hapfiy(arr, 0, index);
            ArrayUtil.swap(arr, 0, --index);
        }

    }

    /**
     * endIndex是边界  如果endIndex 被包含在计算内，那么就是  leftIndex + 1 > endIndex是终止条件，如果 如果endIndex 不包含在内，则leftIndex + 1 >= endIndex 是终止条件
     * @param arr
     * @param parentIndex
     * @param endIndex
     */
    private static void hapfiy(int[] arr, int parentIndex, int endIndex) {
        int leftIndex;
        while ((leftIndex = parentIndex * 2 + 1) < endIndex) {
            int targetIndex = leftIndex + 1 >= endIndex ? leftIndex : arr[leftIndex] > arr[leftIndex + 1] ? leftIndex : leftIndex + 1;
            if (arr[parentIndex] >= arr[targetIndex]) {
                return;
            }

            ArrayUtil.swap(arr, parentIndex, targetIndex);
            parentIndex = targetIndex;
        }


    }

    private static void heapInsert(int[] arr, int index) {
        int temp;
        while (arr[index] > arr[temp = (index - 1) / 2]) {
            ArrayUtil.swap(arr, temp, index);
            index = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        heapSort2(arr);
        System.out.println(JSONArray.toJSONString(arr));
    }
}
