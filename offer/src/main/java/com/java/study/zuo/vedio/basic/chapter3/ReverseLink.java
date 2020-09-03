package com.java.study.zuo.vedio.basic.chapter3;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 23:43
 */
public class ReverseLink {

    public static Node reverseSingleNode(Node node) {
        if (node == null) {
            return null;
        }


        Node pre = null;
        Node indexNode = node;
        while (indexNode != null) {
            Node next = indexNode.next;
            indexNode.setNext(pre);
            pre = indexNode;
            indexNode = next;
        }
        return pre;

    }


    public static DoubleNode reverseDoubleNode(DoubleNode doubleNode) {
        if (doubleNode == null) {
            return null;
        }

        DoubleNode pre = null;
        DoubleNode next = null;

        while (doubleNode != null) {
            next = doubleNode.next;
            doubleNode.next = pre;
            doubleNode.last = next;

            pre = doubleNode;
            doubleNode = next;
        }

        return pre;

    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseSingleNode(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseDoubleNode(head2));

    }

}
