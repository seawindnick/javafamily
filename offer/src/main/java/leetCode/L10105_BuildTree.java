package leetCode;//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
//
//
//
// 示例 1:
//
//
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
//
//
//
//
// 提示:
//
//
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder 和 inorder 均无重复元素
// inorder 均出现在 preorder
// preorder 保证为二叉树的前序遍历序列
// inorder 保证为二叉树的中序遍历序列
//
// Related Topics 树 数组 哈希表 分治 二叉树
// 👍 1149 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.alibaba.fastjson.JSONObject;
import com.sun.tools.hat.internal.model.Root;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

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
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 */
public class L10105_BuildTree {

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        System.out.println(JSONObject.toJSON(treeNode));

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preStartIndex, int preStopIndex, int inStartIndex, int inStopIndex) {
        if (preStartIndex > preStopIndex || inStartIndex > inStopIndex || preStartIndex < 0 || preStopIndex >= preorder.length || inStartIndex < 0 || inStopIndex >= inorder.length) {
            return null;
        }

        int indexRootValue = preorder[preStartIndex];

        TreeNode treeNode = new TreeNode();
        treeNode.val = indexRootValue;

        int inorderRootIndexValueIndex = Integer.MIN_VALUE;

        for (int i = inStartIndex; i <= inStopIndex; i++) {
            if (inorder[i] == indexRootValue) {
                inorderRootIndexValueIndex = i;
                break;
            }
        }

        /**
         *  * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
         *  * 输出: [3,9,20,null,null,15,7]
         */
        int leftLength = inorderRootIndexValueIndex - inStartIndex;
        TreeNode left = buildTree(preorder, inorder, preStartIndex + 1, preStartIndex + leftLength, inStartIndex, inorderRootIndexValueIndex - 1);
        TreeNode right = buildTree(preorder, inorder, preStartIndex + 1 + leftLength, preStopIndex, inorderRootIndexValueIndex + 1, inStopIndex);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;

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


