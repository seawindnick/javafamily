package com.java.study.offer.chapter5;

import lombok.Data;

import java.util.Objects;


public class FindIndexNode {

    public static void main(String[] args) {
        Node rootNode = new Node(0, null);

        Node indexNode = rootNode;

        for (int i = 1; i < 10; i++) {
            Node node = new Node(i, null);
            indexNode.setNext(node);
            indexNode = node;
        }

        int index = 11;
        Node node = findNode(rootNode, index);
        if (Objects.isNull(node)){
            System.out.println("空数据");
        }else {
            System.out.println(node.getValue());
        }
    }

    private static Node findNode(Node rootNode, int index) {
        if (index < 0) {
            return null;
        }

        if (Objects.isNull(rootNode)) {
            return null;
        }


        Node firstStartNode = rootNode;
        Node secondStartNode = rootNode;

        for (int i = 0; i < (index - 1); i++) {
            if (firstStartNode.next != null){
                firstStartNode = firstStartNode.next;
            }else {
                return null;
            }
        }

        while (firstStartNode.next != null) {
            secondStartNode = secondStartNode.next;
            firstStartNode = firstStartNode.next;
        }

        return secondStartNode;

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
