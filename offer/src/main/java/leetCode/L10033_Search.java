package leetCode;//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//
// 示例 3：
//
//
//输入：nums = [1], target = 0
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都 独一无二
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转
// -10^4 <= target <= 10^4
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
// Related Topics 数组 二分查找
// 👍 1496 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10033_Search {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1};
        System.out.println(search(arr, 1));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }


        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int centerIndex = (rightIndex + leftIndex) / 2;
            if (nums[centerIndex] == target) {
                return centerIndex;
            }

            //左侧升序
            if (nums[0] <= nums[centerIndex]) {
                if (nums[0] <= target && nums[centerIndex] > target) {
                    rightIndex = centerIndex - 1;
                } else {
                    leftIndex = centerIndex + 1;
                }
            } else {
                //右侧升序
                if (nums[centerIndex] < target && target <= nums[nums.length - 1]) {
                    leftIndex = centerIndex + 1;
                } else {
                    rightIndex = centerIndex - 1;
                }
            }




//
//            while (l <= r) {
//                int mid = (l + r) / 2;
//                if (nums[mid] == target) return mid;
//                if (nums[0] <= nums[mid]) {
//                    if (nums[0] <= target && target < nums[mid]) {
//                        r = mid - 1;
//                    } else {
//                        l = mid + 1;
//                    }
//                } else {
//                    if (nums[mid] < target && target <= nums[n - 1]) {
//                        l = mid + 1;
//                    } else {
//                        r = mid - 1;
//                    }
//                }
//            }
//            return -1;
//        }

        }


//        while (leftIndex <= rightIndex) {
//            int centerIndex = leftIndex + (rightIndex - leftIndex) / 2;
//            if (nums[centerIndex] == target) {
//                return centerIndex;
//            }
//
//            //左边是升序数组
//            if (nums[leftIndex] < nums[centerIndex]) {
//                if (nums[centerIndex] > target && nums[leftIndex] <= target) {
//                    rightIndex = centerIndex - 1;
//                } else {
//                    leftIndex = centerIndex + 1;
//                }
//            } else {
//                //右边是升序数组
//                if (nums[centerIndex] < target && nums[rightIndex] >= nums[centerIndex]) {
//                    leftIndex = centerIndex + 1;
//                } else {
//                    rightIndex = centerIndex - 1;
//                }
//
//            }
//
//        }

        return -1;

    }
}

