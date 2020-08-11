package com.java.study.test;

import lombok.Data;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-09 10:59
 */
public class PrintTwoLinkPublicNode {
    @Data
    public static class Node {
        private int value;
        private Node nextNode;
    }

    public static void printPublicNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        Node node1CircleInNode = getCircleInNode(node1);
        Node node2CircleInNode = getCircleInNode(node2);

        if ((node1CircleInNode != null && node2CircleInNode == null) || (node1CircleInNode == null && node2CircleInNode != null)) {
            return;
        }

        //无环相交
        if (node1CircleInNode == null && node2CircleInNode == null) {
            noCircle(node1, node2);
        } else {
            //有环相交
            circle(node1, node2,node1CircleInNode,node2CircleInNode);
        }


    }

    private static void circle(Node node1, Node node2, Node node1CircleInNode, Node node2CircleInNode) {
        //相交节点是同一个
        if (node1CircleInNode != node2CircleInNode){
            //判断是否有相交节点
            Boolean checkPublicFlag = checkPublicFlag(node1CircleInNode,node2CircleInNode);
            if (!checkPublicFlag){
                return;
            }

            circleOut(node1, node2,node1CircleInNode,node2CircleInNode);
        }

        //相交在环内,打印一圈环内元素即可
        printCircle(node1CircleInNode);

    }

    private static void printCircle(Node node1CircleInNode) {
        System.out.println(node1CircleInNode.value);
        Node node = node1CircleInNode.nextNode;
        while (node != node1CircleInNode){
            System.out.println(node.value);
            node = node.nextNode;
        }

    }

    private static void circleOut(Node node1, Node node2, Node node1CircleInNode, Node node2CircleInNode) {
        int node1Length = 0;
        Node node1Start = node1;
        Node node1LastNode = node1CircleInNode.nextNode;
        while (node1Start != node1LastNode ) {
            node1Length++;
            node1Start = node1Start.nextNode;
        }


        int node2Length = 0;
        Node node2Start = node2;
        while (node2Start != node1LastNode){
            node2Length ++;
            node2Start = node2Start.nextNode;
        }


        Node longNode = node1Length > node2Length ? node1 : node2;
        Node shortNode = longNode == node1 ? node2 : node1;


        int i = 0;
        while (i++ < Math.abs(node1Length - node2Length)) {
            longNode = longNode.nextNode;
        }


        while (longNode != shortNode) {
            longNode = longNode.nextNode;
            shortNode = shortNode.nextNode;
        }

        while (longNode != null && longNode != node1CircleInNode) {
            System.out.println(longNode.value);
            longNode = longNode.nextNode;
        }

        printCircle(node1CircleInNode);

    }

    private static Boolean checkPublicFlag(Node node1CircleInNode, Node node2CircleInNode) {
        Node searchNode2 = node2CircleInNode.nextNode;
        while (searchNode2 != null){
            if (node1CircleInNode == searchNode2){
                return true;
            }

            if (searchNode2 == node2CircleInNode ){
                return false;
            }
            searchNode2 = searchNode2.nextNode;

        }
        return false;
    }


    private static void noCircle(Node node1, Node node2) {
        int node1Length = 0;
        Node node1LastNode = null;
        Node node1Start = node1;
        while (node1Start != null) {
            node1Length++;
            node1LastNode = node1Start;
            node1Start = node1Start.nextNode;
        }


        int node2Length = 0;
        Node node2LastNode = null;
        Node node2Start = node2;
        while (node2Start != null) {
            node2Length++;
            node2LastNode = node2Start;
            node2Start = node2Start.nextNode;
        }

        if (node1LastNode != node2LastNode) {
            return;
        }

        Node longNode = node1Length > node2Length ? node1 : node2;
        Node shortNode = longNode == node1 ? node2 : node1;

        int i = 0;
        while (i++ < Math.abs(node1Length - node2Length)) {
            longNode = longNode.nextNode;
        }


        while (longNode != shortNode) {
            longNode = longNode.nextNode;
            shortNode = shortNode.nextNode;
        }

        while (longNode != null) {
            System.out.println(longNode.value);
            longNode = longNode.nextNode;
        }

    }

    private static int calculateLength(Node node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.nextNode;
        }
        return length;
    }

    private static Node getCircleInNode(Node node) {
        Node slowNode = node.nextNode;
        Node fastNode = node.nextNode.nextNode;

        while (slowNode != null && fastNode != null && slowNode != fastNode) {
            slowNode = slowNode.nextNode;
            fastNode = fastNode.nextNode.nextNode;
        }

        if (fastNode != slowNode) {
            return null;
        }

        Node startNode = node;
        while (startNode != slowNode) {
            slowNode = slowNode.nextNode;
            startNode = slowNode.nextNode;
        }
        return startNode;

    }


}
