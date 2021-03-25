package com.java.study.algorithm.zuo.abasic.basic_class_03;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * 【题目】 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个整 数pivot。
 * 实现一个调整链表的函数，将链表调整为
 * 左部分都是值小于 pivot的节点，
 * 中间部分都是值等于pivot的节点，
 * 右部分都是值大于 pivot的节点。除这个要求外，对调整后的节点顺序没有更多的要求。
 * 例如:链表9->0->4->5->1，pivot=3。 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。
 * 总之，满 足左部分都是小于3的节点，中间部分都是等于3的节点(本例中这个部 分为空)，
 * 右部分都是大于3的节点即可。对某部分内部的节点顺序不做 要求。
 *
 *
 *
 * 进阶:
 * 在原问题的要求之上再增加如下两个要求。
 * 在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左 到右的顺序与原链表中节点的先后次序一致。
 * 例如:链表9->0->4->5->1，pivot=3。调整后的链表是0->1->9->4->5。
 * 在满足原问题要求的同时，左部分节点从左到右为0、1。
 * 在原链表中也 是先出现0，后出现1;中间部分在本例中为空，不再讨论;
 * 右部分节点 从左到右为9、4、5。
 * 在原链表中也是先出现9，然后出现4，最后出现5。
 * 如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
 */
public class Code_12_SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node SmallerEqualBigger(Node node, int pivot) {
        if (node == null || node.next == null) {
            return node;
        }

        Node smallStartNode = null;
        Node smallEndNode = null;

        Node equalsStartNode = null;
        Node equalsEndNode = null;

        Node biggerStartNode = null;
        Node biggerEndNode = null;
        while (node != null) {
            Node nextNode = node.next;
            node.next = null;
            if (node.value < pivot) {
                if (smallStartNode == null) {
                    smallStartNode = node;
                } else {
                    smallEndNode.next = node;
                }
                smallEndNode = node;
            } else if (node.value == pivot) {
                if (equalsStartNode == null) {
                    equalsStartNode = node;
                } else {
                    equalsEndNode.next = node;
                }
                equalsEndNode = node;

            } else {
                if (biggerStartNode == null) {
                    biggerStartNode = node;
                } else {
                    biggerEndNode.next = node;
                }
                biggerEndNode = node;
            }
            node = nextNode;
        }

        if (smallStartNode != null) {
            smallEndNode.next = equalsStartNode == null ? biggerStartNode : equalsStartNode;
        }

        if (equalsStartNode != null) {
            equalsEndNode.next = biggerStartNode;
        }

        return smallStartNode != null ? smallStartNode : equalsStartNode != null ? equalsStartNode : biggerStartNode;


    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
         head1 = SmallerEqualBigger(head1, 3);
//        head1 = SmallerEqualBigger(head1, 5);
        printLinkedList(head1);

    }


}