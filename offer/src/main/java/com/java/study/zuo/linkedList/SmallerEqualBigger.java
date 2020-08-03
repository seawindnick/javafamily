package com.java.study.zuo.linkedList;

/**
 * 给定单向链表头节点head,给定一个整数，要求左部分小于给定值，中间部分等于给定值，右边部分大于给定值
 */
public class SmallerEqualBigger {

    public static Node smallerEqualBigger(Node node, int targetValue) {


        Node smallHeadNode = null;
        Node smallEndNode = null;

        Node equalsHeadNode = null;
        Node equalsEndNode = null;

        Node biggerHeadNode = null;
        Node biggerEndNoe = null;

        Node headNode = node;
        while (headNode != null) {
            //创建 小 等于 大于 三个链表，末尾追加对应的数据信息
            Node next = headNode.next;
            headNode.setNext(null);
            if (headNode.value < targetValue) {
                if (smallHeadNode == null) {
                    smallHeadNode = headNode;
                } else {
                    smallEndNode.setNext(headNode);
                }
                smallEndNode = headNode;

            } else if (headNode.value == targetValue) {

                if (equalsHeadNode == null) {
                    equalsHeadNode = headNode;
                } else {
                    equalsEndNode.setNext(headNode);
                }
                equalsEndNode = headNode;
            } else {

                if (biggerHeadNode == null) {
                    biggerHeadNode = headNode;
                } else {
                    biggerEndNoe.setNext(headNode);
                }
                biggerEndNoe = headNode;
            }
            headNode = next;
        }

        //链表拼接，精髓
        if (smallEndNode != null) {
            smallEndNode.setNext(equalsHeadNode);

            equalsEndNode = equalsEndNode == null ? smallEndNode : equalsEndNode;
        }

        if (equalsEndNode != null) {
            equalsEndNode.setNext(biggerHeadNode);
        }

        return smallHeadNode != null ? smallHeadNode : equalsHeadNode != null ? equalsHeadNode : biggerHeadNode;

    }

    /**
     * 米兰国旗
     *
     * @param node
     * @param target
     * @return
     */
    public static Node listPartition1(Node node, int target) {
        if (node == null) {
            return node;
        }


        int num = 0;
        Node cauclateNumNode = node;
        while (cauclateNumNode != null) {
            num++;
            cauclateNumNode = cauclateNumNode.next;
        }

        Node[] array = new Node[num];

        Node arrayNode = node;
        int index = 0;
        while (arrayNode != null) {
            array[index] = arrayNode;
            arrayNode = arrayNode.next;
            index++;
        }

        int leftIndex = -1;
        int rightIndex = array.length;
        int curIndex = 0;

        while (curIndex < rightIndex) {
            if (array[curIndex].value < target) {
                swap(array, ++leftIndex, curIndex++);
            } else if (array[curIndex].value > target) {
                swap(array, --rightIndex, curIndex);
            } else {
                curIndex++;
            }
        }

        for (int i = 1; i < array.length; i++) {
            array[i].setNext(null);
            array[i - 1].setNext(array[i]);
        }
        return array[0];
    }

    private static void swap(Node[] array, int leftIndex, int rightIndex) {
        Node temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
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
        head1 = listPartition1(head1, 5);
        printLinkedList(head1);
        head1 = smallerEqualBigger(head1, 5);
        printLinkedList(head1);

    }


}
