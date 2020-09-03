package com.java.study.zuo.vedio.basic.chapter4;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-25 23:12
 */
public class PrintBinaryTree {

    public static void printTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        String prefix = "        ";

        printInOrder(treeNode, 1, "HH",17);

    }



    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    private static void printTreeNode(TreeNode treeNode, String prefix, String flag) {
        if (treeNode == null) {
            return;
        }

        printTreeNode(treeNode.right, prefix + "        ", "vv");
        System.out.println(prefix + flag + treeNode.value + flag);
        printTreeNode(treeNode.left, prefix + "        ", "^^");
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
//
//        // recursive
//        System.out.println("==============recursive==============");
//        System.out.print("pre-order: ");
//        pre(head);
//        System.out.println();
//        System.out.print("in-order: ");
//        in(head);
//        System.out.println();
//        System.out.print("pos-order: ");
//        pos(head);
//        System.out.println();

        printTreeNode(head);

    }
}
