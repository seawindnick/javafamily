package leetCode;//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
// 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
// 如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//
//
// 示例 1：
//
//
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
// 示例 2：
//
//
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
// Related Topics 数组 动态规划
// 👍 1585 👎 0


import java.sql.ResultSet;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10198_Rob {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{4, 1, 1, 9}));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for (int index = 2; index < nums.length; index++) {
            dp[index] = Math.max(dp[index - 2] + nums[index], dp[index - 1]);
        }
        return dp[nums.length - 1];


//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        if (nums.length == 1){
//            return nums[0];
//        }
//
//
//        Result[] dp = new Result[nums.length];
//        Result result = new Result();
//        result.includeIndexValueMax = nums[0];
//        result.notIncludeIndexValueMax = 0;
//        dp[0] = result;
//
//        result = new Result();
//        result.notIncludeIndexValueMax = nums[0];
//        result.includeIndexValueMax = nums[1];
//        dp[1] = result;
//
//
//        for (int index = 2; index < nums.length; index++) {
//            int indexValue = nums[index];
//            Result preResult = dp[index - 1];
//            Result preSecondResult = dp[index - 2];
//
//            int includeValueMax = Math.max(preSecondResult.includeIndexValueMax, preSecondResult.notIncludeIndexValueMax) + indexValue;
//            int notIncludeValueMax = Math.max(preResult.includeIndexValueMax, preResult.notIncludeIndexValueMax);
//            Result targetResult = new Result();
//            targetResult.includeIndexValueMax = includeValueMax;
//
//            targetResult.notIncludeIndexValueMax = notIncludeValueMax;
//            dp[index] = targetResult;
//        }
//        return Math.max(dp[nums.length - 1].includeIndexValueMax, dp[nums.length - 1].notIncludeIndexValueMax);

    }


    public static class Result {
        private int includeIndexValueMax;
        private int notIncludeIndexValueMax;
    }

}


