package com.java.study.zuo.vedio.basic.chapter4;


/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-25 23:23
 */
public class DescendantNode {

    /**
     * 获取一个节点的中序遍历后继节点
     *
     * @param node
     * @return
     */
    public static ParentNode getNextNode(ParentNode node) {

        if (node == null) {
            return null;
        }

        ParentNode curNode = node;
        if (curNode.right == null) {
            ParentNode parentNode = curNode.parent;
            while (parentNode != null && parentNode.left != curNode) {
                curNode = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        } else {
            //获取右节点的最左节点返回
            ParentNode treeNode = getMaxLeft(curNode.right);
            return treeNode;
        }
    }

    private static ParentNode getMaxLeft(ParentNode treeNode) {

        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
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
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getNextNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getNextNode(test));
    }

}
