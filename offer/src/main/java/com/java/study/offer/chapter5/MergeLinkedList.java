package com.java.study.offer.chapter5;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.util.Objects;

public class MergeLinkedList {

    public static void main(String[] args) {
        Node rootNode1 = new Node(0, null);

        Node indexNode = rootNode1;
//        [0,1,3,5,7,9]
        for (int i = 1; i < 10; i = i + 2) {
            Node node = new Node(i, null);
            indexNode.setNext(node);
            indexNode = node;
        }

        Node rootNode2 = new Node(0, null);

        Node indexNode2 = rootNode2;
        //[0,1,4,7]
        for (int i = 1; i < 10; i = i + 3) {
            Node node = new Node(i, null);
            indexNode2.setNext(node);
            indexNode2 = node;
        }

        Node mergeNode = merge(rootNode1, rootNode2);
        while (mergeNode != null) {
            System.out.println(mergeNode.value);
            mergeNode = mergeNode.next;
        }
    }

        private static Node merge(Node rootNode1, Node rootNode2) {
        if (Objects.isNull(rootNode1)) {
            return rootNode2;
        }
        if (Objects.isNull(rootNode2)) {
            return rootNode1;
        }
        Node mergeHeader;
        if (rootNode1.value > rootNode2.value) {
            mergeHeader = rootNode2;
            mergeHeader.setNext(merge(rootNode1, rootNode2.next));
        } else {
            mergeHeader = rootNode1;
            mergeHeader.setNext(merge(rootNode1.next, rootNode2));
        }

        return mergeHeader;
    }
//
//
//    private static Node merge(Node rootNode1, Node rootNode2) {
//        if (Objects.isNull(rootNode1)) {
//            return rootNode2;
//        }
//        if (Objects.isNull(rootNode2)) {
//            return rootNode1;
//        }
//        Node beginNode = rootNode1;
//        Node endNode = rootNode2;
//        Node rootNode;
//
//        if (beginNode.value >= endNode.value) {
//            rootNode = endNode;
//            endNode = endNode.next;
//        } else {
//            rootNode = beginNode;
//            beginNode = beginNode.next;
//        }
//
//        Node tempRootNode = rootNode;
//        while (beginNode != null || endNode != null) {
//
//            if (beginNode == null) {
//                tempRootNode.setNext(endNode);
//                break;
//            }
//            if (endNode == null) {
//                tempRootNode.setNext(beginNode);
//                break;
//            }
//            if (beginNode.value >= endNode.value) {
//                tempRootNode.setNext(endNode);
//                endNode = endNode.next;
//            } else {
//                tempRootNode.setNext(beginNode);
//                beginNode = beginNode.next;
//            }
//            tempRootNode = tempRootNode.next;
//        }
//
//        return rootNode;
//
//    }


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
