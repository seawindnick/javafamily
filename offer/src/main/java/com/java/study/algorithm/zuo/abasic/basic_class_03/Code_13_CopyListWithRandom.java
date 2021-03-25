package com.java.study.algorithm.zuo.abasic.basic_class_03;

/**
 * 复制含有随机指针节点的链表
 * 【题目】
 * 一种特殊的链表节点类描述如下:
 * public class Node {
 * public int value;
 * public Node next;
 * public Node rand;
 * public Node(int data) {
 * this.value = data;
 * } }
 * <p>
 * <p>
 * 题目十三
 * Node类中的value是节点值，next指针和正常单链表中next指针的意义一 样，都指向下一个节点，rand指针是Node类中新增的指针，
 * 这个指针可 能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个 函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
 * 进阶:不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N)内完成原问题要实现的函数。
 */
public class Code_13_CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;
        public String str;

        public Node(int data) {
            this.value = data;
        }

        public static Node buildCopyNode(int data) {
            Node node = new Node(data);
            node.str = "复制" + data;
            return node;
        }
    }

    public static Node copyListWithRandom(Node node) {
        if (node == null) {
            return null;
        }

        copyNode(node);
        copyRandom(node);
        Node copyHeadNode = node.next;
        spiltNode(node);
        return copyHeadNode;

    }

    /**
     * 链表分割
     *
     * @param node
     */
    private static void spiltNode(Node node) {
        while (node != null) {
            Node copyNode = node.next;
            Node oldNextNode = copyNode.next;

            node.next = oldNextNode;
            copyNode.next = oldNextNode == null ? null : oldNextNode.next;

            node = oldNextNode;
        }
    }

    private static void copyRandom(Node headNode) {
        while (headNode != null) {
            Node copyNode = headNode.next;

            //旧链表的下一个节点
            Node oldNextNode = copyNode.next;

            copyNode.rand = headNode.rand == null ? null : headNode.rand.next;

            headNode = oldNextNode;
        }
    }

    private static void copyNode(Node headNode) {
        //所有节点都已经复制完成
        while (headNode != null) {
            Node nextNode = headNode.next;

            Node copyNode = Node.buildCopyNode(headNode.value);
            headNode.next = copyNode;
            copyNode.next = nextNode;

            headNode = nextNode;
        }
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
        printRandLinkedList(head);
        res1 = copyListWithRandom(head);
        printRandLinkedList(res1);
        printRandLinkedList(head);
        System.out.println("=========================");

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
        System.out.println("=========================");

    }


}