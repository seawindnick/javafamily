package leetCode;//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
//
//
// 示例 1：
//
//
//输入：grid = [
// [1,3,1],
// [1,5,1],
// [4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
//
//
// 示例 2：
//
//
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Related Topics 数组 动态规划 矩阵
// 👍 954 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10064_MinPathSum {
    public static void main(String[] args) {
        int[][] martix = new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        };
        System.out.println(minPathSum(martix));

    }

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }


        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int row = 1; row < grid.length; row++) {

            for (int column = 1; column < grid[0].length; column++) {

                dp[row][column] = Math.min(dp[row - 1][column], dp[row][column - 1]) + grid[row][column];
            }

        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}

