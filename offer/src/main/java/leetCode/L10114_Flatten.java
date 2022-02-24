package leetCode;//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
// Related Topics 栈 树 深度优先搜索 链表 二叉树
// 👍 877 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.tree.TreeNode;
import java.util.*;

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
public class L10114_Flatten {


    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (pre != null) {
                pre.right = treeNode;
                pre.left = null;
            }

            if (treeNode.right != null){
                stack.push(treeNode.right);
            }

            if (treeNode.left != null){
                stack.push(treeNode.left);
            }
            pre = treeNode;
        }

    }


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> treeNodeList = new ArrayList<>();
        fullPreNodeList(treeNodeList, root);

        for (int i = 0; i < treeNodeList.size(); i++) {
            TreeNode node = treeNodeList.get(i);
            node.left = null;
            if (i != treeNodeList.size() - 1) {
                node.right = treeNodeList.get(i + 1);
            }
        }
    }

    private void fullPreNodeList(List<TreeNode> treeNodeList, TreeNode root) {
        if (root == null) {
            return;
        }
        treeNodeList.add(root);
        fullPreNodeList(treeNodeList, root.left);
        fullPreNodeList(treeNodeList, root.right);
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


