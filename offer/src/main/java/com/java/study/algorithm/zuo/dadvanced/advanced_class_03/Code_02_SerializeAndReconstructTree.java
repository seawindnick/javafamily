package com.java.study.algorithm.zuo.dadvanced.advanced_class_03;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 * 【题目】 二叉树被记录成文件的过程叫作二叉树的序列化，通过文件内 容重建原来二叉树的过程叫作二叉树的反序列化。
 * 给定一棵二 叉树的头节点head，并已知二叉树节点值的类型为32位整型。
 * 请设计一种二叉树序列化和反序列化的方案，并用代码实现。
 * 【要求】
 * 1，实现先序遍历序列化与反序列化
 * 2，实现按层遍历序列化与反序列化
 */
public class Code_02_SerializeAndReconstructTree {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    /**
     * 先序遍历序列化
     *
     * @param root
     * @return
     */
    public static String serialByPre(Node root) {
        if (root == null) {
            return "#_";
        }

        Integer indexValue = root.value;
        String str = String.valueOf(indexValue) + "_";

        String left = serialByPre(root.left);
        String right = serialByPre(root.right);

        return str + left + right;

    }


    /**
     * 先序遍历反序列化
     *
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public static Node reconByPreString2(String data) {
        if (data == null) {
            return null;
        }

        String[] arr = data.split("_");

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }


        Node node = buildNode(queue);
        return node;
    }


    private static Node buildNode(Queue<String> queue) {
        String indexValue = queue.poll();
        if (indexValue.equals("#")) {
            return null;
        }

        Node node = new Node(Integer.parseInt(indexValue));
        Node left = buildNode(queue);
        Node right = buildNode(queue);
        node.left = left;
        node.right = right;

        return node;
    }


    /**
     * 先序遍历反序列化
     *
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public static Node reconByPreString(String data) {
        if (data == null) {
            return null;
        }

        String[] arr = data.split("_");

        NodeIndex node = buildNode(arr, 0);
        return node.node;
    }

    private static NodeIndex buildNode(String[] arr, int start) {
        NodeIndex nodeIndex = new NodeIndex();
        nodeIndex.index = start;
        if (arr[start].equals("#")) {
            return nodeIndex;
        }

        String indexValue = arr[start];
        Node node = new Node(Integer.parseInt(indexValue));

        NodeIndex leftIndex = buildNode(arr, start + 1);
        node.left = leftIndex.node;

        NodeIndex rightIndex = buildNode(arr, leftIndex.index + 1);
        nodeIndex.index = rightIndex.index;

        node.right = rightIndex.node;

        nodeIndex.node = node;
        return nodeIndex;
    }

    public static class NodeIndex {
        private Node node;
        private Integer index;
    }


    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = null;
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString2(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString2(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString2(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString2(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString2(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString2(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString2(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString2(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

    }


    private static Node reconByLevelString2(String data) {
        if (data == null || data.equals("#")) {
            return null;
        }

        String[] arr = data.split("_");


        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        Queue<Node> nodeLinkedList = new LinkedList<>();
        Node root = new Node(Integer.parseInt(queue.poll()));
        nodeLinkedList.add(root);
        while (!queue.isEmpty()) {
            Node parentNode = nodeLinkedList.poll();
            String left = queue.poll();
            if (!left.equals("#")) {
                Node leftNode = new Node(Integer.parseInt(left));
                parentNode.left = leftNode;
                nodeLinkedList.add(leftNode);
            }

            String right = queue.poll();
            if (!right.equals("#")) {
                Node rightNode = new Node(Integer.parseInt(right));
                parentNode.right = rightNode;
                nodeLinkedList.add(rightNode);
            }

        }

        return root;
    }

    private static Node reconByLevelString(String data) {
        if (data == null || data.equals("#")) {
            return null;
        }

        String[] arr = data.split("_");

        LinkedList<Node> nodeLinkedList = new LinkedList<>();

        Node root = new Node(Integer.parseInt(arr[0]));
        nodeLinkedList.add(root);
        int index = 1;
        while (index < arr.length) {
            Node parentNode = nodeLinkedList.pop();
            String left = arr[index++];
            if (!left.equals("#")) {
                Node leftNode = new Node(Integer.parseInt(left));
                nodeLinkedList.add(leftNode);
                parentNode.left = leftNode;
            }

            String right = arr[index++];
            if (!right.equals("#")) {
                Node rightNode = new Node(Integer.parseInt(right));
                nodeLinkedList.add(rightNode);
                parentNode.right = rightNode;
            }

        }

        return root;
    }

    private static String serialByLevel(Node head) {
        if (head == null) {
            return "#";
        }

        LinkedList<Node> traverseList = new LinkedList<>();

        traverseList.add(head);

        StringBuilder stringBuilder = new StringBuilder();
        while (!traverseList.isEmpty()) {
            Node node = traverseList.pop();
            String str = node == null ? "#_" : node.value + "_";
            stringBuilder.append(str);

            if (node != null) {
                traverseList.add(node.left);
                traverseList.add(node.right);
            }

        }
        return stringBuilder.toString();
    }


}