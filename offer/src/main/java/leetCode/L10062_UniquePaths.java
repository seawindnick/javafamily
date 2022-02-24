package leetCode;//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
//输入：m = 3, n = 7
//输出：28
//
// 示例 2：
//
//
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
//
//
// 示例 3：
//
//
//输入：m = 7, n = 3
//输出：28
//
//
// 示例 4：
//
//
//输入：m = 3, n = 3
//输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 109
//
// Related Topics 数学 动态规划 组合数学
// 👍 1074 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10062_UniquePaths {


    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }

        }

        return dp[m-1][n-1];


    }

//    private static int uniquePaths(int m, int n) {
//        int[][] dp = new int[m + 1][n + 1];
//
//        for (int i = m - 1; i >= 0; i--) {
//            for (int j = n - 1; j >= 0; j--) {
//                if (i == m - 1 && j == n - 1) {
//                    dp[i][j] = 1;
//                } else {
//                    int right = dp[i][j + 1];
//                    int down = dp[i + 1][j];
//                    dp[i][j] = right + down;
//                }
//            }
//
//
//        }
//
//        return dp[0][0];
//    }

//    public static int uniquePaths(int m, int n) {
//
//        int startRow = 0;
//        int startCol = 0;
//
//        return uniquePaths(startRow, startCol, m, n);
//    }
//
//    private static int uniquePaths(int startRow, int startCol, int m, int n) {
//
//        if (startRow >= m || startCol >= n) {
//            return 0;
//        }
//
//        if (startRow == m - 1 && startCol == n - 1) {
//            return 1;
//        }
//
//        int right = uniquePaths(startRow + 1, startCol, m, n);
//        int down = uniquePaths(startRow, startCol + 1, m, n);
//        return right + down;
//    }

}


