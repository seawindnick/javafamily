package com.java.study.zuo.tree;

/**
 * 前序遍历后继节点
 */
public class PreorderSuccessorNode {


    /**
     * 后继节点
     *
     * 1。 如果有左节点，返回左节点
     * 2。 如果无左节点，返回右节点
     * 3。 如果左右节点都没有，则找 parentTreeNode 为curParentNode 左节点，且右节点不为空的数据，返回右节点
     *
     * @param parentTreeNode
     * @return
     */
    public static ParentTreeNode getPreorderSuccessorNode(ParentTreeNode parentTreeNode) {
        if (parentTreeNode == null) {
            return null;
        }

        if (parentTreeNode.left != null) {
            return parentTreeNode.left;
        }
        if (parentTreeNode.right != null){
            return parentTreeNode.right;
        }


        ParentTreeNode curParentNode = parentTreeNode.parent;
        while (curParentNode != null) {
            if (curParentNode.left == parentTreeNode && curParentNode.right != null) {
                return curParentNode.right;
            }

            curParentNode = curParentNode.parent;
            parentTreeNode = parentTreeNode.parent;

        }
        return curParentNode;
    }


    public static void main(String[] args) {
        ParentTreeNode head = new ParentTreeNode(6);
        head.parent = null;
        head.left = new ParentTreeNode(3);
        head.left.parent = head;
        head.left.left = new ParentTreeNode(1);
        head.left.left.parent = head.left;
        head.left.left.right = new ParentTreeNode(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new ParentTreeNode(4);
        head.left.right.parent = head.left;
        head.left.right.right = new ParentTreeNode(5);
        head.left.right.right.parent = head.left.right;
        head.right = new ParentTreeNode(9);
        head.right.parent = head;
        head.right.left = new ParentTreeNode(8);
        head.right.left.parent = head.right;
        head.right.left.left = new ParentTreeNode(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new ParentTreeNode(10);
        head.right.right.parent = head.right;


        /**
         * 后继节点最后一个为空
         */
        ParentTreeNode test = head.left.left;
        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test));


//        /**
//         * 前驱节点第一个为空
//         */
//        test = head.left.left;
//        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test));
//        test = head.left.left.right;
//        test = head.left;
//        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
//        test = head.left.right;
//        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
//        test = head.left.right.right;
//        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
//
//        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
//        test = head;
//        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
//        test = head.right.left.left;
//        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
//        test = head.right.left;
//        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
//        test = head.right;
//        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
//        test = head.right.right; // 10's next is null
//        System.out.println(test.value + " next: " + getPreorderSuccessorNode(test).value);
    }


}
