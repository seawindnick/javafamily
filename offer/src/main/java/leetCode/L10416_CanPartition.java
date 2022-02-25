package leetCode;//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//
// 示例 2：
//
//
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
// Related Topics 数组 动态规划
// 👍 886 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10416_CanPartition {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 21, 5}));
    }

    public static boolean canPartition(int[] nums) {

        //问题等价于 从nums数组中能够提取几个元素 组成和为 sum(nums)/2
        if (nums == null || nums.length == 0) {
            return true;
        }

        int sum = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            maxValue = Math.max(maxValue,nums[index]);
        }
        int targetValue = sum / 2;
        if ((sum & 1) == 1 || maxValue > targetValue) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length][targetValue + 1];
        dp[0][0] = true;
        for (int index = 0; index < nums.length; index++) {
            dp[index][nums[index]] = true;
        }


        for (int columnIndex = 1; columnIndex < dp.length; columnIndex++) {
            for (int value = 0; value < dp[0].length; value++) {
                dp[columnIndex][value] = dp[columnIndex - 1][value];
                if (value - nums[columnIndex] >= 0) {
                    dp[columnIndex][value] = dp[columnIndex][value] || dp[columnIndex - 1][value - nums[columnIndex]];
                }

            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

//
//
//
//        boolean[] dp = new boolean[targetValue + 1];
//        dp[0] = true;
//        for (int value = 0; value < targetValue; value++) {
//            for (int numIndex = 0; numIndex < nums.length; numIndex++) {
//                if (value < nums[numIndex]) {
//                    continue;
//                }
//
//                if (dp[value - nums[numIndex]]) {
//                    dp[value] = true;
//                    break;
//                }
//            }
//
//        }
//
//        return dp[targetValue];
    }
}


