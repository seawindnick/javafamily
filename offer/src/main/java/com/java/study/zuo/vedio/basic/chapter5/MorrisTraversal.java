package com.java.study.zuo.vedio.basic.chapter5;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-26 21:38
 */
public class MorrisTraversal {


    private static void morrisPre(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }


        TreeNode curentNode = treeNode;
        while (curentNode != null) {
            if (curentNode.left == null) {
                System.out.println(curentNode.value);
                curentNode = curentNode.right;
            } else {
                TreeNode maxRightNode = curentNode.left;
                while (maxRightNode.right != null && maxRightNode.right != curentNode) {
                    maxRightNode = maxRightNode.right;
                }

                if (maxRightNode.right == curentNode) {
                    maxRightNode.right = null;
                    curentNode = curentNode.right;
                    continue;
                } else {
                    System.out.println(curentNode.value);
                    maxRightNode.right = curentNode;
                    curentNode = curentNode.left;
                }

            }
        }

    }

    private static void morrisIn(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        TreeNode currentTreeNode = treeNode;
        while (currentTreeNode != null) {
            if (currentTreeNode.left == null) {
                System.out.println(currentTreeNode.value);
                currentTreeNode = currentTreeNode.right;
            } else {
                TreeNode maxRightNode = currentTreeNode.left;
                while (maxRightNode.right != null && maxRightNode.right != currentTreeNode) {
                    maxRightNode = maxRightNode.right;
                }
                if (maxRightNode.right == currentTreeNode) {
                    System.out.println(currentTreeNode.value);
                    maxRightNode.right = null;
                    currentTreeNode = currentTreeNode.right;
                    continue;
                } else {

                    maxRightNode.right = currentTreeNode;
                    currentTreeNode = currentTreeNode.left;

                }

            }
        }
    }


    public static void morrisPos(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        TreeNode currentNode = treeNode;
        while (currentNode != null) {
            if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else {
                TreeNode maxRightNode = currentNode.left;
                while (maxRightNode.right != null && maxRightNode.right != currentNode) {
                    maxRightNode = maxRightNode.right;
                }

                if (maxRightNode.right == currentNode) {
                    maxRightNode.right = null;
                    printEdge(currentNode.left);
                    currentNode = currentNode.right;
                    continue;
                } else {
                    maxRightNode.right = currentNode;
                    currentNode = currentNode.left;
                }
            }
        }
        printEdge(treeNode);

    }

    /**
     * 打印右边界信息
     *
     * @param treeNode
     */
    private static void printEdge(TreeNode treeNode) {
        TreeNode tempHead = reverse(treeNode);
        TreeNode searchNode = tempHead;
        while (searchNode != null) {
            System.out.println(searchNode.value);
            searchNode = searchNode.right;
        }
        reverse(tempHead);
    }

    private static TreeNode reverse(TreeNode treeNode) {
        TreeNode pre = null;
        while (treeNode != null) {
            TreeNode temp = treeNode.right;

            treeNode.right = pre;
            pre = treeNode;
            treeNode = temp;
        }
        return pre;

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

        morrisPre(head);
        System.out.println("-----------");
        morrisIn(head);
        System.out.println("-----------");
        morrisPos(head);



    }

}
