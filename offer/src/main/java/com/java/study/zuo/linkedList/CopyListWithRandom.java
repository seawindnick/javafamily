package com.java.study.zuo.linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node copyListWithRandom(Node node){
        if (node == null){
            return node;
        }


        Map<Node,Node> oldNodeAndNewNodeMap = new HashMap<>();
        Node  copyNewNode = node;
        while (copyNewNode != null){
            Node newNode = new Node(copyNewNode.value);
            oldNodeAndNewNodeMap.put(copyNewNode,newNode);
            copyNewNode = copyNewNode.next;
        }

        for (Map.Entry<Node, Node> nodeNodeEntry : oldNodeAndNewNodeMap.entrySet()) {
            Node oldNode = nodeNodeEntry.getKey();
            Node newNode = nodeNodeEntry.getValue();
            if (Objects.nonNull(oldNode.next)){
                newNode.next = oldNodeAndNewNodeMap.get(oldNode.next);
            }

            if (Objects.nonNull(oldNode.rand)){
                newNode.rand = oldNodeAndNewNodeMap.get(oldNode.rand);
            }

        }
        return oldNodeAndNewNodeMap.get(node);
    }


    public static Node copyListWithRandom2(Node node){
        if (node == null){
            return null;
        }


        Node copyNode = node;
        while (copyNode != null){
            Node nextNode = copyNode.next;
            Node newNode = new Node(copyNode.value);
            newNode.next = nextNode;
            copyNode.next = newNode;
            copyNode = nextNode;
        }

        Node initRanNode = node;
        while (initRanNode != null){
            if (initRanNode.rand != null){
                initRanNode.next.rand = initRanNode.rand.next;
            }
            initRanNode = initRanNode.next.next;
        }

        Node spiltNode = node;
        Node newNodeHead = spiltNode.next;

        while (spiltNode != null){
            Node newNode = spiltNode.next;
            Node oldNode = spiltNode.next.next;

            //旧链表相连
            spiltNode.next = oldNode;
            if (oldNode != null){
                newNode.next = oldNode.next;
            }
            spiltNode = oldNode;
        }

        return newNodeHead;

    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
//        printRandLinkedList(head);
//        res1 = copyListWithRandom(head);
//        printRandLinkedList(res1);
//        res2 = copyListWithRandom2(head);
//        printRandLinkedList(res2);
//        printRandLinkedList(head);
//        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRandom(head);
        printRandLinkedList(res1);
        res2 = copyListWithRandom2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }



}
