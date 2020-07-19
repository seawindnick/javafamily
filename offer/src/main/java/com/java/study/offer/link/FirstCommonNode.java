package com.java.study.offer.link;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class FirstCommonNode {


    public static void main(String[] args) {


        Node threeNode = new Node(3, null);
        Node fourNode = new Node(4, null);

        Node firstNode = new Node(1, fourNode);


        Node secondNode = new Node(2, threeNode);

//        Node firstCommonNode = findFirstCommonNode(firstNode, secondNode);
//        Node firstCommonNode = findFirstCommonNodeUseStack(firstNode, secondNode);

        Node firstCommonNode = findFirstCommonNodeUseLength(firstNode, secondNode);
        System.out.println(JSONObject.toJSONString(firstCommonNode));

    }

    private static Node findFirstCommonNodeUseLength(Node firstNode, Node secondNode) {
        if (firstNode == null || secondNode == null) {
            return null;
        }

        int firstLength = calculateLength(firstNode);
        int secondLength = calculateLength(secondNode);

        Node longNode = firstNode;
        Node shortNode = secondNode;
        if (firstLength < secondLength) {
            longNode = secondNode;
            shortNode = firstNode;
        }

        int lengthDifference = Math.abs(firstLength - secondLength);
        while (lengthDifference > 0) {
            longNode = longNode.next;
            lengthDifference--;
        }


        while (longNode != null && shortNode != null) {
            if (Objects.equals(longNode, shortNode)) {
                return longNode;
            }
            longNode = longNode.next;
            shortNode = shortNode.next;
        }

        return null;
    }

    private static int calculateLength(Node node) {
        int count = 0;
        do {
            count++;
        } while ((node = node.next) != null);

        return count;
    }

//    private static Node findFirstCommonNodeUseStack(Node firstNode, Node secondNode) {
//        if (firstNode == null || secondNode == null) {
//            return null;
//        }
//
//        Stack<Node> firstStack = buildStack(firstNode);
//        Stack<Node> secondStack = buildStack(secondNode);
//
//
//        Node commonNode = null;
//        while (!firstStack.isEmpty() && !secondStack.isEmpty()) {
//            Node firstEndNode = firstStack.pop();
//            Node secondEndNode = secondStack.pop();
//            if (firstEndNode != secondEndNode) {
//                break;
//            }
//
//            commonNode = firstEndNode;
//        }
//        return commonNode;
//    }
//
//    private static Stack buildStack(Node node) {
//        Stack stack = new Stack();
//        while (node != null) {
//            stack.push(node);
//            node = node.next;
//        }
//        return stack;
//    }

//    private static Node findFirstCommonNode(Node firstNode, Node secondNode) {
//        if (firstNode == null || secondNode == null){
//            return null;
//        }
//
//        Set<Node> firstNodeSet = new HashSet<>();
//
//        while (firstNode != null){
//            firstNodeSet.add(firstNode);
//            firstNode = firstNode.next;
//        }
//
//        while (secondNode != null){
//            if (firstNodeSet.contains(secondNode)){
//                return secondNode;
//            }
//            secondNode = secondNode.next;
//        }
//        return null;
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
