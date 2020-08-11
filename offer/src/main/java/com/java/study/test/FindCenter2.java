package com.java.study.test;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-09 12:03
 */
public class FindCenter2 {


    public static double getCenter(int[] nums1, int[] nums2) {

        int[] totalArray = null;

        if (nums1 == null) {
            totalArray = nums2;
        } else if (nums2 == null) {
            totalArray = nums1;
        } else {

            totalArray = new int[nums1.length + nums2.length];

            int aStartIndex = 0;
            int aEndIndex = nums1.length - 1;

            int bStartIndex = 0;
            int bEndIndex = nums2.length - 1;

            int curIndex = 0;
            while (aStartIndex <= aEndIndex && bStartIndex <= bEndIndex && curIndex <= (totalArray.length / 2 + 1)) {
                totalArray[curIndex++] = nums1[aStartIndex] < nums2[bStartIndex] ? nums1[aStartIndex++] : nums2[bStartIndex++];
            }

            while (aStartIndex <= aEndIndex) {
                totalArray[curIndex++] = nums1[aStartIndex++];
            }

            while (bStartIndex <= bEndIndex) {
                totalArray[curIndex++] = nums2[bStartIndex++];
            }
        }

        if ((totalArray.length & 1) == 1) {
            return totalArray[(totalArray.length - 1) / 2];
        }

        return ((double) (totalArray[(totalArray.length - 1) / 2] + totalArray[(totalArray.length - 1) / 2 + 1])) / 2;

    }

    private static double calculateCenter(int[] array) {
        if ((array.length & 1) == 1) {
            return array[(array.length - 1) / 2];
        }

        return ((double) (array[(array.length - 1) / 2] + array[(array.length - 1) / 2 + 1])) / 2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        int[] brr = {3, 4};
        System.out.println(getCenter(arr, brr));
    }
}
