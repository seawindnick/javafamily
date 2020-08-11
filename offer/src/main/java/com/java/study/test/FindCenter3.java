package com.java.study.test;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-10 08:21
 */
public class FindCenter3 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            int[] arr = nums1 == null ? nums2 : nums1;
            if ((arr.length & 1) == 1) {
                return arr[(arr.length - 1) / 2];
            } else {
                return ((double) (arr[(arr.length - 1) / 2] + arr[(arr.length - 1) / 2 + 1])) / 2;
            }
        } else {
            int totalLength = nums1.length + nums2.length;

            int num1LeftIndex = 0;
            int num2LeftIndex = 0;

            int curIndex = -1;

            //长度为奇数
            if ((totalLength & 1) == 1) {
                int centerIndex = (totalLength - 1) / 2;
                while (num1LeftIndex <= nums1.length - 1 && num2LeftIndex <= nums2.length - 1) {

                    int value = nums1[num1LeftIndex] < nums2[num2LeftIndex] ? nums1[num1LeftIndex++] : nums2[num2LeftIndex++];
                    if (++curIndex == centerIndex) {
                        return value;
                    }
                }

                while (num1LeftIndex <= nums1.length - 1) {
                    if (++curIndex == centerIndex) {
                        return nums1[num1LeftIndex++];
                    }
                    num1LeftIndex++;
                }

                while (num2LeftIndex <= nums2.length - 1) {
                    if (++curIndex == centerIndex) {
                        return nums2[num2LeftIndex++];
                    }
                    num2LeftIndex++;
                }
            } else {
                int centerLeftIndex = (totalLength - 1) / 2;
                int centerRightIndex = (totalLength - 1) / 2 + 1;

                int centerSum = 0;


                while (num1LeftIndex <= nums1.length - 1 && num2LeftIndex <= nums2.length - 1) {

                    int value = nums1[num1LeftIndex] < nums2[num2LeftIndex] ? nums1[num1LeftIndex++] : nums2[num2LeftIndex++];
                    curIndex++;
                    if (curIndex == centerLeftIndex || curIndex == centerRightIndex) {
                        centerSum += value;
                        if (curIndex == centerRightIndex) {
                            return ((double) centerSum) / 2;
                        }
                    }
                }

                while (num1LeftIndex <= nums1.length - 1) {
                    curIndex++;
                    if (curIndex == centerLeftIndex || curIndex == centerRightIndex) {
                        centerSum += nums1[num1LeftIndex];
                        if (curIndex == centerRightIndex) {
                            return ((double) centerSum) / 2;
                        }
                    }
                    num1LeftIndex++;
                }

                while (num2LeftIndex <= nums2.length - 1) {
                    curIndex++;
                    if (curIndex == centerLeftIndex || curIndex == centerRightIndex) {
                        centerSum += nums2[num2LeftIndex];
                        if (curIndex == centerRightIndex) {
                            return ((double) centerSum) / 2;
                        }
                    }
                    num2LeftIndex++;
                }
            }
        }

        return Double.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] arr = {};
        int[] brr = {1,2,3, 4,5};
        System.out.println(findMedianSortedArrays(arr, brr));
    }
}
