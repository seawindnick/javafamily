package com.java.study.zuo.linkedList;

import java.util.Stack;

/**
 * 判断是否是回文
 */
public class IsPalindromeList {


    public static boolean isPalindromeListUseStack(Node node) {
        if (node == null) {
            return Boolean.FALSE;
        }


        Stack<Node> stack = new Stack<>();
        Node tempNode = node;
        while (tempNode != null) {
            stack.push(tempNode);
            tempNode = tempNode.next;
        }

        while (node != null) {
            if (stack.pop().value != node.value) {
                return Boolean.FALSE;
            }
            node = node.next;
        }
        return Boolean.TRUE;
    }


    public static Boolean isPalindromeListUseReverseList(Node node) {

        if (node == null) {
            return Boolean.FALSE;
        }


        Node slowNode = node;
        Node fastNode = node;
        //slow为中间位置节点
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        //逆转 slow与node End之间的链表顺序
        Node reverseNode = revserNode(slowNode);
        Node tempNode = reverseNode;

        Node tempHead = node;
        Boolean isPalindromeLisFlag = true;
        while (tempHead != null && tempNode != null){
            if (tempHead.value != tempNode.value){
                isPalindromeLisFlag = false;
                break;
            }
            tempHead = tempHead.next;
            tempNode = tempNode.next;
        }
        revserNode(reverseNode);

        return isPalindromeLisFlag;
    }

    private static Node revserNode(Node gapNode) {
        Node preNode = null;
        Node curNode = gapNode;
        while (curNode != null){
            Node nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
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
        System.out.print(isPalindromeListUseStack(head) + " | ");
        System.out.println(isPalindromeListUseReverseList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeListUseStack(head) + " | ");
        System.out.println(isPalindromeListUseReverseList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindromeListUseStack(head) + " | ");
        System.out.println(isPalindromeListUseReverseList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeListUseStack(head) + " | ");
        System.out.println(isPalindromeListUseReverseList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindromeListUseStack(head) + " | ");
        System.out.println(isPalindromeListUseReverseList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeListUseStack(head) + " | ");
        System.out.println(isPalindromeListUseReverseList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeListUseStack(head) + " | ");
        System.out.println(isPalindromeListUseReverseList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeListUseStack(head) + " | ");
        System.out.println(isPalindromeListUseReverseList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindromeListUseStack(head) + " | ");
        System.out.println(isPalindromeListUseReverseList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }


}
