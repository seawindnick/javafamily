package com.java.study.niuke;

import java.util.ArrayList;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-04 21:28
 */
public class MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//
//        if (lists.length == 1) {
//            return lists[0];
//        }
//
//        return mergeKLists(lists, 0, lists.length - 1);
//
//
//    }
//
//    private ListNode mergeKLists(ListNode[] lists, int startIndex, int endIndex) {
//        if (startIndex == endIndex) {
//            return lists[startIndex];
//        }
//
//        int midIndex = startIndex + (endIndex - startIndex) / 2;
//
//        ListNode leftNode = mergeKLists(lists, startIndex, midIndex);
//        ListNode rightNode = mergeKLists(lists, midIndex + 1, endIndex);
//
//        if (leftNode == null && rightNode == null) {
//            return null;
//        }
//        ListNode headNode ;
//
//        if (leftNode == null){
//            headNode = rightNode;
//        }else if (rightNode == null){
//            headNode = leftNode ;
//        }else {
//            headNode = leftNode.val <= rightNode.val ? leftNode : rightNode;
//        }
//
//        if (headNode == leftNode) {
//            leftNode = leftNode.next;
//        } else {
//            rightNode = rightNode.next;
//        }
//
//        ListNode preNode = headNode;
//        while (leftNode != null && rightNode != null) {
//            if (leftNode.val <= rightNode.val) {
//                preNode.next = leftNode;
//                leftNode = leftNode.next;
//            } else {
//                preNode.next = rightNode;
//                rightNode = rightNode.next;
//            }
//            preNode = preNode.next;
//        }
//
//        while (leftNode != null) {
//            preNode.next = leftNode;
//            leftNode = leftNode.next;
//            preNode = preNode.next;
//        }
//
//        while (rightNode != null) {
//            preNode.next = rightNode;
//            rightNode = rightNode.next;
//            preNode = preNode.next;
//        }
//
//        return headNode;
//    }
//
//    public static void main(String[] args) {
//        ListNode[] listNodes = new ListNode[2];
//
//
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNodes[0] = listNode1;
//
//
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
//        ListNode listNode7 = new ListNode(7);
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;
//        listNodes[1] = listNode4;
//
//
//
//        MergeKLists mergeKLists = new MergeKLists();
//        mergeKLists.mergeKLists(listNodes);
//
//
//    }




    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }

        ListNode listNode = mergeKLists(lists, 0, lists.size() - 1);
        return listNode;

    }

    private ListNode mergeKLists(ArrayList<ListNode> lists, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return lists.get(startIndex);
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;
        ListNode leftNode = mergeKLists(lists, startIndex, midIndex);
        ListNode rightNode = mergeKLists(lists, midIndex + 1, endIndex);


        if (leftNode == null && rightNode == null){
            return null;
        }
        ListNode startNode ;
        if(leftNode == null){
            startNode = rightNode;
            rightNode = rightNode.next;
        }else if (rightNode == null){
            startNode = leftNode;
            leftNode = leftNode.next;
        }else {
            startNode  = leftNode.val < rightNode.val ? leftNode : rightNode;
        }

        ListNode headNode = startNode;
        while (leftNode != null && rightNode != null){
            ListNode tempLeftNode = leftNode.next;
            ListNode tempRightNode = rightNode.next;
            if (leftNode.val < rightNode.val){
                headNode.next = leftNode;
                leftNode = tempLeftNode;
            }else {
                headNode.next = rightNode;
                rightNode = tempRightNode;
            }
            headNode = headNode.next;
        }

        while (leftNode != null){
            headNode.next = leftNode;
            leftNode = leftNode.next;
            headNode = headNode.next;
        }

        while (rightNode != null){
            headNode.next = rightNode;
            rightNode = rightNode.next;
            headNode = headNode.next;
        }

        return startNode;

    }
}
