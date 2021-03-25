package com.java.study.algorithm.zuo.abasic.basic_class_03;

/**
 * 打印两个有序链表的公共部分
 * 【题目】 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 */
public class Code_10_PrintCommonPart {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void PrintCommonPart(Node firstNode, Node secondNode) {
        if (firstNode == null || secondNode == null){
            return;
        }

        while (firstNode != null && secondNode != null){

            if (firstNode.value == secondNode.value){
                System.out.println(firstNode.value);
                firstNode = firstNode.next;
                secondNode = secondNode.next;
            }else if (firstNode.value < secondNode.value){
                firstNode = firstNode.next;
            }else {
                secondNode = secondNode.next;
            }

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
        PrintCommonPart(node1, node2);

    }


}