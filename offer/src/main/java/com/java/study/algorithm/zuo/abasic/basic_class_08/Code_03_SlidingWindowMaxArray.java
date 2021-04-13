package com.java.study.algorithm.zuo.abasic.basic_class_08;

import com.alibaba.fastjson.JSONArray;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 * 【题目】 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个 位置。
 * 例如，数组为[4,3,5,4,3,3,6,7]，窗口大小为3时:
 * [435]43367   窗口中最大值为5
 * 4[354]3367   窗口中最大值为5
 * 43[543]367   窗口中最大值为5
 * 435[433]67   窗口中最大值为4
 * 4354[336]7   窗口中最大值为6
 * 43543[367]   窗口中最大值为7
 * <p>
 * 如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。
 * 请实现一个函数。
 * 输入:整型数组arr，窗口大小为w。 输出:一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。
 * 以本题为例，结果应该返回{5,5,5,4,6,7}。
 */
public class Code_03_SlidingWindowMaxArray {

    public static int[] SlidingWindowMaxArray(int[] arr, int m) {
        if (arr == null || arr.length < m) {
            return new int[]{};
        }

        int[] result = new int[arr.length - m + 1];
        int index = 0;

        LinkedList<Integer> linkedList = new LinkedList();

        for (int i = 0; i < arr.length; i++) {
            while (!linkedList.isEmpty() && arr[i] >= arr[linkedList.getLast()]) {
                linkedList.pollLast();
            }

            linkedList.addLast(i);
            //处理完成之后，立即将要过期的元素刨除
            if (i >= m - 1) {
                result[index++] = arr[linkedList.peekFirst()];
                if (i - (m - 1) == linkedList.peekFirst()) {
                    linkedList.pollFirst();
                }

            }
//
//            下一次执行时，才刨除无效的元素
//            if (i - m == linkedList.peekFirst()) {
//                linkedList.pollFirst();
//            }
//
//            if (i >= m - 1) {
//                result[index++] = arr[linkedList.peekFirst()];
//            }
        }
        return result;
    }

//    while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
//        qmax.pollLast();
//    }
//			qmax.addLast(i);
//			if (qmax.peekFirst() == i - w) {
//        qmax.pollFirst();
//    }
//			if (i >= w - 1) {
//        res[index++] = arr[qmax.peekFirst()];
//    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 4, 3, 3, 6, 7};
        int[] result = SlidingWindowMaxArray(arr, 3);
        System.out.println(JSONArray.toJSONString(result));
    }
}