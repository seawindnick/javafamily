package com.java.study.zuo.vedio.basic.chapter3;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 18:20
 */
public class SmallerEqualBigger {


    public static Node smallerEqualBigger(Node node, int targetValue) {
        if (node == null) {
            return null;
        }


        Node smallNode = null;
        Node smallHeadNode = null;

        Node equalsNode = null;
        Node equalsHeadNode = null;

        Node biggerNode = null;
        Node biggerHeadNode = null;

        while (node != null) {
            Node nextNode = node.next;
            node.setNext(null);
            if (node.value < targetValue) {
                if (smallHeadNode == null) {
                    smallHeadNode = node;
                } else {
                    smallNode.setNext(node);
                }
                smallNode = node;
            } else if (node.value == targetValue) {
                if (equalsHeadNode == null) {
                    equalsHeadNode = node;
                } else {
                    equalsNode.setNext(node);
                }
                equalsNode = node;
            } else {
                if (biggerHeadNode == null) {
                    biggerHeadNode = node;
                } else {
                    biggerNode.setNext(node);
                }
                biggerNode = node;
            }
            node = nextNode;
        }

        if (smallHeadNode != null){
            smallNode.setNext(equalsHeadNode);
            equalsNode = equalsNode == null ? smallNode : equalsNode;
        }
        if (equalsNode != null){
            equalsNode.setNext(biggerHeadNode);
        }


        return smallHeadNode != null ? smallHeadNode : equalsHeadNode != null ? equalsHeadNode : biggerHeadNode;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
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
        // head1 = listPartition1(head1, 4);
        head1 = smallerEqualBigger(head1, 7);
        printLinkedList(head1);

    }


}
