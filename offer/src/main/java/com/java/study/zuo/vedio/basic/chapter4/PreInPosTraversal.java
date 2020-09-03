package com.java.study.zuo.vedio.basic.chapter4;

import java.util.Stack;

/**
 * <Description>
 * 前序 中序 后序 非遍历实现
 *
 * @author hushiye
 * @since 2020-08-24 08:40
 */
public class PreInPosTraversal {

    public static void pre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.value);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void in(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                TreeNode node = stack.pop();
                System.out.println(node.value);
                treeNode = node.right;
            }
        }

    }


    public static void pos(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        Stack<TreeNode> printStack = new Stack<>();
        Stack<TreeNode> loopStack = new Stack<>();
        loopStack.push(treeNode);
        while (!loopStack.isEmpty()) {
            TreeNode node = loopStack.pop();
            printStack.push(node);

            if (node.left != null) {
                loopStack.push(node.left);
            }

            if (node.right != null) {
                loopStack.push(node.right);
            }
        }

        while (!printStack.isEmpty()) {
            System.out.println(printStack.pop().value);
        }

    }


    public static void mirrorsPre(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }


        TreeNode currentNode = treeNode;
        while (currentNode != null) {
            if (currentNode.left != null) {
                TreeNode maxRightNode = getMaxRightNode(currentNode.left, currentNode);
                //第二次到达
                if (maxRightNode.right == currentNode) {
                    maxRightNode.right = null;
                    currentNode = currentNode.right;
                    continue;
                } else {
                    System.out.println(currentNode.value);
                    //第一次到达
                    maxRightNode.right = currentNode;
                    currentNode = currentNode.left;
                }
            } else {
                //无左子树向右方移动
                System.out.println(currentNode.value);
                currentNode = currentNode.right;
            }
        }

    }


    public static void mirrorsIn(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }


        TreeNode currentNode = treeNode;
        while (currentNode != null) {
            if (currentNode.left != null) {
                TreeNode maxrightNode = getMaxRightNode(currentNode.left, currentNode);
                if (maxrightNode.right != currentNode) {
                    maxrightNode.right = currentNode;
                    currentNode = currentNode.left;
                    continue;
                } else {
                    System.out.println(currentNode.value);
                    maxrightNode.right = null;
                    currentNode = currentNode.right;
                }
            } else {
                System.out.println(currentNode.value);
                currentNode = currentNode.right;
            }
        }


    }


    public static void mirrorsPos(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        TreeNode currentNode = treeNode;
        while (currentNode != null) {
            if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else {
                TreeNode maxRightNode = getMaxRightNode(currentNode.left, currentNode);
                if (maxRightNode.right == null) {
                    maxRightNode.right = currentNode;
                    currentNode = currentNode.left;
                    continue;
                } else {
                    maxRightNode.right = null;
                    edge(currentNode.left);
                    currentNode = currentNode.right;
                }
            }
        }
        edge(treeNode);

    }


    public static void morrisPos(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    edge(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        edge(head);
    }

    public static void printEdge(TreeNode head) {
        TreeNode tail = reverseEdge(head);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }


    private static void edge(TreeNode left) {
        if (left == null) {
            return;
        }

        //逆转左子树的右子树
        TreeNode tempNode = reverseTreeNode(left);
        //打印右子树的右子树
        printTrrNode(tempNode);
        //还原右子树的右子树
        reverseTreeNode(tempNode);
    }

    private static void printTrrNode(TreeNode tempNode) {
        while (tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.right;
        }
    }

    private static TreeNode reverseTreeNode(TreeNode left) {
        TreeNode headNode = left;
        TreeNode preNode = null;

        while (headNode != null) {
            TreeNode rightNode = headNode.right;
            headNode.right = preNode;
            preNode = headNode;
            headNode = rightNode;
        }
        return preNode;
    }

    private static TreeNode getMaxRightNode(TreeNode left, TreeNode currentNode) {
        TreeNode maxRightNode = left;
        while (maxRightNode.right != null && maxRightNode.right != currentNode) {
            maxRightNode = maxRightNode.right;
        }
        return maxRightNode;
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

        mirrorsPos(head);

    }
}
