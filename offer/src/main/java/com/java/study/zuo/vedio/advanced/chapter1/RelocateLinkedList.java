package com.java.study.zuo.vedio.advanced.chapter1;

import com.java.study.zuo.linkedList.Node;

/**
 * <Description>
 * 链表调整
 *
 * @author hushiye
 * @since 2020-08-31 23:25
 */
public class RelocateLinkedList {


    public static void relocateLinkedList(Node head) {
        if (head == null || head.next == null || head.next.next == null || head.next.next.next == null) {
            return;
        }

        Node mid = head;
        Node right = head.next;
        //获取中间元素位置信息
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }

        right = mid.next;
        mid.next = null;

        // 两个链表进行合并
        mergeLR(head, right);
    }

    private static void mergeLR(Node left, Node right) {

        while (left.next != null) {
            Node rightNext = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = rightNext;
        }
        left.next = right;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void relocateLinkedList2(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        Node tempHead = head;
        int length = 0;
        while (tempHead != null) {
            length++;
            tempHead = tempHead.next;
        }

        Node[] nodes = new Node[length];
        tempHead = head;
        int curIndex = 0;
        while (tempHead != null) {
            nodes[curIndex++] = tempHead;
            tempHead = tempHead.next;
        }

        int mid = length / 2;
        Node[] help = new Node[length];

        int leftIndex = 0;
        int rightIndex = mid;
        int index = 0;
        while (leftIndex < mid) {
            help[index++] = nodes[leftIndex++];
            help[index++] = nodes[rightIndex++];
        }

        while (rightIndex < help.length) {
            help[index++] = nodes[rightIndex++];
        }

        for (int i = 1; i < help.length; i++) {
            help[i - 1].next = help[i];
        }

    }


    public static void main(String[] args) {
        Node head = null;
        relocateLinkedList2(head);
        printLinkedList(head);

        head = new Node(1);
        relocateLinkedList2(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        relocateLinkedList2(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        relocateLinkedList2(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        relocateLinkedList2(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        relocateLinkedList2(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        relocateLinkedList2(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        relocateLinkedList2(head);
        printLinkedList(head);

    }
}
