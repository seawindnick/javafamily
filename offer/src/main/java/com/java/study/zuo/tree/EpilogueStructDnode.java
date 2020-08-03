package com.java.study.zuo.tree;

/**
 * 后序遍历前驱节点
 */
public class EpilogueStructDnode {


    public static ParentTreeNode getEpilogueStructDnode(ParentTreeNode parentTreeNode) {

        if (parentTreeNode == null) {
            return null;
        }

        if (parentTreeNode.right != null) {
            return parentTreeNode.right;
        }

        if (parentTreeNode.left != null) {
            return parentTreeNode.left;
        }


        ParentTreeNode curParentTreeNode = parentTreeNode.parent;

        boolean flag = curParentTreeNode != null && curParentTreeNode.left != null && curParentTreeNode.right == parentTreeNode;

        while (curParentTreeNode != null){
            if (curParentTreeNode.left != null && curParentTreeNode.right == parentTreeNode){
                return curParentTreeNode.left;
            }
            parentTreeNode = curParentTreeNode;
            curParentTreeNode = curParentTreeNode.parent;
        }



        if (curParentTreeNode != null) {
            return curParentTreeNode.left;
        }

        return null;

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
        System.out.println(test.value + " next: " + getEpilogueStructDnode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getEpilogueStructDnode(test));
        test = head.left;
        System.out.println(test.value + " next: " + getEpilogueStructDnode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getEpilogueStructDnode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getEpilogueStructDnode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getEpilogueStructDnode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getEpilogueStructDnode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getEpilogueStructDnode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getEpilogueStructDnode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getEpilogueStructDnode(test).value);
//

    }
}
