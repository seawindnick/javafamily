package leetCode;//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
//输入：head = [1,2]
//输出：[2,1]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
//
// Related Topics 递归 链表
// 👍 1886 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetCode.L10148_SortList;

import java.util.List;

/**
 * Definition for singly-linked list.
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class L10206_ReverseList{

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode8 = new ListNode(3);
        ListNode listNode44 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode4.next = listNode1;
        listNode1.next = listNode8;
        listNode8.next = listNode44;
        listNode44.next = listNode5;
        ListNode listNode = reverseList(listNode4);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode preNode = null;
        ListNode nextNode = null;
        ListNode curNode = head;

        while (curNode != null){
             nextNode = curNode.next;
             curNode.next = preNode;
             preNode = curNode;
             curNode = nextNode;
        }

        return preNode;
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


