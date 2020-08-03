package com.java.study.zuo.tree;

import java.util.Stack;

public class PreInPosTraversal {


    /**
     * 前序遍历
     *
     * @param treeNode
     */
    public static void preorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.println(treeNode.getValue());
        preorder(treeNode.getLeft());
        preorder(treeNode.getRight());
    }


    /**
     * 中序遍历
     *
     * @param treeNode
     */
    public static void inorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inorder(treeNode.getLeft());
        System.out.println(treeNode.getValue());
        inorder(treeNode.getRight());
    }


    /**
     * 后序遍历
     *
     * @param treeNode
     */
    public static void epilogue(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        epilogue(treeNode.getLeft());
        epilogue(treeNode.getRight());
        System.out.println(treeNode.getValue());
    }


    /**
     * 不使用递归，使用栈进行前序遍历
     *
     * @param treeNode
     */
    public static void preorderUseStack(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.getValue());

            if (treeNode.getRight() != null) {
                stack.push(treeNode.getRight());
            }

            if (treeNode.getLeft() != null) {
                stack.push(treeNode.getLeft());
            }
        }
    }


    /**
     * 中序遍历不使用递归，使用栈
     *
     * @param treeNode
     */
    public static void inorderUseStack(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || treeNode != null) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            } else {
                TreeNode tempNode = stack.pop();
                System.out.println(tempNode.getValue());
                treeNode = tempNode.getRight();
            }
        }
    }


    /**
     * 使用栈进行后序遍历
     *
     * @param treeNode
     */
    public static void epilogueUseStack(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> helpStack = new Stack<>();
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode tempTreeNode = stack.pop();
            helpStack.push(tempTreeNode);
            if (tempTreeNode.left != null) {
                stack.push(tempTreeNode.getLeft());
            }

            if (tempTreeNode.right != null) {
                stack.push(tempTreeNode.getRight());
            }
        }


        while (!helpStack.isEmpty()){
            System.out.println(helpStack.pop().getValue());
        }

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

        // recursive
//        System.out.println("==============recursive==============");
//        System.out.print("pre-order: ");
//        preOrderRecur(head);
//        System.out.println();
//        System.out.print("in-order: ");
//        inOrderRecur(head);
//        System.out.println();
//        System.out.print("pos-order: ");
        epilogue(head);
//        System.out.println();

        // unrecursive
        System.out.println("============unecursive=============");
//        preorderUseStack(head);
        epilogueUseStack(head);
//        posOrderUnRecur1(head);
//        posOrderUnRecur2(head);

    }

}
