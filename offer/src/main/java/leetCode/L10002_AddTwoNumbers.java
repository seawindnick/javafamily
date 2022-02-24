package leetCode;//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 6552 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class L10002_AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(4);
        l6.next = l7;
        l7.next = l8;


        ListNode listNode = addTwoNumbers(l1, l6);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int l1Length = 0;
        ListNode temp1 = l1;
        ListNode tailNode1 = null;
        while (temp1 != null) {
            l1Length++;
            tailNode1 = temp1;
            temp1 = temp1.next;

        }


        int l2Length = 0;
        ListNode temp2 = l2;
        ListNode tailNode2 = null;
        while (temp2 != null) {
            l2Length++;
            tailNode2 = temp2;
            temp2 = temp2.next;
        }

        ListNode headNode = l1Length > l2Length ? l1 : l2;
        ListNode handleHeadNode = headNode;

        ListNode shortNode = l1Length > l2Length ? l2 : l1;
        ListNode tailNode = l1Length > l2Length ? tailNode1 : tailNode2;
        ListNode appendNode = new ListNode(0, null);
        tailNode.next = appendNode;

        while (shortNode != null) {
            int shortValue = shortNode.val;
            int headValue = handleHeadNode.val;
            int totalValue = shortValue + headValue;
            if (totalValue >= 10) {
                handleHeadNode.val = totalValue - 10;
                handleHeadNode.next.val++;
            }else {
                handleHeadNode.val = totalValue;
            }
            shortNode = shortNode.next;
            handleHeadNode = handleHeadNode.next;
        }

        while (handleHeadNode != null) {
            if (handleHeadNode.val >= 10) {
                handleHeadNode.val = handleHeadNode.val - 10;
                handleHeadNode.next.val++;
                handleHeadNode = handleHeadNode.next;
            } else {
                break;
            }
        }

        if (tailNode.next.val == 0) {
            tailNode.next = null;
        }

        return headNode;


    }


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
}

