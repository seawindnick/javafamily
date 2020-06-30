package com.java.study.offer.link;

import lombok.Data;

public class ReverseList {

    public static void main(String[] args) {
        Node rootNode = new Node(0, null);

        Node indexNode = rootNode;

        for (int i = 1; i < 10; i++) {
            Node node = new Node(i, null);
            indexNode.setNext(node);
            indexNode = node;
        }

        Node newNode = reverse(rootNode);
        System.out.println(newNode.value);
    }

    private static Node reverse(Node rootNode) {
        if (rootNode == null) {
            return null;
        }

        Node preNode = null;
        Node indexNode = rootNode;

        while (indexNode != null) {
            Node nextNode = indexNode.next;
            indexNode.setNext(preNode);
            if (nextNode == null) {
                break;
            }
            preNode = indexNode;
            indexNode = nextNode;
        }

        return indexNode;
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
