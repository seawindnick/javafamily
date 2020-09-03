package com.java.study.offer.chapter5;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

@Data
public class Node {
    public Node nextNode;
    public Integer value;


    public static void main(String[] args) {
        Node node = new Node();
        node.setValue(1);

        Node heardNode = node;
        for (int i = 2; i < 10; i++) {
            Node secondNode = new Node();
            secondNode.setValue(i);
            secondNode.setNextNode(null);
            heardNode.setNextNode(secondNode);

            heardNode = secondNode;
        }

//        printLinkReverseOrderByList(node);

//        printLinkReverseOrderByStack(node);

        printLinkReverseOrderByRecursive(node);

//        Node searchNode = node;
//        do {
//            System.out.println(searchNode.value);
//            searchNode = searchNode.nextNode;
//        }while (Objects.nonNull(searchNode));
    }

    private static void printLinkReverseOrderByRecursive(Node node) {
        if (Objects.isNull(node)){
            return;
        }

        if (Objects.nonNull(node.nextNode)){
            printLinkReverseOrderByRecursive(node.nextNode);
        }
        System.out.println(node.getValue());
    }

    private static void printLinkReverseOrderByStack(Node node) {
        if (Objects.isNull(node)){
            return;
        }

        Stack<Node> stack = new Stack();
        do {
            stack.push(node);
            node = node.nextNode;
        }while (Objects.nonNull(node));

        while (!stack.empty()){
//            stack.peek();//取出顶部元素，不弹出
            Node tempNode = stack.pop();//取出顶部元素，弹出
            System.out.println(tempNode.getValue());
        }
    }

    private static void printLinkReverseOrderByList(Node node) {
        if (Objects.isNull(node)){
            return;
        }

        List<Node> list = new ArrayList<>();

        do {
            list.add(node);
            node = node.nextNode;
        }while (Objects.nonNull(node));

        for (int size = list.size() - 1; size >= 0; size--) {
            System.out.println(list.get(size).value);
        }
    }


}
