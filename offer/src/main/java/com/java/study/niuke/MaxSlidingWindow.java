package com.java.study.niuke;

import com.alibaba.fastjson.JSONArray;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <Description>
 * 滑动窗口最大值
 *
 * @author hushiye
 * @since 2020-09-25 12:11
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] result = new int[nums.length - k + 1];
        int startIndex = 0;

        int index = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (index < nums.length) {
            while (!linkedList.isEmpty() && nums[index] >= nums[linkedList.peekLast()]) {
                linkedList.pollLast();
            }

            linkedList.add(index);

            //说明元素窗口内元素多于  K 个
            if (linkedList.peekFirst() == index - k) {
                linkedList.pollFirst();
            }

            if (index >= k - 1) {
                result[startIndex++] = nums[linkedList.peekFirst()];
            }

            index++;

        }

//        int left = 0;
//        int rightIndex = 0;
//        int endIndex = nums.length - 1;
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        while (rightIndex <= endIndex) {
//
//            int indexValue = nums[rightIndex];
//            while (!linkedList.isEmpty() && indexValue >= nums[linkedList.peekLast()]) {
//                linkedList.pollLast();
//            }
//
//            linkedList.add(rightIndex);
//
//            //已经到达滑动窗口的位置
//            if (rightIndex >= k - 1) {
//                result[startIndex++] = nums[linkedList.peekFirst()];
//                if (left == linkedList.peekFirst()){
//                    linkedList.pollFirst();
//                }
//                left++;
//            }
//            rightIndex ++;
//
//        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1};
        System.out.println(JSONArray.toJSONString(maxSlidingWindow(nums, 1)));
    }
}
