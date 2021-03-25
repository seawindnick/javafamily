package com.java.study.algorithm.zuo.abasic.basic_class_03;

/**
 * 两个单链表相交的一系列问题
 * 【题目】 在本题中，单链表可能有环，也可能无环。
 * 给定两个单链表的头节点 head1和head2，这两个链表可能相交，也可能不相交。请实现一个函数，
 * 如果两个链表相交，请返回相交的第一个节点;如果不相交，返回null 即可。
 * 要求:如果链表1的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外空间复杂度请达到O(1)。
 */
public class Code_14_FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

    }

    public static Node FindFirstIntersectNode(Node firstNode, Node secondNode) {
        if (firstNode == null || secondNode == null) {
            return null;
        }


        Node firstCircleInNode = findCircleInNode(firstNode);
        Node secondCircleInNode = findCircleInNode(secondNode);

        //一个有环 一个没有环
        if ((firstCircleInNode == null && secondCircleInNode != null) || (firstCircleInNode != null && secondCircleInNode == null)) {
            return null;
        }

        if (firstCircleInNode == null && secondCircleInNode == null) {
            return findNoCirclePublicNode(firstNode, secondNode);
        }

        return findCirclePublicNode(firstNode, secondNode, firstCircleInNode, secondCircleInNode);

    }

    private static Node findCirclePublicNode(Node firstNode, Node secondNode, Node firstCircleInNode, Node secondCircleInNode) {
        //入环节点是相同的节点
        if (firstCircleInNode == secondCircleInNode) {
            return inCircleSameNode(firstNode, secondNode, firstCircleInNode);
        }


        return twoLinkIntersection(firstCircleInNode, secondCircleInNode) ? firstCircleInNode : null;

    }

    private static boolean twoLinkIntersection(Node firstCircleInNode, Node secondCircleInNode) {
        Node tempNode = secondCircleInNode;
        secondCircleInNode = secondCircleInNode.next;
        while (secondCircleInNode != tempNode) {
            if (secondCircleInNode == firstCircleInNode) {
                return Boolean.TRUE;
            }
            secondCircleInNode = secondCircleInNode.next;
        }
        return Boolean.FALSE;
    }

    /**
     * 入环节点是相同的节点，说明在此点之前可能就已经相交
     *
     * @param firstNode
     * @param secondNode
     * @param firstCircleInNode
     * @return
     */
    private static Node inCircleSameNode(Node firstNode, Node secondNode, Node firstCircleInNode) {
        Node firstCircleInNodeNext = firstCircleInNode.next;
        firstCircleInNode.next = null;
        Node node = findNoCirclePublicNode(firstNode, secondNode);
        firstCircleInNode.next = firstCircleInNodeNext;
        return node;
    }


    /**
     * 没有环查询公共相交节点
     * 如果相交，末尾的元素一定是一致的，长的先走N部，然后逐个判断
     *
     * @param firstNode
     * @param secondNode
     * @return
     */
    private static Node findNoCirclePublicNode(Node firstNode, Node secondNode) {
        NodePropertity firstNodePropertity = NodePropertity.calculate(firstNode);
        NodePropertity secondNodePropertity = NodePropertity.calculate(secondNode);

        if (firstNodePropertity.endNode != secondNodePropertity.endNode) {
            return null;
        }

        Node longNode = firstNodePropertity.length > secondNodePropertity.length ? firstNode : secondNode;
        Node shirtNode = firstNodePropertity.length > secondNodePropertity.length ? secondNode : firstNode;

        int lengthGap = Math.abs(firstNodePropertity.length - secondNodePropertity.length);

        while (lengthGap > 0) {
            longNode = longNode.next;
            lengthGap--;
        }

        while (longNode != shirtNode){
            longNode = longNode.next;
            shirtNode = shirtNode.next;
        }

        return longNode;
    }


    public static class NodePropertity {
        int length;
        Node endNode;


        public static NodePropertity calculate(Node node) {
            NodePropertity nodePropertity = new NodePropertity();
            if (node == null) {
                return nodePropertity;
            }
            int calculateLength = 0;
            Node endNode = null;
            while (node != null) {
                calculateLength++;
                endNode = node;
                node = node.next;
            }
            nodePropertity.endNode = endNode;
            nodePropertity.length = calculateLength;


            return nodePropertity;


        }
    }

    /**
     * 获取入环的节点，如果没有环 返回 null
     *
     * @return
     */
    private static Node findCircleInNode(Node node) {
        if (node == null || node.next == null || node.next.next == null) {
            return null;
        }

        Node slowNode = node.next;
        Node fastNode = node.next.next;

        while (slowNode != fastNode){
            if (slowNode == fastNode){
                break;
            }
            if (fastNode == null || fastNode.next == null ){
                return null;
            }

            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }


        fastNode = node;
        while (fastNode != slowNode){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        return slowNode;


//
//
//        Boolean circleFlag = false;
//        while (fastNode != null && fastNode.next != null) {
//            if (slowNode == fastNode) {
//                if (circleFlag == false) {
//                    circleFlag = true;
//                    fastNode = node;
//                } else {
//                    return slowNode;
//                }
//            }
//            slowNode = slowNode.next;
//            if (!circleFlag) {
//                fastNode = fastNode.next.next;
//            } else {
//                fastNode = fastNode.next;
//
//            }
//        }

//        return null;
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(FindFirstIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(FindFirstIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(FindFirstIntersectNode(head1, head2).value);

    }


}