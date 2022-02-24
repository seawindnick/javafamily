package leetCode;

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
//
//
// 实现 LRUCache 类：
//
//
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
//
//
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 10000
// 0 <= value <= 105
// 最多调用 2 * 105 次 get 和 put
//
// Related Topics 设计 哈希表 链表 双向链表
// 👍 1548 👎 0

import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class L10146_LRU {

    private Map<Integer, Node> cache;

    private int capacity;
    private Node head;
    private Node tail;

    private static class Node {
        private Node preNode;
        private Node nextNode;
        private int key;
        private int value;
    }


//    Your input:["LRUCache","put","put","get","put","get","put","get","get","get"]
//            [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
//    Output:[null,null,null,1,null,2,null,-1,3,4]
//    Expected:[null,null,null,1,null,-1,null,-1,3,4]

    public static void main(String[] args) {
        L10146_LRU lru = new L10146_LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));//1
        lru.put(3, 3);
        System.out.println(lru.get(2));//2
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }

    public L10146_LRU(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            this.removeNodeToTail(node);
            return cache.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.get(key).value = value;
            //移动到最后一个位置
            removeNodeToTail(cache.get(key));
            return;
        }

        Node node = new Node();
        node.value = value;
        node.key = key;

        if (cache.size() == capacity) {
            removeHead();
        }
        addNodeToTail(node);
        cache.put(key, node);
    }

    private void addNodeToTail(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.nextNode = node;
        node.preNode = tail;
        tail = node;
        return;
    }

    //移除头节点
    private void removeHead() {
        Node indexHeadNode = head;
        cache.remove(head.key);

        if (indexHeadNode == tail) {
            head = null;
            tail = null;
            return;
        }
        Node headNextNode = indexHeadNode.nextNode;

        head.nextNode = null;
        if (headNextNode != null) {
            headNextNode.preNode = null;
        }
        head = headNextNode;
    }

    private void removeNodeToTail(Node node) {
        //原本node是尾节点
        if (node == tail) {
            return;
        }

        if (node == head){
            Node newHead = head.nextNode;
            newHead.preNode = null;

            tail.nextNode = node;
            node.preNode = tail;
            node.nextNode = null;

            tail = node;
        }

        Node preNode = node.preNode;
        Node nextNode = node.nextNode;
        preNode.nextNode = nextNode;
        nextNode.preNode = preNode;

        tail.nextNode = node;
        node.preNode = tail;
        tail = node;
        tail.nextNode = null;
    }
}
