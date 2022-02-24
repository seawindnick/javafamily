package leetCode;//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树
// 👍 1156 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
public class L10098_IsValidBST {


    public static void main(String[] args) {
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode2.left = treeNode1;
//        treeNode2.right = treeNode3;
//
//        System.out.println(isValidBST(treeNode2));


        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);

//        treeNode5.left = treeNode4;
        treeNode5.right = treeNode6;

        treeNode6.left = treeNode3;
        treeNode6.right = treeNode7;

        System.out.println(isValidBST(treeNode5));

    }
//
//    private static boolean isValidBST(TreeNode treeNode) {
//        if (treeNode == null) {
//            return true;
//        }
//
//        boolean leftFlag = true;
//        if (treeNode.left != null) {
//            leftFlag = treeNode.left.val < treeNode.val;
//        }
//
//
//        boolean rightFlag = true;
//        if (treeNode.right != null) {
//            rightFlag = treeNode.right.val > treeNode.val;
//        }
//
//        if (!(leftFlag && rightFlag)) {
//            return false;
//        }
//
//        return isValidBST(treeNode.left) && isValidBST(treeNode.right);
//    }


    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private static boolean isValidBST(TreeNode node, int lower, int upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);


    }


    /**
     * class Solution {
     * public boolean isValidBST(TreeNode root) {
     * return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
     * }
     * <p>
     * public boolean isValidBST(TreeNode node, long lower, long upper) {
     * if (node == null) {
     * return true;
     * }
     * if (node.val <= lower || node.val >= upper) {
     * return false;
     * }
     * return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
     * }
     * }
     */

//    private static ValidBSTResult calculateValidBSTResult(TreeNode root) {
//        ValidBSTResult validBSTResult = new ValidBSTResult();
//        validBSTResult.BSTFlag = true;
//        if (root == null) {
//            return validBSTResult;
//        }
//
//        Integer minValue = root.val;
//        Integer maxValue = root.val;
//        if (root.left != null) {
//            ValidBSTResult leftResult = calculateValidBSTResult(root.left);
//            if (!leftResult.BSTFlag) {
//                validBSTResult.BSTFlag = false;
//                return validBSTResult;
//            }
//            int minLeftValueLeft = leftResult.minValue == null ? root.left.val : leftResult.minValue;
//            int maxLeftValueLeft = leftResult.maxValue == null ? root.left.val : leftResult.maxValue;
//            if (minLeftValueLeft >= root.val || maxLeftValueLeft >= root.val) {
//                validBSTResult.BSTFlag = false;
//                return validBSTResult;
//            }
//            minValue = minLeftValueLeft;
//        }
//
//        if (root.right != null) {
//            ValidBSTResult rightResult = calculateValidBSTResult(root.right);
//            if (!rightResult.BSTFlag) {
//                validBSTResult.BSTFlag = false;
//                return validBSTResult;
//            }
//            int minRightValue = rightResult.minValue == null ? root.right.val : rightResult.minValue;
//            int maxRightValue = rightResult.maxValue == null ? root.right.val : rightResult.maxValue;
//            if (minRightValue <= root.val || maxRightValue <= root.val) {
//                validBSTResult.BSTFlag = false;
//                return validBSTResult;
//            }
//            maxValue = maxRightValue;
//        }
//
//        validBSTResult.minValue = minValue;
//        validBSTResult.maxValue=  maxValue;
//        return validBSTResult;
//    }


//
//
//    private static ValidBSTResult calculateValidBSTResult(TreeNode root) {
//        ValidBSTResult validBSTResult = new ValidBSTResult();
//        validBSTResult.BSTFlag = true;
//        if (root == null) {
//            return validBSTResult;
//        }
//
//        Integer maxValue = null;
//        Integer minValue = null;
//        if (root.left != null) {
//            ValidBSTResult leftResult = calculateValidBSTResult(root.left);
//            if (!leftResult.BSTFlag || root.left.val >= root.val || (leftResult.maxValue != null && leftResult.maxValue >= root.val)) {
//                validBSTResult.BSTFlag = false;
//                return validBSTResult;
//            }
//            minValue = leftResult.minValue == null ? root.left.val : leftResult.minValue;
//        }
//
//
//        if (root.right != null) {
//            ValidBSTResult rightResult = calculateValidBSTResult(root.right);
//            if (!rightResult.BSTFlag || root.right.val <= root.val || (rightResult.minValue != null && rightResult.minValue >= root.val)) {
//                validBSTResult.BSTFlag = false;
//                return validBSTResult;
//            }
//            maxValue = rightResult.maxValue == null ? root.right.val : rightResult.maxValue;
//        }
//        validBSTResult.BSTFlag = true;
//        validBSTResult.minValue = minValue;
//        validBSTResult.maxValue = maxValue;
//
//        return validBSTResult;
//    }


    public static class ValidBSTResult {
        private boolean BSTFlag;
        private Integer maxValue;
        private Integer minValue;
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


