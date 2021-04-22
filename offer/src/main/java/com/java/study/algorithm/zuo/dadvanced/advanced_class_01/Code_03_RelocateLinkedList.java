package com.java.study.algorithm.zuo.dadvanced.advanced_class_01;

/**
 * 给定一个链表list， 如果:
 * list =  1 调整之后1。
 * list = 1->2 调整之后1->2
 * list = 1->2->3 调整之后1->2->3
 * list = 1->2->3->4 调整之后1->3->2->4
 * list = 1->2->3->4->5 调整之后1->3->2->4->5
 * list = 1->2->3->4->5->6 调整之后1->4->2->5->3->6
 * list = 1->2->3->4->5->6->7 调整之后1->4->2->5->3->6->7
 * <p>
 * 根据上面的规律，调整一个任意长度的链表。
 */
public class Code_03_RelocateLinkedList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static Node relocate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node midNode = head;
        Node rightNode = head.next;
        while (rightNode.next != null && rightNode.next.next != null) {
            midNode = midNode.next;
            rightNode = rightNode.next.next;
        }

        rightNode = midNode.next;
        midNode.next = null;
        merge(head, rightNode);
        return head;
    }

    private static void merge(Node leftNode, Node rightNode) {

        while (leftNode.next != null) {
            Node rightNextNode = rightNode.next;
            Node leftNextNode = leftNode.next;

            leftNode.next = rightNode;
            rightNode.next = leftNextNode;

            rightNode = rightNextNode;
            leftNode = leftNextNode;
        }
        leftNode.next = rightNode;
    }

    public static Node relocate2(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node tempNode = node;
        int count = 0;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }

        Node[] arr = new Node[count];
        int curIndex = 0;
        while (node != null) {
            arr[curIndex++] = node;
            node = node.next;
        }

        int centerIndex = (count & 1) == 0 ? count / 2 : (count - 1) / 2;
        Node[] result = new Node[count];
        // 表示需要处理的长度
        int tempLength = centerIndex * 2;
        for (int i = 0; i < tempLength; i++) {
            if (i < centerIndex) {
                result[2 * i] = arr[i];
            } else {
                result[(i - centerIndex) * 2 + 1] = arr[i];
            }
        }

        if (tempLength != count) {
            result[tempLength] = arr[tempLength];
        }

        for (int i = 1; i < count; i++) {
            result[i - 1].next = result[i];
        }

        return result[0];
    }


    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = null;
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        relocate(head);
        printLinkedList(head);

    }

}