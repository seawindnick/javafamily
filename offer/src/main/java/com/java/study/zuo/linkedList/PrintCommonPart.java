package com.java.study.zuo.linkedList;

/**
 * 打印两个有序链表的公共部分
 * <p>
 * 有序链表，说明不能构成环？
 */
public class PrintCommonPart {


    private static void printCommonPart(Node node1, Node node2) {
        while (node1 != null && node2 != null){
            if (node1.value < node2.value){
                node1 = node1.next;
            }else if (node1.value > node2.value){
                node2 = node2.next;
            }else {
                System.out.println(node1.value);
                node1 = node1.next;
                node2 = node2.next;
            }

        }

    }




//    public static void printCommonPart(Node head1, Node head2) {
//        if (head1 == null || head2 == null) {
//            return;
//        }
//
//
//        Node endNode1 = null;
//        int length1 = 0;
//        Node tempHead1 = head1;
//        while (tempHead1 != null) {
//            length1++;
//            endNode1 = tempHead1;
//            tempHead1 = tempHead1.next;
//        }
//
//        Node endNode2 = null;
//        int length2 = 0;
//        Node tempNode2 = head2;
//        while (tempNode2 != null) {
//            length2++;
//            endNode2 = tempNode2;
//            tempNode2 = tempNode2.next;
//        }
//
//        if (endNode2 != endNode1) {
//            return;
//        }
//
//        Node longNode = length1 > length2 ? head1 : head2;
//        Node shortNode = length1 > length2 ? head2 : head1;
//
//        int i = 0;
//        while (i < Math.abs(length1-length2)){
//            longNode = longNode.next;
//        }
//
//        while (longNode != shortNode){
//            longNode = longNode.next;
//            shortNode =shortNode.next;
//        }
//
//        while (longNode != null){
//            System.out.println(longNode.value);
//        }
//
//    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(7);
        node1.next.next.next.next = new Node(8);


        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1, node2);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }


}
