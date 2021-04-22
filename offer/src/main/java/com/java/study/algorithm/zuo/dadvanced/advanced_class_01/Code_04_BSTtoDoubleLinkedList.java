package com.java.study.algorithm.zuo.dadvanced.advanced_class_01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 把一棵搜索二叉树，转化成有序的双向链表。
 */
public class Code_04_BSTtoDoubleLinkedList {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }




    public static Node conver(Node node) {
        //中序遍历，获取所有元素节点
        Queue<Node> queue = new LinkedList<>();
        fullNode(node, queue);

        Node headNode = queue.poll();
        Node preNode = headNode;
        while (!queue.isEmpty()) {
            Node nextNode = queue.poll();
            preNode.right = nextNode;
            nextNode.left = preNode;

            preNode = nextNode;
        }

        preNode.right = null;
        return headNode;
    }

    private static void fullNode(Node node, Queue<Node> queue) {
        if (node == null) {
            return;
        }
        fullNode(node.left, queue);
        queue.add(node);
        fullNode(node.right, queue);
    }


//    public static Node conver(Node node) {
//        if (node == null) {
//            return null;
//        }
//
//        converNode(node);
//
//        Node leftNode = node;
//        while (leftNode.left != null) {
//            leftNode = leftNode.left;
//        }
//
//        return leftNode;
//
//    }
//
//    private static Node converNode(Node node) {
//        Node left = conver(node.left);
//        Node right = conver(node.right);
//
//        if (left != null) {
//            left.right = node;
//            node.left = left;
//        }
//
//        if (right != null) {
//            node.right = right;
//            right.left = node;
//        }
//
//        return right == null ? node : right;
//    }

    public static void printBSTInOrder(Node head) {
        System.out.print("BST in-order: ");
        if (head != null) {
            inOrderPrint(head);
        }
        System.out.println();
    }

    public static void inOrderPrint(Node head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.value + " ");
        inOrderPrint(head.right);
    }

    public static void printDoubleLinkedList(Node head) {
        System.out.print("Double Linked List: ");
        Node end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.right;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.left;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = conver(head);
        printDoubleLinkedList(head);

//        head = new Node(5);
//        head.left = new Node(2);
//        head.right = new Node(9);
//        head.left.left = new Node(1);
//        head.left.right = new Node(3);
//        head.left.right.right = new Node(4);
//        head.right.left = new Node(7);
//        head.right.right = new Node(10);
//        head.left.left = new Node(1);
//        head.right.left.left = new Node(6);
//        head.right.left.right = new Node(8);
//
//        printBSTInOrder(head);
//        head = conver(head);
//        printDoubleLinkedList(head);

    }


}