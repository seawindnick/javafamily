package leetCode;//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 链表 双指针 分治 排序 归并排序
// 👍 1248 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetCode.L10104_MaxDepth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class L10148_SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int length = calculateListNodeLength(head);

        return null;
//        return mergeSort(head, 0, length - 1);
    }

    private int calculateListNodeLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }


//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        List<ListNode> nodeCollect = new ArrayList<>();
//        ListNode collectElementNode = head;
//        while (collectElementNode != null) {
//            nodeCollect.add(collectElementNode);
//            collectElementNode = collectElementNode.next;
//        }
//
//        Collections.sort(nodeCollect, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//
//
//        ListNode newHead = null;
//        for (int index = 0; index < nodeCollect.size(); index++) {
//            if (newHead == null) {
//                newHead = nodeCollect.get(index);
//                continue;
//            }
//
//            nodeCollect.get(index - 1).next = nodeCollect.get(index);
//            nodeCollect.get(index).next = null;
//        }
//        return newHead;
//    }

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


