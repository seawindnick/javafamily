package com.java.study;

/**
 * <Description>
 *
 * @author hushiye
 * @since 8/6/21 11:04
 */

import com.alibaba.fastjson.JSONArray;

/**
 * //老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * //
 * // 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * //
 * //
 * // 每个孩子至少分配到 1 个糖果。
 * // 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * //
 * //
 * // 那么这样下来，老师至少需要准备多少颗糖果呢？
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：[1,0,2]
 * //输出：5
 * //解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：[1,2,2]
 * //输出：4
 * //解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * //     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * // Related Topics 贪心 数组
 */
public class FenTangGuo {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 6, 4, 4, 3, 6, 7, 1};
        System.out.println(candy(arr));
        System.out.println(candy2(arr));
    }


    public static int candy2(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }

        int[] leftArray = new int[ratings.length];

        int[] rightArray = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            leftArray[i] = 1;
            rightArray[i] = 1;
        }


        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftArray[i] = leftArray[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightArray[i] = rightArray[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(leftArray[i], rightArray[i]);
        }
        return sum;
    }

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }

        int[] targetArr = new int[ratings.length];
        int startIndex = 0;
        int endIndex = ratings.length - 1;
        int preMindex = -1;
        handle(ratings, targetArr, startIndex, endIndex, preMindex);
        System.out.println(JSONArray.toJSONString(targetArr));
        int num = 0;
        for (int i : targetArr) {
            num += i;
        }
        return num;
    }

    private static void handle(int[] ratings, int[] targetArr, int startIndex, int endIndex, int preMindex) {
        if (startIndex > endIndex) {
            return;
        }

        int minIndex = startIndex;
        for (int i = minIndex + 1; i <= endIndex; i++) {
            if (ratings[i] < ratings[minIndex]) {
                minIndex = i;
            }
        }

        if (preMindex == -1) {
            targetArr[minIndex] = 1;
        } else {
            //如果相邻，比较和左边/右边 的值是否相等，如果相等，再和右边/左边的进行比较值大小，如果大于，则取左边相邻的数据+1，否则取左边的数据
            // 如果不想等，取左边/右边最大值+1

            int minLeft = minIndex - 1;
            int minRight = minIndex + 1;
            boolean minIndexLeftOver = minIndex - 1 < 0;
            boolean minIndexRightOver = minIndex + 1 >= ratings.length;

            //说明此时minIndex是位置最小的
            if (minIndexLeftOver) {
                targetArr[minIndex] = ratings[minIndex] > ratings[minRight] ? targetArr[minRight] + 1 : 1;
            } else if (minIndexRightOver) {
                targetArr[minIndex] = ratings[minIndex] > ratings[minLeft] ? targetArr[minLeft] + 1 : 1;
            } else {
                if (ratings[minLeft] < ratings[minIndex] && ratings[minRight] < ratings[minIndex]) {
                    targetArr[minIndex] = Math.max(targetArr[minLeft], targetArr[minRight]) + 1;
                } else if (ratings[minLeft] < ratings[minIndex]) {
                    targetArr[minIndex] = targetArr[minLeft] + 1;
                } else if (ratings[minRight] < ratings[minIndex]) {
                    targetArr[minIndex] = targetArr[minRight] + 1;
                } else {
                    targetArr[minIndex] = 1;
                }


            }
        }

        handle(ratings, targetArr, startIndex, minIndex - 1, minIndex);
        handle(ratings, targetArr, minIndex + 1, endIndex, minIndex);
    }


}
