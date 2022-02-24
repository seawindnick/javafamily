package leetCode;//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
// 示例 3：
//
//
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
//
//
// 示例 4：
//
//
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
//
//
// 示例 5：
//
//
//输入：nums1 = [2], nums2 = []
//输出：2.00000
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
//
//
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
// Related Topics 数组 二分查找 分治算法
// 👍 3854 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10004_FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{}, nums2 = new int[]{2,3};

        System.out.println(findMedianSortedArrays(nums1, nums2));


    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }

        int totalSize = nums1.length + nums2.length;
        int middleIndex = (totalSize - 1) / 2;

        int firstIndex = 0;
        int secondIndex = 0;
        int index = 0;

        Integer firstMiddleIndexValue = null;
        Integer secondMiddleIndexValue = null;

        while (firstIndex < nums1.length && secondIndex < nums2.length) {
            if (index > middleIndex + 1) {
                break;
            }

            Integer value = nums1[firstIndex] <= nums2[secondIndex] ? nums1[firstIndex++] : nums2[secondIndex++];
            if (index == middleIndex) {
                firstMiddleIndexValue = value;
            }

            if (index == middleIndex + 1) {
                secondMiddleIndexValue = value;
            }

            index++;
        }

        while (firstIndex < nums1.length) {
            if (index > middleIndex + 1) {
                break;
            }

            Integer value = nums1[firstIndex++];

            if (index == middleIndex) {
                firstMiddleIndexValue = value;
            }

            if (index == middleIndex + 1) {
                secondMiddleIndexValue = value;
            }
            index++;

        }


        while (secondIndex < nums2.length) {
            if (index > middleIndex + 1) {
                break;
            }
            Integer value = nums2[secondIndex++];

            if (index == middleIndex) {
                firstMiddleIndexValue = value;
            }

            if (index == middleIndex + 1) {
                secondMiddleIndexValue = value;
            }
            index++;
        }

        return (totalSize & 1) == 0 ? (double)(firstMiddleIndexValue + secondMiddleIndexValue) / 2 : firstMiddleIndexValue;
    }

}

