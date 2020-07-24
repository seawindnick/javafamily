package com.java.study.zuo.linkedList;

/**
 * 给定单向链表头节点head,给定一个整数，要求左部分小于给定值，中间部分等于给定值，右边部分大于给定值
 */
public class SmallerEqualBigger {

    public static Node smallerEqualBigger(Node node, int targetValue) {


        Node smallHeadNode = null;
        Node smallEndNode = null;

        Node equalsHeadNode = null;
        Node equalsEndNode = null;

        Node biggerHeadNode = null;
        Node biggerEndNoe = null;

        Node headNode = node;
        while (headNode != null) {
            //精髓
            Node next = headNode.next;
            headNode.setNext(null);
            if (headNode.value < targetValue) {
                if (smallHeadNode == null) {
                    smallHeadNode = headNode;
                } else {
                    smallEndNode.setNext(headNode);
                }
                smallEndNode = headNode;

            } else if (headNode.value == targetValue) {

                if (equalsHeadNode == null) {
                    equalsHeadNode = headNode;
                } else {
                    equalsEndNode.setNext(headNode);
                }
                equalsEndNode = headNode;
            } else {

                if (biggerHeadNode == null) {
                    biggerHeadNode = headNode;
                } else {
                    biggerEndNoe.setNext(headNode);
                }
                biggerEndNoe = headNode;
            }
            headNode = next;
        }

        //链表拼接，精髓
        if (smallEndNode != null) {
            smallEndNode.setNext(equalsHeadNode);

            equalsEndNode = equalsEndNode == null ? smallEndNode : equalsEndNode;
        }

        if (equalsEndNode != null) {
            equalsEndNode.setNext(biggerHeadNode);
        }

        return smallHeadNode != null ? smallHeadNode : equalsHeadNode != null ? equalsHeadNode : biggerHeadNode;

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
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = smallerEqualBigger(head1, 5);
        printLinkedList(head1);

    }


}
