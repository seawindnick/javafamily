package leetCode;//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1073 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.java.study.niuke.ReorderList;

/**
 * Definition for singly-linked list.
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class L10234_IsPalindrome {

    public static void main(String[] args) {
//        1->2->2->1
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(isPalindrome(listNode1));

    }


    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        ListNode endNode = head;
        while (endNode.next != null) {
            endNode = endNode.next;
        }

        ListNode middleNode = slowNode;
        ListNode reverseNode = reverseNode(middleNode, endNode);
        ListNode startNode = head;
        while (startNode != null && reverseNode != null && startNode != reverseNode) {
            if (startNode.val != reverseNode.val) {
                return false;
            }
            startNode = startNode.next;
            reverseNode = reverseNode.next;
        }

        reverseNode(endNode, middleNode);
        return true;
    }

    private static ListNode reverseNode(ListNode middleNode, ListNode endNode) {
        ListNode currentNode = middleNode;
        ListNode prevNode = null;
        while (currentNode != endNode) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        endNode.next = prevNode;
        return endNode;
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


