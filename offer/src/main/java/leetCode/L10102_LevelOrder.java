package leetCode;//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索 二叉树
// 👍 960 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class L10102_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }


        List<List<Integer>> targetList = new ArrayList<>();

        Queue<TreeNode> s1TreeNodeList = new LinkedList<>();
        Queue<TreeNode> s2TreeNodeList = new LinkedList<>();
        boolean useS1 = true;
        s1TreeNodeList.add(root);

        while (true) {
            Queue<TreeNode> takeOutElementQueue = useS1 ? s1TreeNodeList : s2TreeNodeList;
            if (takeOutElementQueue.isEmpty()) {
                break;
            }
            Queue<TreeNode> pushElementQueue = useS1 ? s2TreeNodeList : s1TreeNodeList;
            List<Integer> levelValue = new ArrayList<>();
            while (!takeOutElementQueue.isEmpty()) {
                TreeNode node = takeOutElementQueue.poll();
                levelValue.add(node.val);
                if (node.left != null) {
                    pushElementQueue.add(node.left);
                }

                if (node.right != null) {
                    pushElementQueue.add(node.right);
                }
            }

            targetList.add(levelValue);

            useS1 = !useS1;

        }

        return targetList;
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


