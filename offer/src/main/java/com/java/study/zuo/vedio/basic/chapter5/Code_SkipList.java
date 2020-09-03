package com.java.study.zuo.vedio.basic.chapter5;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-26 22:39
 */
public class Code_SkipList {

    public static class SkipListNode {
        private Integer value;
        private ArrayList<SkipListNode> nextNodes;

        public SkipListNode(Integer value) {
            this.value = value;
            nextNodes = new ArrayList<>();
        }
    }

    public static class SkipListIterator implements Iterator<Integer> {

        SkipList list;
        SkipListNode current;

        public SkipListIterator(SkipList list) {
            this.list = list;
            this.current = list.getHead();
        }

        @Override
        public boolean hasNext() {
            return current.nextNodes.get(0) != null;
        }

        @Override
        public Integer next() {
            current = current.nextNodes.get(0);
            return current.value;
        }
    }

    public static class SkipList {
        private SkipListNode head;
        private int maxLevel;
        private int size;
        private static final double PROBABILITY = 0.5;

        public SkipList() {
            size = 0;
            maxLevel = 0;
            head = new SkipListNode(null);
            head.nextNodes.add(null);
        }

        public SkipListNode getHead() {
            return head;
        }

        public void add(Integer newValue) {
            if (!contains(newValue)) {
                size++;
                int level = 0;
                while (Math.random() < PROBABILITY) {
                    level++;
                }

                while (level > maxLevel) {
                    head.nextNodes.add(null);
                    maxLevel++;
                }

                SkipListNode newNode = new SkipListNode(newValue);
                SkipListNode current = head;
                do {
                    current = findNext(newValue,current,level);
                    //将 current 节点对应高度的所有数据添加到
                    newNode.nextNodes.add(0,current.nextNodes.get(level));
                    current.nextNodes.set(level,newNode);
                }while (level-- > 0);

            }

        }

        public void  delete(Integer deleteValue){
            if (contains(deleteValue)){
                SkipListNode deleteNode = find(deleteValue);
                size--;
                int level = maxLevel;
                SkipListNode current = head;
                do {
                    current = findNext(deleteNode.value,current,level);
                    if (deleteNode.nextNodes.size() > level){
                        current.nextNodes.set(level,deleteNode.nextNodes.get(level));
                    }
                }while (level-- > 0);
            }
        }

        private SkipListNode findNext(Integer e, SkipListNode current, int level) {
            SkipListNode next = current.nextNodes.get(level);
            while (next != null){
                Integer value = next.value;
                if (lessThan(e,value)){
                    break;
                }
                current = next;
                next = next.nextNodes.get(level);
            }
            return current;
        }

        private boolean contains(Integer value) {
            SkipListNode node = find(value);
            return node != null && node.value != null && equalsTo(node.value, value);
        }

        private SkipListNode find(Integer value) {
            return find(value, head, maxLevel);
        }

        private SkipListNode find(Integer e, SkipListNode current, int level) {
            SkipListNode next = current.nextNodes.get(level);
            while (next != null) {
                Integer value = next.value;
                if (lessThan(e, value)) {
                    break;
                }
                current = next;
                next = current.nextNodes.get(level);
            }
            return current;
        }

        private boolean lessThan(Integer e, Integer value) {
            return e.compareTo(value) < 0;
        }

        private boolean equalsTo(Integer a, Integer b) {
            return a.equals(b);
        }

        public Iterator<Integer> iterator() {
            return new SkipListIterator(this);
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();

        for (int i = 0; i < 100; i++) {
            skipList.add(i);
        }
    }

}
