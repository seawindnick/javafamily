package com.java.study.answer.zuo.abasic.basic_class_06;

import com.sun.tools.javac.util.Assert;

import java.util.Random;

public class Code_02_SkipList {
    private static final int MAX_LEVEL = 16;
    private static final float SKILLIST_P = 0.5f;

    private int leveCount = 1;
    private Node head = new Node();


    public Node find(int value) {
        Node p = head;
        for (int i = leveCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        }
        return null;
    }


    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;

        Node update[] = new Node[level];
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }


        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[0].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }


        for (int i = 0; i < level; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        if (leveCount < level) {
            leveCount = level;
        }
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < SKILLIST_P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }


    public void delete(int value) {
        Node[] update = new Node[leveCount];
        Node p = head;
        for (int i = leveCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = leveCount - 1; i >= 0; i--) {

                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }


    public static class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }


    public static void main(String[] args) {
        Code_02_SkipList skipList = new Code_02_SkipList();

        for (int i = 0; i < 5; i++) {
            skipList.insert(i);
        }

        Node node = skipList.find(1);
        Assert.check(node != null, "node不为空");
        Assert.check(node.data == 1, "node值为1");
        skipList.printAll();

        skipList.delete(1);
        node = skipList.find(1);
        Assert.check(node == null, "node不为空");
        skipList.printAll();


    }


//	public static class SkipListNode {
//		public Integer value;
//		public ArrayList<SkipListNode> nextNodes;
//
//		public SkipListNode(Integer value) {
//			this.value = value;
//			nextNodes = new ArrayList<SkipListNode>();
//		}
//	}
//
//	public static class SkipListIterator implements Iterator<Integer> {
//		SkipList list;
//		SkipListNode current;
//
//		public SkipListIterator(SkipList list) {
//			this.list = list;
//			this.current = list.getHead();
//		}
//
//		public boolean hasNext() {
//			return current.nextNodes.get(0) != null;
//		}
//
//		public Integer next() {
//			current = current.nextNodes.get(0);
//			return current.value;
//		}
//	}
//
//	public static class SkipList {
//		private SkipListNode head;
//		private int maxLevel;
//		private int size;
//		private static final double PROBABILITY = 0.5;
//
//		public SkipList() {
//			size = 0;
//			maxLevel = 0;
//			head = new SkipListNode(null);
//			head.nextNodes.add(null);
//		}
//
//		public SkipListNode getHead() {
//			return head;
//		}
//
//		public void add(Integer newValue) {
//			if (!contains(newValue)) {
//				size++;
//				int level = 0;
//				while (Math.random() < PROBABILITY) {
//					level++;
//				}
//				while (level > maxLevel) {
//					head.nextNodes.add(null);
//					maxLevel++;
//				}
//				SkipListNode newNode = new SkipListNode(newValue);
//				SkipListNode current = head;
//				do {
//					current = findNext(newValue, current, level);
//					newNode.nextNodes.add(0, current.nextNodes.get(level));
//					current.nextNodes.set(level, newNode);
//				} while (level-- > 0);
//			}
//		}
//
//		public void delete(Integer deleteValue) {
//			if (contains(deleteValue)) {
//				SkipListNode deleteNode = find(deleteValue);
//				size--;
//				int level = maxLevel;
//				SkipListNode current = head;
//				do {
//					current = findNext(deleteNode.value, current, level);
//					if (deleteNode.nextNodes.size() > level) {
//						current.nextNodes.set(level, deleteNode.nextNodes.get(level));
//					}
//				} while (level-- > 0);
//			}
//		}
//
//		// Returns the skiplist node with greatest value <= e
//		private SkipListNode find(Integer e) {
//			return find(e, head, maxLevel);
//		}
//
//		// Returns the skiplist node with greatest value <= e
//		// Starts at node start and level
//		private SkipListNode find(Integer e, SkipListNode current, int level) {
//			do {
//				current = findNext(e, current, level);
//			} while (level-- > 0);
//			return current;
//		}
//
//		// Returns the node at a given level with highest value less than e
//		private SkipListNode findNext(Integer e, SkipListNode current, int level) {
//			SkipListNode next = current.nextNodes.get(level);
//			while (next != null) {
//				Integer value = next.value;
//				if (lessThan(e, value)) { // e < value
//					break;
//				}
//				current = next;
//				next = current.nextNodes.get(level);
//			}
//			return current;
//		}
//
//		public int size() {
//			return size;
//		}
//
//		public boolean contains(Integer value) {
//			SkipListNode node = find(value);
//			return node != null && node.value != null && equalTo(node.value, value);
//		}
//
//		public Iterator<Integer> iterator() {
//			return new SkipListIterator(this);
//		}
//
//		/******************************************************************************
//		 * Utility Functions *
//		 ******************************************************************************/
//
//		private boolean lessThan(Integer a, Integer b) {
//			return a.compareTo(b) < 0;
//		}
//
//		private boolean equalTo(Integer a, Integer b) {
//			return a.compareTo(b) == 0;
//		}
//
//	}
//
//	public static void main(String[] args) {
//
//		SkipList skipList = new SkipList();
//		skipList.add(1);
//		System.out.println(skipList.contains(1));
//		skipList.delete(1);
//		System.out.println(skipList.contains(1));
//	}


}
