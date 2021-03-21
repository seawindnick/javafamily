package com.java.study.zuo.vedio.advanced.chapter1;

import java.util.Stack;

/**
 * <Description>
 * 二叉树转换成双向链表
 *
 * @author hushiye
 * @since 2020-09-07 08:45
 */
public class BSTtoDoubleLinkedList {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node convert1(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }

        return buildNode(node);
    }

    private static Node buildNode(Node node) {

        if (node == null) {
            return node;
        }

        Node leftNode = buildNode(node.left);

        Node rightNode = buildNode(node.right);

        node.right = null;
        node.left = null;


        Node leftLastNode = leftNode;
        while (leftLastNode != null && leftLastNode.right != null) {
            leftLastNode = leftLastNode.right;
        }
        node.left = leftLastNode;
        if (leftLastNode != null) {
            leftLastNode.right = node;
        }

        node.right = rightNode;
        if (rightNode != null) {
            rightNode.left = node;
        }

        return leftNode == null ? node : leftNode;
    }


    public static Node convert2(Node node) {

        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }
        Stack<Node> stack = new Stack<>();
        processInNode(node, stack);

        Node endNode = stack.pop();
        Node curNode = null;
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            curNode.left = null;
            curNode.right = null;

            endNode.left = curNode;
            curNode.right = endNode;
            endNode = curNode;
        }
        return curNode;

    }

    private static void processInNode(Node node, Stack<Node> stack) {
        if (node == null) {
            return;
        }

        processInNode(node.left, stack);
        stack.add(node);
        processInNode(node.right, stack);
    }


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
        head = convert1(head);
        printDoubleLinkedList(head);

        head = new Node(5);
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
        head = convert2(head);
        printDoubleLinkedList(head);

    }

}
