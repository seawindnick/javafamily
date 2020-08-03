package com.java.study.zuo.tree;

/**
 * 前序遍历前驱节点
 */
public class PreorderStructDnode {

    /**
     * 获取前驱节点
     * 1. 如果该节点是父节点的左节点，那么其前驱为父节点
     * 2. 如果该节点是父节点的右节点，向上查找数据，一直节点是父节点的右子树节点
     *     a.如果父节点无左节点，那么父节点就是其前驱
     *     b.如果父节点有子树，那么其左子树最右节点为其前驱
     * @param parentTreeNode
     * @return
     */
    public static ParentTreeNode getPreorderStructDnode(ParentTreeNode parentTreeNode) {
        if (parentTreeNode == null) {
            return null;
        }



        ParentTreeNode curParentNode = parentTreeNode.parent;
        if (curParentNode != null && curParentNode.left == parentTreeNode){
            return curParentNode;
        }

        while (curParentNode != null){
            if (curParentNode.right == parentTreeNode){
                if (curParentNode.left == null){
                    return curParentNode;
                }else {
                    return getRightmost(curParentNode.left);
                }
            }
            parentTreeNode = curParentNode;
            curParentNode = curParentNode.parent;
        }

        return null;

    }

    private static ParentTreeNode getRightmost(ParentTreeNode parentTreeNode) {
        if (parentTreeNode.right == null && parentTreeNode.left == null){
            return parentTreeNode;
        }

        if (parentTreeNode.right != null){
            return getRightmost(parentTreeNode.right);
        }
        return getRightmost(parentTreeNode.left);
    }



    public static void main(String[] args) {
        ParentTreeNode head = new ParentTreeNode(6);
        head.parent = null;
//        head.left = new ParentTreeNode(3);
//        head.left.parent = head;
//        head.left.left = new ParentTreeNode(1);
//        head.left.left.parent = head.left;
//        head.left.left.right = new ParentTreeNode(2);
//        head.left.left.right.parent = head.left.left;
//        head.left.right = new ParentTreeNode(4);
//        head.left.right.parent = head.left;
//        head.left.right.right = new ParentTreeNode(5);
//        head.left.right.right.parent = head.left.right;
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
        ParentTreeNode test = null;
//        System.out.println(test.value + " next: " + getPreorderStructDnode(test).value);
//        test = head.left.left.right;
//        System.out.println(test.value + " next: " + getPreorderStructDnode(test).value);
//        test = head.left;
//        System.out.println(test.value + " next: " + getPreorderStructDnode(test).value);
//        test = head.left.right;
//        System.out.println(test.value + " next: " + getPreorderStructDnode(test).value);
//        test = head.left.right.right;
//        System.out.println(test.value + " next: " + getPreorderStructDnode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getPreorderStructDnode(test));
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getPreorderStructDnode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getPreorderStructDnode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getPreorderStructDnode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getPreorderStructDnode(test).value);


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
