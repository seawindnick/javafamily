package com.java.study.zuo.vedio.basic.chapter3;

import lombok.Data;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 16:49
 */
public class PrintPublicNode {


    public static void printPublicNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        while (node1 != null && node2 != null) {
            if (node1.value == node2.value) {
                System.out.println(node1.value);
                node1 = node1.next;
                node2 = node2.next;
            } else if (node1.value > node2.value) {
                node2 = node2.next;
            } else {
                node1 = node1.next;
            }
        }


    }


    @Data
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
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
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printPublicNode(node1, node2);

    }

}
