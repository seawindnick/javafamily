package leetCode;//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：5
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 19
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树
// 👍 1257 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10096_NumTrees {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] countArray = new int[n+1];
        countArray[0] = 1;
        countArray[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                countArray[i] = countArray[i] + countArray[j - 1] * countArray[i-j];
            }
        }
        return countArray[n];
    }

    /**
     *
     * [sol1-Java]
     * class Solution {
     *     public int numTrees(int n) {
     *         int[] G = new int[n + 1];
     *         G[0] = 1;
     *         G[1] = 1;
     *
     *         for (int i = 2; i <= n; ++i) {
     *             for (int j = 1; j <= i; ++j) {
     *                 G[i] += G[j - 1] * G[i - j];
     *             }
     *         }
     *         return G[n];
     *     }
     * }
     */

}


