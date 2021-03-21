package com.java.study.zuo.vedio.advanced.chapter5;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-15 11:46
 */
public class MissingNumber {

    public static int missingNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;
        int midIndex = 0;
        while (left <= right) {
            midIndex = left + (right - left) / 2;
            if (midIndex == arr[midIndex]) {
                left = midIndex + 1;
            } else {
                right = midIndex - 1;
            }
        }

        return left;
    }

    public static int missingNumber1(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1,2,3,4,5,7,8,9};
        System.out.println(missingNumber(arr));
        System.out.println(missingNumber1(arr));
    }
}
