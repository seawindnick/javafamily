package leetCode;//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。
//
//
// 示例 1：
//
//
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,0,3,2,3]
//输出：4
//
//
// 示例 3：
//
//
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2500
// -104 <= nums[i] <= 104
//
//
//
//
// 进阶：
//
//
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
//
// Related Topics 数组 二分查找 动态规划
// 👍 1774 👎 0


import com.alibaba.fastjson.JSONArray;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10300_LengthOfLIS {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxValue = 1;
        for (int index = 1; index < nums.length; index++) {
            dp[index] = 1;
            for (int cutIndex = 0; cutIndex <= index; cutIndex++) {
                if (nums[index] > nums[cutIndex]) {
                    dp[index] = Math.max(dp[index], dp[cutIndex] + 1);
                }
            }
            maxValue = Math.max(maxValue, dp[index]);
            System.out.println(JSONArray.toJSONString(dp));
        }
        return maxValue;
    }
}


