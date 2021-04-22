package com.java.study.algorithm.zuo.abasic.basic_class_03;

/**
 * 判断一个链表是否为回文结构
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回文结构。
 * 例如:
 * 1->2->1，返回true。
 * 1->2->2->1，返回true。
 * 15->6->15，返回true。
 * 1->2->3，返回false。
 * 进阶: 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 */
public class Code_11_IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


//    public static Boolean IsPalindromeList(Node node) {
//        if (node == null || node.next == null) {
//            return Boolean.TRUE;
//        }
//
//        Node slowNode = node;
//        Node fastNode = node;
//
//        while (fastNode != null && fastNode.next != null) {
//            slowNode = slowNode.next;
//            fastNode = fastNode.next.next;
//        }
//
//
//        Node afterHalfShouldReversedNode = slowNode.next;
//        slowNode.next = null;
//
//        Node afterHalfReversedNode = resverNode(afterHalfShouldReversedNode);
//        Node checkNode = afterHalfReversedNode;
//
//        Boolean flag = true;
//
//        Node checkHeadNode = node;
//        while (checkNode != null && checkHeadNode != null) {
//            if (checkHeadNode.value != checkNode.value) {
//                flag = false;
//                break;
//            }
//            checkNode = checkNode.next;
//            checkHeadNode = checkHeadNode.next;
//        }
//
//        slowNode.next = resverNode(afterHalfReversedNode);
//
//        return flag;
//
//    }

    public static Boolean IsPalindromeList(Node node) {
        if (node == null || node.next == null) {
            return Boolean.TRUE;
        }

        Node slowNode = node;
        Node fastNode = node.next;

        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }


        Node afterHalfShouldReversedNode = slowNode.next;
        slowNode.next = null;

        Node afterHalfReversedNode = resverNode(afterHalfShouldReversedNode);
        Node checkNode = afterHalfReversedNode;

        Boolean flag = true;

        Node checkHeadNode = node;
        while (checkNode != null && checkHeadNode != null) {
            if (checkHeadNode.value != checkNode.value) {
                flag = false;
                break;
            }
            checkNode = checkNode.next;
            checkHeadNode = checkHeadNode.next;
        }

        slowNode.next = resverNode(afterHalfReversedNode);

        return flag;

    }


//    public static Boolean IsPalindromeList(Node node) {
//        if (node == null || node.next == null) {
//            return Boolean.TRUE;
//        }
//
//
//        Node headNode = node;
//
//        Node slowNode = node;
//        Node fastNode = node;
//
//        while (fastNode != null && fastNode.next != null && fastNode.next.next != null) {
//            slowNode = slowNode.next;
//            fastNode = fastNode.next.next;
//        }
//
//        Node newSecondNode = slowNode.next;
//        Node newHeadNode = headNode;
//        slowNode.next = null;
//
//
//        Node reverseNodeHead = resverNode(newSecondNode);
//        Node newReverseNodeHead = reverseNodeHead;
//        Boolean flag = true;
//        while (newReverseNodeHead != null && newHeadNode != null) {
//            if (newReverseNodeHead.value != newHeadNode.value) {
//                flag = false;
//                break;
//            }
//            newHeadNode = newHeadNode.next;
//            newReverseNodeHead = newReverseNodeHead.next;
//
//        }
//
//        reverseNodeHead = resverNode(reverseNodeHead);
//        slowNode.next = reverseNodeHead;
//
//        return flag;
//    }

    private static Node resverNode(Node tempNode) {
        Node preNode = null;
        while (tempNode != null) {
            Node nextNode = tempNode.next;
            tempNode.next = preNode;
            preNode = tempNode;
            tempNode = nextNode;
        }

        return preNode;

    }


    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(IsPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindromeList(head) + " | ");

        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(IsPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(IsPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(IsPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }


}