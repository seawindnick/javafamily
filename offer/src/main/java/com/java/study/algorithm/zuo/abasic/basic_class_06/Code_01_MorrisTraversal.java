package com.java.study.algorithm.zuo.abasic.basic_class_06;

import java.util.TreeMap;

/**
 * Mirror 遍历
 */
public class Code_01_MorrisTraversal {


    /**
     * 如果cur无左孩子，cur向右移动（cur=cur.right）
     * 如果cur有左孩子，找到cur左子树上最右的节点，记为mostright
     * 如果mostright的right指针指向空，让其指向cur，cur向左移动（cur=cur.left）
     * 如果mostright的right指针指向cur，让其指向空，cur向右移动（cur=cur.right）
     *
     * @param root
     */
    public static void MorrisTraversalPreSelf(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                System.out.print(root.value + " ");
                root = root.right;
            } else {
                //第二次来到该点位置
                TreeNode maxLeftNode = findMaxLeftNode(root.left, root);
                if (maxLeftNode.right == null) {
                    System.out.print(root.value + " ");
                    maxLeftNode.right = root;
                    root = root.left;
                } else {
                    root = root.right;
                    maxLeftNode.right = null;
                }
            }

        }

    }


    public static void MorrisTraversalPreIn(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                System.out.print(root.value + " ");
                root = root.right;
            } else {
                //第二次来到该点位置
                TreeNode maxLeftNode = findMaxLeftNode(root.left, root);
                if (maxLeftNode.right == null) {
                    maxLeftNode.right = root;
                    root = root.left;
                } else {
                    System.out.print(root.value + " ");
                    root = root.right;
                    maxLeftNode.right = null;

                }
            }

        }

    }


    public static void MorrisTraversalPrePos(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root;
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                //第二次来到该点位置
                TreeNode maxLeftNode = findMaxLeftNode(root.left, root);
                if (maxLeftNode.right == null) {
                    maxLeftNode.right = root;
                    root = root.left;
                } else {
                    maxLeftNode.right = null;
                    print(root.left);
                    root = root.right;
                }
            }

        }
        print(temp);
    }

    public static void print(TreeNode node) {
//        先逆序整个右边界
        TreeNode tail = reverseEdge(node);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
//        翻转回来
        reverseEdge(tail);
    }

    public static TreeNode reverseEdge(TreeNode node) {
        TreeNode pre = null;
        TreeNode next = null;
        while (node != null) {
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }


    /**
     * 右侧节点进行反转
     *
     * @param root
     * @return
     */
    private static TreeNode reverserTreeNode(TreeNode root) {
        if (root.right == null) {
            return root;
        }

        TreeNode preNode = root;
        TreeNode nextNode = root.right;
        while (nextNode != null) {
            TreeNode rightNode = nextNode.right;
            nextNode.left = preNode;
            preNode = nextNode;
            nextNode = rightNode;

        }
        return preNode;
    }


    public static void MorrisTraversalPre(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left != null) {
                TreeNode maxLeftNode = findMaxLeftNode(root.left, root);
                //第一次来到节点
                if (maxLeftNode.right == null) {
                    System.out.print(root.value + " ");
                    maxLeftNode.right = root;
                    root = root.left;
                    continue;
                }
                // 第二次来到节点
                maxLeftNode.right = null;
            } else {
                System.out.print(root.value + " ");

            }
            // 第一次来到节点？
            root = root.right;
        }

    }

    public static void morrisPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode rightMost = cur.left;
                // 找到cur的左子树的最右节点，因为我们要通过这个节点返回回来。
                while (rightMost.right != null && rightMost.right != cur) {
                    rightMost = rightMost.right;
                }
                // 当第一次遍历到rightMost时，我们要建立起其和cur的联系，同时打印cur节点
                if (rightMost.right == null) {
                    // 这里是你对节点的操作
                    System.out.println(cur.value);
                    rightMost.right = cur;
                    cur = cur.left;
                    continue;
                }
                // 恢复叶子的空指针
                rightMost.right = null;
            } else { // 如果当前节点没有左孩子，那么我们不必遍历其左子树，直接输出该节点后开始遍历其右子树即可，因为我们不用返回到该节点了
                // 这里是你对节点的操作
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    private static TreeNode findMaxLeftNode(TreeNode node, TreeNode root) {
        while (node.right != null && node.right != root) {
            node = node.right;
        }
        return node;
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
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        MorrisTraversalPrePos(head);
//        morrisPreOrder(head);
        System.out.println();


    }


}