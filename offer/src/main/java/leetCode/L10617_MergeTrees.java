package leetCode;//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 747 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetCode.L10543_DiameterOfBinaryTree;

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
public class L10617_MergeTrees {


    /**
     * //	Tree 1                     Tree 2
     * //          1                         2
     * //         / \                       / \
     * //        3   2                     1   3
     * //       /                           \   \
     * //      5                             4   7
     * //输出:
     * //合并后的树:
     * //	     3
     * //	    / \
     * //	   4   5
     * //	  / \   \
     * //	 5   4   7
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode2;
        treeNode3.left = treeNode5;


        TreeNode newTreeNode1 = new TreeNode(1);
        TreeNode newTreeNode2 = new TreeNode(2);
        TreeNode newTreeNode3 = new TreeNode(3);
        TreeNode newTreeNode7 = new TreeNode(7);
        TreeNode newTreeNode4 = new TreeNode(4);
        newTreeNode2.left = newTreeNode1;
        newTreeNode2.right = newTreeNode3;
        newTreeNode1.right = newTreeNode4;
        newTreeNode3.right = newTreeNode7;


        TreeNode targetTreeNode = mergeTrees(treeNode1, newTreeNode2);

        System.out.println("Haha");


    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        TreeNode node = buildTreeNode(root1, root2);
        return node;
    }

    //以左树为主
    private static TreeNode buildTreeNode(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode root1Left = null;
        TreeNode root1Right = null;
        if (root1 != null) {
            root1Left = root1.left;
            root1Right = root1.right;
            root1.left = null;
            root1.right = null;
        }

        TreeNode root2Left = null;
        TreeNode root2Right = null;
        if (root2 != null) {
            root2Left = root2.left;
            root2Right = root2.right;
            root2.left = null;
            root2.right = null;
        }

        TreeNode targetNode = root1 == null ? root2 : root1;
        if (root1 != null && root2 != null) {
            targetNode.val = root1.val + root2.val;
        }

        TreeNode targetLeftNode = buildTreeNode(root1Left, root2Left);
        TreeNode targetRightNode = buildTreeNode(root1Right, root2Right);
        targetNode.left = targetLeftNode;
        targetNode.right = targetRightNode;

        return targetNode;
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

