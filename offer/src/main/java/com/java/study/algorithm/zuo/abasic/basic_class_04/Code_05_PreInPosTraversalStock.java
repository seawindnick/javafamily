package com.java.study.algorithm.zuo.abasic.basic_class_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * <Description>
 *
 * @author hushiye
 * @since 3/26/21 16:49
 */
public class Code_05_PreInPosTraversalStock {


    /**
     * 使用堆栈进行遍历以及使用 Mirror 算法进行遍历
     */

    public static void preUseStock(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(node);

        /**
         * 先打印当前节点，再添加右节点和左节点
         *
         */
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            System.out.print(tempNode.value + " ");
            if (tempNode.right != null) {
                stack.push(tempNode.right);
            }
            if (tempNode.left != null) {
                stack.push(tempNode.left);
            }
        }
    }


    public static void inUseStack(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(treeNode);
        List exists = new ArrayList();

        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            if (tempNode.left == null && tempNode.right == null || exists.contains(tempNode)) {
                System.out.print(tempNode.value + " ");
                continue;
            }

            if (tempNode.right != null) {
                stack.push(tempNode.right);
            }
            stack.push(tempNode);

            if (tempNode.left != null) {
                stack.push(tempNode.left);
            }
            exists.add(tempNode);

        }

    }

    public static void inUseStack2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || treeNode != null) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                TreeNode tempNode = stack.pop();
                System.out.print(tempNode.value + " ");
                treeNode = tempNode.right;
            }
        }
    }


    public static void posUserStack(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> treeNodesStack = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        treeNodesStack.push(treeNode);

        while (!treeNodesStack.isEmpty()) {
            TreeNode tempNode = treeNodesStack.pop();
            stack.push(tempNode);

            if (tempNode.left != null) {
                treeNodesStack.push(tempNode.left);
            }


            if (tempNode.right != null) {
                treeNodesStack.push(tempNode.right);
            }


        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value + " ");
        }
    }


    public static void posUserStack2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.peek();
            if (tempNode.left != null && tempNode.left != treeNode && tempNode.right != treeNode) {
                stack.push(tempNode.left);
            } else if (tempNode.right != null && tempNode.right != treeNode && tempNode != treeNode) {
                stack.push(tempNode.right);
            } else {
                System.out.print(stack.pop().value + " ");
                treeNode = tempNode;
            }

        }

    }

    public static void posOrderUnRecur2(TreeNode h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(h);
            TreeNode c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }


}
