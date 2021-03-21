package com.java.study.niuke;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-04 10:25
 */
public class Mirror {





    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void Mirror(TreeNode root) {

        if (root == null){
            return;
        }

        TreeNode left = root.left;

        root.left = root.right;
        root.right = left;

        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {



    }
}
