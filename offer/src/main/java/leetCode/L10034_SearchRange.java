package leetCode;//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums 是一个非递减数组
// -109 <= target <= 109
//
// Related Topics 数组 二分查找
// 👍 1137 👎 0


import com.alibaba.fastjson.JSONArray;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10034_SearchRange {
    public static void main(String[] args) {
        int[] array = new int[]{5,7,7,8,8,10};
        System.out.println(JSONArray.toJSONString(searchRange(array,8)));
    }

    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length <= 0) {
            return new int[]{-1, -1};
        }

        int leftIndex = searchLeftIndex(nums, target);
        int rightIndex = searchRightIndex(nums, target);

        return new int[]{leftIndex, rightIndex};
    }

    private static int searchRightIndex(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        Integer index = -1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (nums[midIndex] < target) {
                leftIndex = midIndex + 1;
                continue;
            }

            if (nums[midIndex] > target) {
                rightIndex = midIndex - 1;
                continue;
            }

            if (nums[midIndex] == target) {
                index = midIndex;
                if (midIndex != nums.length - 1 && nums[midIndex] == nums[midIndex + 1]) {
                    leftIndex = leftIndex + 1;
                }else {
                    break;
                }
            }
        }

        return index;

    }

    private static int searchLeftIndex(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        Integer index = -1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (nums[midIndex] < target) {
                leftIndex = midIndex + 1;
                continue;
            }

            if (nums[midIndex] > target) {
                rightIndex = midIndex - 1;
                continue;
            }

            if (nums[midIndex] == target) {
                index = midIndex;
                if (midIndex != 0 && nums[midIndex] == nums[midIndex - 1]) {
                    rightIndex = midIndex - 1;
                }else {
                    break;
                }
            }


        }

        return index;
    }
}


