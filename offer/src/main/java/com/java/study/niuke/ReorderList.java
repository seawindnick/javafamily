package com.java.study.niuke;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-10-20 18:04
 */
public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
        }

        ListNode[] nodes = new ListNode[length];
        int startIndex = 0;
        temp = head;
        while (temp != null) {
            nodes[startIndex++] = temp;
        }

        for (int i = 0; i < length / 2; i++) {


        }


    }
}
