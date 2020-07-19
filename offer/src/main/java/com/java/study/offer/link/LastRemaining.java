package com.java.study.offer.link;

import lombok.Data;

public class LastRemaining {


    public static void main(String[] args) {
        Node node1 = new Node(1, null);

        Node node2 = new Node(2, null);

        Node node3 = new Node(3, null);

        Node node4 = new Node(4, null);

        Node node5 = new Node(5, null);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node1);


        Node remainNode = findRemainNode(node1, 3);
        System.out.println(remainNode.value);

    }

    private static Node findRemainNode(Node node, int deleteNum) {
        int startIndex = 1;
        Node preNode = node;
        while (node.next != node) {
            for (; startIndex < deleteNum; startIndex++) {
                preNode = node;
                node = node.next;
            }

            Node nextNode = node.next;
            preNode.setNext(nextNode);
            node = nextNode;
            startIndex = 1;
        }
        return node;
    }


    @Data
    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
