package com.java.study.zuo.vedio.basic.chapter3;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 18:51
 */
public class CopyListWithRandom {

    public static class Node {
        public int value;
        public Node next;
        public Node rand;
        public String desc;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node copyRandomNode(Node node) {

        if (node == null) {
            return null;
        }

        Node headNode = node;
        while (headNode != null) {
            Node nextNode = headNode.next;
            Node newNode = new Node(headNode.value);
            newNode.desc = "复制信息";

            headNode.next = newNode;
            newNode.next = nextNode;
            headNode = nextNode;
        }

        headNode = node;
        while (headNode != null) {
            Node randomNode = headNode.rand;
            if (randomNode != null) {
                Node newNode = headNode.next;
                newNode.rand = randomNode.next;
            }
            headNode = headNode.next.next;
        }



        Node newHeadNode = null;
        Node nweNode = null;

        headNode = node;
        while (headNode != null) {
            Node newNextNode = headNode.next;
            Node oldNextNode = newNextNode.next;

            if (newHeadNode == null) {
                newHeadNode = newNextNode;
            } else {
                nweNode.next = newNextNode;
            }
            nweNode = newHeadNode;
            headNode.next = oldNextNode;
            headNode = oldNextNode;
        }


        return newHeadNode;

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
        res1 = copyRandomNode(head);
        printRandLinkedList(res2);
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
        res1 = copyRandomNode(head);
        printRandLinkedList(res1);
        printRandLinkedList(head);
        System.out.println("=========================");

    }

}
