package com.java.study.offer.array;

import com.alibaba.fastjson.JSONArray;

public class NiXuCount {


    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 6, 4};
        int sum = calculate(arr);
        System.out.println(sum);
    }

    private static int calculate(int[] arr) {
        int[] copyArr = arr.clone();

        int count = inversePairsCore(arr, copyArr, 0, arr.length - 1);
        System.out.println(JSONArray.toJSONString(copyArr));
        return count;
    }

    private static int inversePairsCore(int[] arr, int[] copyArr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            copyArr[startIndex] = arr[startIndex];
            return 0;
        }

        int length = (endIndex - startIndex) >> 1;

        // 找到数组的中点，分割为两个子数组，递归求解
        int midIndex = startIndex + length;

        int left = inversePairsCore(arr, copyArr, startIndex, midIndex);
        int right = inversePairsCore(arr, copyArr, midIndex + 1, endIndex);

        // 从两个子数组的尾部开始遍历
        int i = midIndex;
        int j = endIndex;
        int indexCopy = endIndex;
        int count = 0;
        while (i >= startIndex && j >= midIndex + 1) {
            // 数组是升序的
            // 如果左边数组比右边数组大，则将大的放入存储数组中
            // 并且累加逆序对，应为是有序的，所以左边数组的第i个元素比第j个及其之前的数都大
            if (arr[i] > arr[j]) {
                //将较大的数据放在后面
                copyArr[indexCopy] = arr[i];
                indexCopy--;
                i--;
                count += (j - startIndex - length);
            } else {
                copyArr[indexCopy] = arr[j];
                indexCopy--;
                j--;
            }

        }
        // 将子数组剩余的部分一次写入归并后的存储数组
        for (; i >= startIndex; i--) {
            copyArr[indexCopy] = arr[i];
            indexCopy--;
        }

        for (; j >= midIndex + 1; j--) {
            copyArr[indexCopy] = arr[j];
            indexCopy--;
        }
        // 将本次两个子数组的合并写入原数组中
        for (int k = startIndex; k <= endIndex; k++) {
            arr[k] = copyArr[k];
        }
        return left + right + count;
    }
}
