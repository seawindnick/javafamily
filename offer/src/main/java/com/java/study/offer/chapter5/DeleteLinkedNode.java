package com.java.study.offer.chapter5;

import lombok.Data;

import java.util.Objects;

public class DeleteLinkedNode {

    public static void main(String[] args) {
        Node rootNode = new Node(0,null);

        Node indexNode = rootNode;

        for (int i = 1; i < 10; i++) {
            Node node = new Node(i,null);
            indexNode.setNext(node);
            indexNode = node;
        }


        Node deleteNode = rootNode;

        for (int i = 0; i < 5; i++) {
            deleteNode = deleteNode.next;
        }

        rootNode = deleteNode(rootNode,deleteNode);

        Node searchNode = rootNode;
        while (searchNode != null){
            System.out.println(searchNode.getValue());
            searchNode = searchNode.next;
        }

    }

    private static Node deleteNode(Node rootNode, Node deleteNode) {
        if (Objects.isNull(rootNode) || Objects.isNull(deleteNode)){
            return rootNode;
        }

        if (rootNode == deleteNode){
            Node nextNode = deleteNode.next;
            rootNode = nextNode;
            return rootNode;
        }


        //删除最后一个元素
        if (deleteNode.next == null){
            Node preNode = rootNode;
            while (preNode.next != deleteNode){
                preNode = preNode.next;
            }
            preNode.next = null;
            return rootNode;
        }

        Node nextNode = deleteNode.next;
        deleteNode.next = nextNode.next;
        deleteNode.value = nextNode.value;

        return rootNode;

    }


    @Data
    private static class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
