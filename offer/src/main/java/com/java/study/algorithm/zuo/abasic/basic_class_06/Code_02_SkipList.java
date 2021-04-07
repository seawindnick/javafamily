package com.java.study.algorithm.zuo.abasic.basic_class_06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 跳表
 */
public class Code_02_SkipList {

    public static class SkipListNode {
        private Integer value;
        private List<SkipListNode> nextNodeList;

        public SkipListNode(Integer value) {
            this.value = value;
            this.nextNodeList = new ArrayList<>();
        }

    }


    public static class SkipList {
        SkipListNode head;
        int maxLevel;
        int size;
        private static final double PROBABILITY = 0.5;

        public SkipList() {
            size = 0;
            maxLevel = 0;
            head = new SkipListNode(null);
            head.nextNodeList.add(null);
        }

        public SkipListNode getHead() {
            return head;
        }

        public void add(int newValue) {
            if (!contains(newValue)) {
                size++;
                int level = 0;
                while (Math.random() < PROBABILITY) {
                    level++;
                }

                while (level > maxLevel) {
                    head.nextNodeList.add(head);
                    maxLevel++;
                }

                SkipListNode newNode = new SkipListNode(newValue);
                SkipListNode current = head;
                do {
                    current = findNext(newValue, current, level);
                    newNode.nextNodeList.add(0, current.nextNodeList.get(level));
                    current.nextNodeList.set(level, newNode);
                } while (level-- > 0);

            }
        }

        public void delete(Integer deleteValue) {
            if (contains(deleteValue)) {
                SkipListNode deleteNode = find(deleteValue);
                size--;
                int level = maxLevel;
                SkipListNode current = head;
                do {
                    current = findNext(deleteNode.value, current, level);
                    if (deleteNode.nextNodeList.size() > level) {
                        current.nextNodeList.set(level, deleteNode.nextNodeList.get(level));
                    }
                } while (level-- > 0);
            }

//            do {
//                current = findNext(deleteNode.value, current, level);
//                if (deleteNode.nextNodes.size() > level) {
//                    current.nextNodes.set(level, deleteNode.nextNodes.get(level));
//                }
//            } while (level-- > 0);

        }


        private boolean contains(int value) {
            SkipListNode node = find(value);
            return node != null && node.value != null && equalTo(node.value, value);
        }

        private SkipListNode find(int value) {
            return find(value, head, maxLevel);
        }

        private SkipListNode find(Integer value, SkipListNode current, int level) {
            do {
                current = findNext(value, current, level);
            } while (level-- > 0);
            return current;
        }

        private SkipListNode findNext(Integer e, SkipListNode current, int level) {
            SkipListNode next = current.nextNodeList.get(level);
            while (next != null) {
                Integer value = next.value;
                if (lessThan(e, value)) {
                    break;
                }
                current = next;
                next = current.nextNodeList.get(level);
            }

            return current;
        }

        private boolean lessThan(Integer a, Integer b) {
            return a.compareTo(b) < 0;
        }

        private boolean equalTo(Integer a, Integer b) {
            return a.compareTo(b) == 0;
        }

        public Iterator<Integer> iterator() {
            return new SkipListIterator(this);
        }


        public int size() {
            return size;
        }

    }

    public static class SkipListIterator implements Iterator<Integer> {
        private SkipList skipList;
        private SkipListNode current;

        public SkipListIterator(SkipList skipList) {
            this.skipList = skipList;
            current = skipList.head;
        }

        @Override
        public boolean hasNext() {
            return current.nextNodeList.get(0) != null;
        }

        @Override
        public Integer next() {
            current = current.nextNodeList.get(0);
            return current.value;
        }
    }

    public static void main(String[] args) {

        SkipList skipList = new SkipList();
        skipList.add(1);
        System.out.println(skipList.contains(1));
        skipList.delete(1);
        System.out.println(skipList.contains(1));
    }

}