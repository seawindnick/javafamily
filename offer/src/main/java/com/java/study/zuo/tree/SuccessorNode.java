package com.java.study.zuo.tree;

import lombok.Data;

/**
 * 查询二叉树后记节点
 * 中序遍历，该节点的下一个节点是后继节点
 * 节点多一个指向父节点指针，头节点的parent指向null
 */
public class SuccessorNode {


    public static Node getSuccessorNode(Node node){
        if (node == null){
            return null;
        }

        if (node.right != null){
            return findLeftmost(node.right);
        }else {
            Node parent = node.getParent();
            while (parent != null && parent.left != node){
                parent = parent.parent;
                node = node.parent;
            }
            return parent;
        }

    }

    private static Node findLeftmost(Node node) {
        if (node.left == null){
            return node;
        }
        return findLeftmost(node.left);
    }

    public static Node getStructDnode(Node node){
        if (node == null){
            return null;
        }

        if (node.left != null){
            return findRightmost(node.left);
        }else {
            Node parentNode = node.parent;
            while (parentNode != null && parentNode.right != node){
                parentNode = parentNode.parent;
                node = node.parent;
            }
            return parentNode;
        }

    }

    private static Node findRightmost(Node node) {
        if (node.right == null){
            return node;
        }
        return findRightmost(node.right);
    }


    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;


        /**
         * 后继节点最后一个为空
         */
        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));


        /**
         * 前驱节点第一个为空
         */
        test = head.left.left;
        System.out.println(test.value + " next: " + getStructDnode(test));
        test = head.left.left.right;
        test = head.left;
        System.out.println(test.value + " next: " + getStructDnode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getStructDnode(test).value);
        test = head.left.right.right;        System.out.println(test.value + " next: " + getStructDnode(test).value);

        System.out.println(test.value + " next: " + getStructDnode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getStructDnode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getStructDnode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getStructDnode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getStructDnode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getStructDnode(test).value);
    }






    @Data
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }
}
