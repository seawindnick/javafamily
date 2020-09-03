package com.java.study.zuo.vedio.basic.chapter8;

import com.alibaba.fastjson.JSONArray;

import java.util.LinkedList;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-28 21:07
 */
public class SlidingWindowMaxArray {


    public static int[] slidingWindowMaxArray(int[] arr, int w) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int cutIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            //将小于或者等于当前值的数据 从尾部开始弹出
            while (!linkedList.isEmpty() && arr[i] > linkedList.peekLast()) {
                linkedList.pollLast();
            }
            //将元素加入集合末尾
            linkedList.add(i);
            // i-w == linkedList.peekFirst()  意味着 linkedList.peekFirst() 元素在 [] 边界处，下一次进行移动，需要将该节点删除
            if (linkedList.peekFirst() == i - w) {
                linkedList.pollFirst();
            }

            //i >= w - 1 意味着[]中已经存在 w个元素了，就可以向结果数据中添加对应的值
            if (i >= w - 1) {
                result[cutIndex++] = arr[linkedList.peekFirst()];
            }
        }
        return result;
    }

//    public static int[] slidingWindowMaxArray(int[] arr, int m) {
//        if (arr == null || arr.length == 0) {
//            return new int[]{};
//        }
//
//        int[] result = new int[arr.length - m + 1];
//
//        LinkedList<Integer> deque = new LinkedList<Integer>();
//
//        int curIndex = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            if (i < m) {
//                appendElement(arr, deque, i);
//                continue;
//            }
//
//            int firstIndex = deque.getFirst();
//            result[curIndex++] = arr[firstIndex];
//            if (firstIndex == (i - m)) {
//                deque.removeFirst();
//            }
//            appendElement(arr, deque, i);
//        }
//        result[curIndex++] = arr[deque.getFirst()];
//        return result;
//
//    }
//
//    private static void appendElement(int[] arr, Deque<Integer> deque, int i) {
//        if (deque.size() == 0) {
//            deque.add(i);
//        }
//
//        while (deque.size() != 0 && arr[deque.getLast()] <= arr[i]) {
//            deque.removeLast();
//        }
//        deque.add(i);
//    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] result = slidingWindowMaxArray(arr, 3);
        System.out.println(JSONArray.toJSONString(result));
    }
}
