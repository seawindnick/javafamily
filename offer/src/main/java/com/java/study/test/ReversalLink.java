package com.java.study.test;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-09 10:15
 */
public class ReversalLink {
    @Data
    public static class Node {
        private int value;
        private Node next = null;
        private Node pre = null;

        public Node(int value) {
            this.value = value;
        }
    }


    public static Node reversalSingleLink(Node node) {
        if (node == null) {
            return null;
        }


        Node preNode = null;
        Node curNode = node;


        while (curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }


    public static Node reversalTwoLink(Node node) {
        if (node == null) {
            return null;
        }


        Node preNode = null;
        Node curNode = node;

        while (curNode != null) {
            Node nextNode = curNode.next;
            //提前将原始属性设置为Null
            curNode.setPre(null);

            curNode.next = preNode;
            if (preNode != null) {
                preNode.pre = curNode;
            }
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
//
        node1.setNext(node2);
        node2.setPre(node1);

        node2.setNext(node3);
        node3.setPre(node2);
        System.out.println(JSONObject.toJSONString(node1));
        System.out.println(JSONObject.toJSONString(reversalTwoLink(node1)));

    }


}
