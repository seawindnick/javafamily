package com.java.study.zuo.vedio.basic.chapter3;


import lombok.Data;
import lombok.var;

import java.util.Objects;
import java.util.Stack;

/**
 * <Description>
 * 判断链表是否是回文结构
 *
 * @author hushiye
 * @since 2020-08-22 16:59
 */
public class IsPalindromeList {


    public static boolean isPalindrome3(Node node) {
        if (node == null) {
            return Boolean.FALSE;
        }

        Stack<Node> stack = new Stack<>();
        var head = node;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (node != null) {
            if (!Objects.equals(node.getValue(), stack.pop().getValue())) {
                return Boolean.FALSE;
            }
            node = node.next;
        }
        return Boolean.TRUE;

    }


    public static boolean isPalindrome1(Node node) {
        if (node == null) {
            return Boolean.FALSE;
        }

        int length = 0;
        Node headNode = node;
        while (headNode != null) {
            length++;
            headNode = headNode.getNext();
        }

        Node[] nodes = new Node[length];

        int curIndex = 0;
        headNode = node;
        while (headNode != null) {
            nodes[curIndex++] = headNode;
            headNode = headNode.getNext();
        }

        int startIndex = 0;
        int endIndex = nodes.length - 1;
        while (startIndex <= endIndex) {
            if (!Objects.equals(nodes[startIndex++].getValue(), nodes[endIndex--].getValue())) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static boolean isPalindromeList2(Node node) {
        if (node == null) {
            return Boolean.FALSE;
        }

        Node fastNode = node;
        Node slowNode = node;

        while (fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
            fastNode = fastNode.getNext().getNext();
            slowNode = slowNode.getNext();
        }

        Node tempHeadNode = resverNode(slowNode);
        Node searchNode = tempHeadNode;
        Boolean equalsFlag = true;
        slowNode = node;
        while (slowNode != null && searchNode != null) {
            if (!Objects.equals(slowNode.getValue(), searchNode.getValue())) {
                equalsFlag = false;
                break;
            }
            slowNode = slowNode.getNext();
            searchNode = searchNode.getNext();
        }

        resverNode(tempHeadNode);
        return equalsFlag;

    }

    private static Node resverNode(Node slowNode) {
        Node preNode = null;
        Node curentNode = slowNode;
        while (curentNode != null) {
            Node nextNode = curentNode.getNext();
            curentNode.setNext(preNode);
            preNode = curentNode;
            curentNode = nextNode;
        }
        return preNode;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.getNext();
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindromeList2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }


    @Data
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
