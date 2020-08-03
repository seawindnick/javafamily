package com.java.study.zuo.tree;

/**
 * 后序遍历，后继节点
 *
 * 1. 如果该节点是父节点的右子树，那么其后驱节点为父节点
 * 2. 如果该节点是父节点的左子树
 *    a. 父节点无右子树，其后驱为父节点
 *    b. 父节点有右子树，其后驱为父节点右子树的 最左/最右节点
 */
public class EpilogueSuccessorNode {



    public static ParentTreeNode getEpilogueSuccessorNode(ParentTreeNode parentTreeNode){

        if (parentTreeNode == null){
            return null;
        }


        ParentTreeNode curParentNode = parentTreeNode.parent;
        if (curParentNode == null){
            return null;
        }

        //如果节点是父节点的左子树，获取右子树最左的节点
        if (curParentNode.left == parentTreeNode){
            if (curParentNode.right == null){
                return curParentNode;
            }else {
                return getLeftMost(curParentNode.right);
            }
        }

        return curParentNode;
    }

    private static ParentTreeNode getLeftMost(ParentTreeNode parentTreeNode) {
        if (parentTreeNode.right == null && parentTreeNode.left == null){
            return parentTreeNode;
        }

        if (parentTreeNode.left != null){
            return getLeftMost(parentTreeNode.getLeft());
        }

        return getLeftMost(parentTreeNode.getRight());
    }


    public static void print(ParentTreeNode parentTreeNode){
        if (parentTreeNode == null){
            return;
        }

        print(parentTreeNode.left);
        print(parentTreeNode.right);
        System.out.println(parentTreeNode.value);
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


        print(head);

        /**
         * 后继节点最后一个为空
         */
        ParentTreeNode test = head.left.left;
        System.out.println(test.value + " next: " + getEpilogueSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getEpilogueSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getEpilogueSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getEpilogueSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getEpilogueSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getEpilogueSuccessorNode(test));
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getEpilogueSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getEpilogueSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getEpilogueSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getEpilogueSuccessorNode(test).value);
//

    }
}
