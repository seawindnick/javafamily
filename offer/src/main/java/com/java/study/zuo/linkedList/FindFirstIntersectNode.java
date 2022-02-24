package com.java.study.zuo.linkedList;

/**
 * 返回两个单向链表相交的第一个节点
 * <p>
 * 1. 相交链表无环
 * 2. 相交链表有环
 * <p>
 * 一个无环链表，一个有环链表不可能相交
 */
public class FindFirstIntersectNode {

    public static Node findFirstIntersectNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return null;
        }

        Node node1CircleNode = findListCircleNode(node1);
        Node node2CircleNode = findListCircleNode(node2);

        //都没有环
        if (node1CircleNode == null && node2CircleNode == null) {
            return noCircle(node1, node2);

        } else if (node1CircleNode != null && node2CircleNode != null) {
            //都有环
            return circle(node1, node2, node1CircleNode, node2CircleNode);

        } else {
            //一个有环一个没有环
            return null;
        }

    }

    private static Node circle(Node node1, Node node2, Node node1CircleNode, Node node2CircleNode) {
        // 入环点不同
        if (node1CircleNode != node2CircleNode) {
            //判断是环内否相交
            Boolean checkIntersectNode = checkIntersectNode(node1CircleNode, node2CircleNode);
            if (checkIntersectNode) {
                return node1CircleNode;
            }
            return null;
        }


        //入环点相同
        int node1Length = 0;
        Node searchNode1LengthNode = node1;
        while (searchNode1LengthNode != node1CircleNode) {
            node1Length++;
            searchNode1LengthNode = searchNode1LengthNode.next;
        }

        int node2Length = 0;
        Node searchNode2LengthNode = node2;
        while (searchNode2LengthNode != node2CircleNode) {
            node2Length++;
            searchNode2LengthNode = searchNode2LengthNode.next;
        }

        int differentLength = node1Length - node2Length;
        Node longNode = differentLength > 0 ? node1 : node2;
        Node shortNode = longNode == node1 ? node2 : node1;

        int i = 0;
        while (i < Math.abs(differentLength)) {
            longNode = longNode.next;
            i++;
        }

        while (longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return longNode;
    }

    /**
     * 判断是否在环内相交
     *
     * @param node1CircleNode
     * @param node2CircleNode
     * @return
     */
    private static Boolean checkIntersectNode(Node node1CircleNode, Node node2CircleNode) {
        Node searchNode = node1CircleNode.next;
        while (searchNode != node1CircleNode) {
            if (searchNode == node2CircleNode) {
                return Boolean.TRUE;
            }
            searchNode = searchNode.next;
        }
        return Boolean.FALSE;
    }

    private static Node noCircle(Node node1, Node node2) {

        if (node1 == null || node2 == null) {
            return null;
        }

        Node node1Head = node1;
        Node end1Node = null;
        int node1Length = 0;
        while (node1Head != null) {
            node1Length++;
            end1Node = node1Head;
            node1Head = node1Head.next;
        }

        Node node2Head = node2;
        Node end2Node = null;
        int node2Length = 0;
        while (node2Head != null) {
            node2Length++;
            end2Node = node2Head;
            node2Head = node2Head.next;
        }

        if (end1Node != end2Node) {
            return null;
        }

        int differentLength = node1Length - node2Length;

        Node longNode = differentLength > 0 ? node1 : node2;
        Node shortNode = longNode == node1 ? node2 : node1;

        int i = 0;
        while (i < Math.abs(differentLength)) {
            longNode = longNode.next;
            i++;
        }


        while (longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return longNode;

    }

    /**
     * 判断链表是否有环，有环返回入环节点
     *
     * @param node
     * @return
     */
    private static Node findListCircleNode(Node node) {

        if (node == null || node.next == null || node.next.next == null) {
            return null;
        }
        Node slowNode = node.next;
        Node fastNode = node.next.next;

        while (fastNode.next != null && slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        Boolean isCircle = fastNode == slowNode;
        if (!isCircle) {
            return null;
        }

        //快指针指向头部
        fastNode = node;
        while (fastNode != slowNode) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        return fastNode;
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
        System.out.println(findFirstIntersectNode(head1, head2).value);

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
        System.out.println(findFirstIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(findFirstIntersectNode(head1, head2).value);

    }
}
