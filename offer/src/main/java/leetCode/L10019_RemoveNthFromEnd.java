package leetCode;//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1496 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Definition for singly-linked list.
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class L10019_RemoveNthFromEnd {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode preNode = head;
        for (int i = 2; i <= 10; i++) {
            ListNode node = new ListNode(i);
            preNode.next = node;
            preNode = node;
        }

        ListNode removeNthFromEnd = removeNthFromEnd(head, 10);

        System.out.println(JSONObject.toJSONString(removeNthFromEnd));
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        ListNode tempHead = head;

        int length = 0;
        while (tempHead != null) {
            length++;
            tempHead = tempHead.next;
        }

        if (n > length) {
            throw new RuntimeException("");
        }

        int deleteIndex = length - n;
        if (deleteIndex == 0) {
            ListNode nextNode = head.next;
            head.next = null;
            return nextNode;
        }

        ListNode prevNode = null;
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;

        int startIndex = 0;
        while (startIndex < deleteIndex) {
            ListNode tempNextNode = nextNode.next;
            prevNode = currentNode;
            currentNode = nextNode;
            nextNode = tempNextNode;
            startIndex++;
        }


        prevNode.next = nextNode;

        return head;

    }


    public static class ListNode {
        private int value;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }


}

