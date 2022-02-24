package com.java.study.algorithm.zuo.dadvanced.advanced_class_04;

/**
 * 题目六
 * 数组中未出现的最小正整数
 * 【题目】 给定一个无序整型数组arr，找到数组中未出现的最小正整数。 【举例】
 * arr=[-1,2,3,4]。返回1。
 * arr=[1,2,3,4]。返回5。
 */
public class Code_06_SmallestMissNum {

    public static int SmallestMissNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }

        int left = 0;
        int right = arr.length;
        while (left < right) {
            // 说明可以扩进去
            if (arr[left] == left + 1) {
                left++;
            } else if (arr[left] <= left || arr[left] > right || arr[arr[left] - 1] == arr[left]) {
                /**
                 *
                 * 理想状态下，角标left位置对应的值是left+1
                 *
                 * arr[left] <= left 说明 arr[left]  的元素已经经过处理了，是重复的元素，就将right位置的元素替换到当前位置，继续进行考察，数组的右边界进行缩小
                 *
                 * arr[left] > right  说明已经超出处理的范围了，将right位置的元素替换到当前位置，继续进行考察，数组的右边界进行缩小，该元素抛弃不进行处理
                 *
                 * 如果  arr[left] > left &&  arr[left] < right && arr[left] != left+1
                 * 说明， arr[left] 对应的数据是整个数组能够处理的数据，那么就将 arr[left] 移动到 arr[left] - 1 的位置上
                 * arr[arr[left] - 1] == arr[left] 说明 arr[left] - 1 上面的元素和当前元素一致，说明有重复了，有重复了，就将right位置的元素替换到当前位置，继续进行考察，数组的右边界进行缩小
                 *
                 */
                arr[left] = arr[--right];
            } else {
                // 说明  arr[left] - 1 位置的元素和当前位置的元素不一致，进行互换
                int changeIndex = arr[left] - 1;
                int temp = arr[changeIndex];
                arr[changeIndex] = arr[left];
                arr[left] = temp;
            }

        }

        return left + 1;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1};
        System.out.println(SmallestMissNum(arr));
    }


}