package com.java.study.zuo.vedio.basic.chapter3;

/**
 * <Description>
 * 找出两个链表相交的第一个节点
 * 1. 首先判断两个链表是否有环，一个有环一个无环，一定不相交
 * 2. 两个链表无环，使用长度先走确定第一个相交点
 * 3。两个链表有环，判断是否是同一个环，不是同一个环不相交
 *
 * @author hushiye
 * @since 2020-08-22 19:15
 */
public class FindFirstIntersectNode {

    private static Node getIntersectNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return null;
        }

        Node firstInCircleNode = getInCircleNode(node1);
        Node secondInCircleNode = getInCircleNode(node2);
        if ((firstInCircleNode == null && secondInCircleNode != null) || (firstInCircleNode != null && secondInCircleNode == null)) {
            return null;
        }

        //无环
        if (firstInCircleNode == null && secondInCircleNode == null) {
            return noCircle(node1, node2);
        }

        //有环
        return circle(node1, node2, firstInCircleNode, secondInCircleNode);
    }

    private static Node circle(Node node1, Node node2, Node firstInCircleNode, Node secondInCircleNode) {

        if (firstInCircleNode == secondInCircleNode) {
            return findCircleOutInNode(node1, node2, firstInCircleNode, secondInCircleNode);
        }

        Boolean flag = checkOneCircle(firstInCircleNode,secondInCircleNode);
        if (!flag){
            return null;
        }

        return firstInCircleNode;
    }

    private static Boolean checkOneCircle(Node firstInCircleNode, Node secondInCircleNode) {
        //判断是否在同一个环内
        Node compareNode = secondInCircleNode;
        secondInCircleNode = secondInCircleNode.next;
        while (firstInCircleNode != secondInCircleNode){
            if (secondInCircleNode == compareNode){
                return false;
            }
            secondInCircleNode = secondInCircleNode.next;
        }
        return true;
    }

    private static Node findCircleOutInNode(Node node1, Node node2, Node firstInCircleNode, Node secondInCircleNode) {
        int node1Length = 0;
        Node firstSearchNode = node1;
        while (firstSearchNode != firstInCircleNode.next) {
            node1Length++;
            firstSearchNode = firstSearchNode.next;
        }


        int node2Length = 0;
        Node secondSearchNode = node2;
        while (secondSearchNode != secondInCircleNode.next) {
            node2Length++;
            secondSearchNode = secondSearchNode.next;
        }

        Node longNode = node1Length > node2Length ? node1 : node2;
        Node shortNode = longNode == node1 ? node2 : node1;
        int differentLenght = Math.abs(node2Length - node1Length);

        for (int i = 0; i < differentLenght; i++) {
            longNode = longNode.next;
        }

        while (longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return longNode;

    }

    private static Node noCircle(Node node1, Node node2) {
        int firstLength = 0;
        Node firstNodeLastNode = node1;
        Node firstNode = node1;
        while (firstNode != null) {
            firstLength++;
            firstNodeLastNode = firstNode;
            firstNode = firstNode.next;
        }

        int seccondLength = 0;
        Node secondNode = node2;
        Node secondLastNode = node2;
        while (secondNode != null) {
            seccondLength++;
            secondLastNode = secondNode;
            secondNode = secondNode.next;
        }

        if (firstNodeLastNode != secondLastNode) {
            return null;
        }

        Node longNode = firstLength > seccondLength ? node1 : node2;
        Node shortNode = longNode == node1 ? node2 : node1;
        int differentLenght = Math.abs(firstLength - seccondLength);

        for (int i = 0; i < differentLenght; i++) {
            longNode = longNode.next;
        }

        while (longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return longNode;
    }

//    public static Node getInCircleNode(Node head) {
//        if (head == null || head.next == null || head.next.next == null) {
//            return null;
//        }
//        Node n1 = head.next; // n1 -> slow
//        Node n2 = head.next.next; // n2 -> fast
//        while (n1 != n2) {
//            if (n2.next == null || n2.next.next == null) {
//                return null;
//            }
//            n2 = n2.next.next;
//            n1 = n1.next;
//        }
//        n2 = head; // n2 -> walk again from head
//        while (n1 != n2) {
//            n1 = n1.next;
//            n2 = n2.next;
//        }
//        return n1;
//    }

    private static Node getInCircleNode(Node node) {
        if (node == null || node.next == null){
            return null;
        }

        Node fastNode = node.next.next;
        Node slowNode = node.next;
        boolean circleFlag = false;
        while (fastNode != null && fastNode.next != null) {
            if (fastNode == slowNode) {
                circleFlag = true;
                break;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        if (!circleFlag) {
            return null;
        }

        Node headNode = node;
        while (headNode != fastNode) {
            headNode = headNode.next;
            fastNode = fastNode.next;
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
        System.out.println(getIntersectNode(head1, head2).value);

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
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }



}
