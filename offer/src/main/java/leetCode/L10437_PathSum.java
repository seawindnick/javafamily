package leetCode;//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
//
//
// 示例 2：
//
//
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [0,1000]
// -109 <= Node.val <= 109
// -1000 <= targetSum <= 1000
//
// Related Topics 树 深度优先搜索 二叉树
// 👍 938 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.plaf.SpinnerUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class L10437_PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int sum = rooSum(root, targetSum);
        sum += pathSum(root.left, targetSum);
        sum += pathSum(root.right, targetSum);
        return sum;

    }

    private int rooSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int value = 0;
        if (targetSum == root.val) {
            value++;
        }
        value += rooSum(root.left, targetSum - root.val);
        value += rooSum(root.right, targetSum - root.val);
        return value;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

