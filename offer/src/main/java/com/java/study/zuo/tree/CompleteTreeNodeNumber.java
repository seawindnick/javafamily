package com.java.study.zuo.tree;

/**
 * 计算完全二叉树所有子节点数量
 */
public class CompleteTreeNodeNumber {


    public static int completeTreeNodeNumber(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int high = calculateHigh(treeNode);
        return completeTreeNodeNumber(treeNode, 1, high);
    }


    //计算节点树深度
    private static int calculateHigh(TreeNode treeNode) {

        int count = 0;
        while (treeNode != null) {
            count++;
            treeNode = treeNode.left;
        }
        return count;
    }

    private static int completeTreeNodeNumber(TreeNode treeNode, int level, int high) {
        //最后一层时，以treeNode为根节点 的树元素个数1个
        if (level == high){
            return 1;
        }

        //判断右子树的深度
        int leftLength = calculateHigh(treeNode.right);
        //如果 右子树的深度到达最后一层 左子树时满二叉树，左子树节点个数+右子树节点个数
        if (leftLength == (high - level)) {
            return  (1 <<((high - level)) )+ completeTreeNodeNumber(treeNode.right, ++level, high);
        } else {
            //右子树没有到达最后一层，那么右树 1～（ high - level - 1 ）层 是一颗满二叉树，其数据加上左树节点个数
            return  (1 <<((high - level) - 1) )+ completeTreeNodeNumber(treeNode.left, ++level, high);
        }


    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
        System.out.println(completeTreeNodeNumber(head));

    }



}
