package com.java.study.algorithm.zuo.abasic.basic_class_04;

import com.java.study.zuo.tree.ParentTreeNode;

/**
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 * 假设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向 自己的父节点，
 * 头节点的parent指向null。
 * 只给一个在二叉树中的某个节点 node，请实现返回node的后继节点的函数。
 * 在二叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
 */
public class Code_07_DescendantNode {


    /**
     * 5
     * 3             6
     * 7      8        9    2
     * 12
     * <p>
     * 7 3 12 8 5 9 6 2
     * 先左 再中 再右
     *
     * @param node
     * @return
     */
    public static ParentNode findDescendantNode(ParentNode node) {
        if (node == null) {
            return null;
        }


        /**
         *
         * 1.如果节点有右子树，其后继节点是右子树的最左节点
         * 2.如果没有右子树，从下网上 找第一个node是父节点的左节点的节点，其父节点就是要找的节点
         *
         */


        if (node.right != null) {
            return findRightTreeMaxLeft(node.right);
        }

        ParentNode parentNode = node.parent;
        while (parentNode != null && parentNode.left != node) {
            node = parentNode;
            parentNode = parentNode.parent;
        }

        return parentNode;

    }

    private static ParentNode findRightTreeMaxLeft(ParentNode node) {
        ParentNode targetTreeNode = null;
        while (node != null) {
            targetTreeNode = node;
            node = node.left;
        }

        return targetTreeNode;
    }


    public static void main(String[] args) {
        ParentNode head = new ParentNode(6);
        head.parent = null;
        head.left = new ParentNode(3);
        head.left.parent = head;
        head.left.left = new ParentNode(1);
        head.left.left.parent = head.left;
        head.left.left.right = new ParentNode(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new ParentNode(4);
        head.left.right.parent = head.left;
        head.left.right.right = new ParentNode(5);
        head.left.right.right.parent = head.left.right;
        head.right = new ParentNode(9);
        head.right.parent = head;
        head.right.left = new ParentNode(8);
        head.right.left.parent = head.right;
        head.right.left.left = new ParentNode(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new ParentNode(10);
        head.right.right.parent = head.right;

        ParentNode test = head.left.left;
        System.out.println(test.value + " next: " + findDescendantNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + findDescendantNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + findDescendantNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + findDescendantNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + findDescendantNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + findDescendantNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + findDescendantNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + findDescendantNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + findDescendantNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + findDescendantNode(test));
    }


//    1 next: 3
//            2 next: 3
//            3 next: 6
//            4 next: 5
//            5 next: 3
//            6 next: 1
//            7 next: 8
//            8 next: 9
//            9 next: 10

}