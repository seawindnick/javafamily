package com.java.study.algorithm.zuo.abasic.basic_class_06;

/**
 * <Description>
 *
 * @author hushiye
 * @since 3/30/21 15:21
 */
public class Code_01_MorrisTraversal2 {


    /**
     * Mirrors 遍历
     * 1。如果没有左节点，向右走
     * 2。如果有有节点
     * i.左子树最右节点maxRight.right == null,设置maxRight.right=自身，向左走
     * ii..左子树最右节点maxRight.right == 自身,设置maxRight.right=null，向右走
     */


    public static void MorrisTraversalPre(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                System.out.print(root.value + " ");
                root = root.right;
            } else {
                TreeNode maxRightNode = findMaxRightNode(root.left, root);

                //第一次到达
                if (maxRightNode.right == null) {
                    System.out.print(root.value + " ");
                    maxRightNode.right = root;
                    root = root.left;
                } else if (maxRightNode.right == root) {
                    maxRightNode.right = null;
                    root = root.right;
                }

            }
        }
    }


    /**
     * 查询最右侧的节点
     *
     * @param node
     * @param parentNode
     * @return
     */
    private static TreeNode findMaxRightNode(TreeNode node, TreeNode parentNode) {
        while (node.right != null && node.right != parentNode) {
            node = node.right;
        }
        return node;
    }


    public static void MorrisTraversalPre2(TreeNode root) {
        if (root == null) {
            return;
        }

        while (root != null) {
            if (root.left != null) {
                TreeNode maxRightNode = findMaxRightNode(root.left, root);
                //第一次到达
                if (maxRightNode.right == null) {
                    System.out.print(root.value + " ");
                    maxRightNode.right = root;
                    root = root.left;
                    continue;
                } else {
                    maxRightNode.right = null;
                }
            } else {
                System.out.print(root.value + " ");

            }
            root = root.right;
        }
    }

    public static void MorrisTraversalIn(TreeNode root) {
        if (root == null) {
            return;
        }

        while (root != null) {
            if (root.left == null) {
                System.out.print(root.value + " ");
                root = root.right;
            } else {
                TreeNode maxRightNode = findMaxRightNode(root.left, root);
                if (maxRightNode.right == null) {
                    maxRightNode.right = root;
                    root = root.left;

                } else {
                    System.out.print(root.value + " ");
                    maxRightNode.right = null;
                    root = root.right;

                }
            }

        }

    }

    public static void MorrisTraversalIn2(TreeNode root) {
        if (root == null) {
            return;
        }

        while (root != null) {
            if (root.left != null) {
                TreeNode maxRightNode = findMaxRightNode(root.left, root);
                if (maxRightNode.right == null) {
                    maxRightNode.right = root;
                    root = root.left;
                    continue;
                } else {
                    System.out.print(root.value + " ");
                    maxRightNode.right = null;
                }
            } else {
                System.out.print(root.value + " ");
            }
            root = root.right;
        }

    }


    public static void MorrisTraversalPos(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        TreeNode root = treeNode;

        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode maxRightNode = findMaxRightNode(root.left, root);
                if (maxRightNode.right == null) {
                    maxRightNode.right = root;
                    root = root.left;
                } else {
                    maxRightNode.right = null;
                    printNode(root.left);
                    root = root.right;
                }
            }
        }

        printNode(treeNode);

    }

    private static void printNode(TreeNode root) {

        TreeNode reverseTreeNode = reseverTreeNode(root);
        TreeNode curTreeNode = reverseTreeNode;
        while (curTreeNode != null) {
            System.out.print(curTreeNode.value + " ");
            curTreeNode = curTreeNode.right;
        }

        reseverTreeNode(reverseTreeNode);
    }

    private static TreeNode reseverTreeNode(TreeNode root) {

        TreeNode preNode = null;
        while (root != null) {
            TreeNode tempNode = root.right;
            root.right = preNode;
            preNode = root;
            root = tempNode;
        }
        return preNode;

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
        Code_01_MorrisTraversal.MorrisTraversalPreSelf(head);

        System.out.println();
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        MorrisTraversalPre(head);


        System.out.println();
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        MorrisTraversalPre2(head);

        System.out.println();
        System.out.println("==============recursive==============");
        System.out.print("in-order: ");
        Code_01_MorrisTraversal.MorrisTraversalPreIn(head);

        System.out.println();
        System.out.println("==============recursive==============");
        System.out.print("in-order: ");
        MorrisTraversalIn(head);

        System.out.println();
        System.out.println("==============recursive==============");
        System.out.print("in-order: ");
        MorrisTraversalIn2(head);


        System.out.println();
        System.out.println("==============recursive==============");
        System.out.print("pos-order: ");
        Code_01_MorrisTraversal.MorrisTraversalPrePos(head);

        System.out.println(head);

        System.out.println();
        System.out.println("==============recursive==============");
        System.out.print("pos-order: ");
        MorrisTraversalPos(head);


    }


}
