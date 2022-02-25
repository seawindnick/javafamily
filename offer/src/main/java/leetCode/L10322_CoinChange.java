package leetCode;//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
//输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
//输入：coins = [2], amount = 3
//输出：-1
//
// 示例 3：
//
//
//输入：coins = [1], amount = 0
//输出：0
//
//
// 示例 4：
//
//
//输入：coins = [1], amount = 1
//输出：1
//
//
// 示例 5：
//
//
//输入：coins = [1], amount = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划
// 👍 1156 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10322_CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int value = 0; value <= amount; value++) {

            for (int index = 0; index < coins.length; index++) {
                if (value < coins[index]) {
                    continue;
                }
                dp[value] = Math.min(dp[value - coins[index]] + 1, dp[value]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

//
//
//        Integer[] dp = new Integer[amount + 1];
//        for (int index = 0; index < coins.length; index++) {
//            if (coins[index] > amount) {
//                continue;
//            }
//            dp[coins[index]] = 1;
//        }
//
//        for (int i = 0; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (i < coins[j]) {
//                    continue;
//                }
//                if (dp[i - coins[j]] != null) {
//                    dp[i] = dp[i] == null ? dp[i - coins[j]] + 1 : Math.min(dp[i - coins[j]] + 1, dp[i]);
//                }
//            }
//        }
//
//        return dp[amount] == null ? -1 : dp[amount];
    }
}


