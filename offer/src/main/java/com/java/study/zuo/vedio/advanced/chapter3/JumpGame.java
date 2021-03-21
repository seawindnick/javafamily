package com.java.study.zuo.vedio.advanced.chapter3;

/**
 * <Description>
 * 【题目】 给定数组arr，arr[i]==k代表可以从位置i向右跳1~k个距离。
 * 比如，arr[2]==3，代表从位置2可以跳到位置3、位置4或位置5。
 * 如果从位置0出发，返回最少跳几次能跳到arr最后的位置上。
 * 【举例】
 * arr=[3,2,3,1,1,4]。
 * arr[0]==3，选择跳到位置2;
 * arr[2]==3，可以跳到最后的位置。 所以返回2。
 * 【要求】 如果arr长度为N，要求实现时间复杂度为O(N)、额外空间复杂 度为O(1)的方法。
 *
 * @author hushiye
 * @since 2020-09-08 17:41
 */
public class JumpGame {

    public static int jumpGame(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }

        int cur = 0;
        int next = 0;
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (cur < next){
                sum++;
                cur = next;
            }
            next = Math.max(next,i+arr[i]);

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,1,1,1,7,1,1,1,1,5,1,1,1,1,1,1};
        System.out.println(jumpGame(arr));
    }
}
