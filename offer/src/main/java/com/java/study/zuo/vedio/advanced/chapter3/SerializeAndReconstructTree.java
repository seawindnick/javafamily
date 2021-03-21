package com.java.study.zuo.vedio.advanced.chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-08 15:04
 */
public class SerializeAndReconstructTree {

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }

    public static String inSerialize(TreeNode node) {
        if (node == null) {
            return "#!";
        }

        String left = inSerialize(node.left);
        String indexValue = node.value + "!";
        String right = inSerialize(node.right);
        return left + indexValue + right;
    }


//    public static Node rebuildTreeNodeIn(String str) {
//        if ("#!".equals(str)) {
//            return null;
//        }
//
//        Queue<String> queue = new LinkedList<>();
//        String[] arr = str.split("!");
//        for (String s : arr) {
//            queue.add(s);
//        }
//
//
//        while ()
//
//
//
//
//        Node node = rebuildTreeNodeIn(queue);
//
//
//
//
//
//        return node;
//    }

    private static TreeNode rebuildTreeNodeIn(Queue<String> queue) {
        TreeNode left = buildNodeIn(queue);
        int indexValue = Integer.parseInt(queue.poll());
        TreeNode indexNode = new TreeNode(indexValue);
        TreeNode right = buildNodeIn(queue);

        indexNode.left = left;
        indexNode.right = right;
        return indexNode;
    }

    private static TreeNode buildNodeIn(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(value));
    }


    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }

        String result = root.value + "!";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return result + left + right;
    }


    public static TreeNode deserialize(String data) {
        if ("#!".equals(data)) {
            return null;
        }

        String[] arr = data.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : arr) {
            queue.add(s);
        }

        return rebuildTreePre(queue);

    }

    private static TreeNode rebuildTreePre(Queue<String> queue) {
        String str = queue.poll();
        if ("#".equals(str)) {
            return null;
        }

        Integer value = Integer.parseInt(str);
        TreeNode node = new TreeNode(value);
        TreeNode left = rebuildTreePre(queue);
        TreeNode right = rebuildTreePre(queue);
        node.left = left;
        node.right = right;
        return node;
    }


    public static String levelSerialize(TreeNode node) {
        if (node == null) {
            return "#!";
        }

        String result = "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode == null) {
                result += "#!";
                continue;
            }

            Integer value = tempNode.value;
            result = result + value + "!";

            queue.add(tempNode.left);
            queue.add(tempNode.right);
        }

        return result;
    }


    public static TreeNode rebuildTreeLevel(String str) {
        if ("#!".equals(str)) {
            return null;
        }

        String[] array = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String s : array) {
            queue.add(s);
        }

        String firstValue = queue.poll();
        TreeNode headNode = new TreeNode(Integer.parseInt(firstValue));

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(headNode);
        while (!nodeQueue.isEmpty()) {
            TreeNode tempNode = nodeQueue.poll();

            String left = queue.poll();
            TreeNode leftNode = buildNode(left);
            tempNode.left = leftNode;
            if (leftNode != null) {
                nodeQueue.add(leftNode);
            }

            String right = queue.poll();
            TreeNode rightNode = buildNode(right);
            tempNode.right = rightNode;
            if (rightNode != null) {
                nodeQueue.add(rightNode);
            }
        }
        return headNode;
    }

    private static TreeNode buildNode(String str) {
        if ("#".equals(str)) {
            return null;
        }

        return new TreeNode(Integer.parseInt(str));
    }

//
//    // for test -- print tree
//    public static void printTree(TreeNode head) {
//        System.out.println("Binary Tree:");
//        printInOrder(head, 0, "H", 17);
//        System.out.println();
//    }

//
//    public static void printInOrder(TreeNode head, int height, String to, int len) {
//        if (head == null) {
//            return;
//        }
//        printInOrder(head.right, height + 1, "v", len);
//        String val = to + head.value + to;
//        int lenM = val.length();
//        int lenL = (len - lenM) / 2;
//        int lenR = len - lenM - lenL;
//        val = getSpace(lenL) + val + getSpace(lenR);
//        System.out.println(getSpace(height * len) + val);
//        printInOrder(head.left, height + 1, "^", len);
//    }
//
//    public static String getSpace(int num) {
//        String space = " ";
//        StringBuffer buf = new StringBuffer("");
//        for (int i = 0; i < num; i++) {
//            buf.append(space);
//        }
//        return buf.toString();
//    }
//
//    public static void main(String[] args) {
//        TreeNode head = null;
//        printTree(head);
//
//        String pre = preSerialize(head);
//        System.out.println("serialize tree by pre-order: " + pre);
//        head = rebuildTreePre(pre);
//        System.out.print("reconstruct tree by pre-order, ");
//        printTree(head);
//
//        String level = levelSerialize(head);
//        System.out.println("serialize tree by level: " + level);
//        head = rebuildTreeLevel(level);
//        System.out.print("reconstruct tree by level, ");
//        printTree(head);
//
//        System.out.println("====================================");
//
//        head = new TreeNode(1);
//        printTree(head);
//
//        pre = preSerialize(head);
//        System.out.println("serialize tree by pre-order: " + pre);
//        head = rebuildTreePre(pre);
//        System.out.print("reconstruct tree by pre-order, ");
//        printTree(head);
//
//        level = levelSerialize(head);
//        System.out.println("serialize tree by level: " + level);
//        head = rebuildTreeLevel(level);
//        System.out.print("reconstruct tree by level, ");
//        printTree(head);
//
//        System.out.println("====================================");
//
//        head = new TreeNode(1);
//        head.left = new TreeNode(2);
//        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(4);
//        head.right.right = new TreeNode(5);
//        printTree(head);
//
//        pre = preSerialize(head);
//        System.out.println("serialize tree by pre-order: " + pre);
//        head = rebuildTreePre(pre);
//        System.out.print("reconstruct tree by pre-order, ");
//        printTree(head);
//
//        level = levelSerialize(head);
//        System.out.println("serialize tree by level: " + level);
//        head = rebuildTreeLevel(level);
//        System.out.print("reconstruct tree by level, ");
//        printTree(head);
//
//        System.out.println("====================================");
//
//        head = new TreeNode(100);
//        head.left = new TreeNode(21);
//        head.left.left = new TreeNode(37);
//        head.right = new TreeNode(-42);
//        head.right.left = new TreeNode(0);
//        head.right.right = new TreeNode(666);
//        printTree(head);
//
//        pre = preSerialize(head);
//        System.out.println("serialize tree by pre-order: " + pre);
//        head = rebuildTreePre(pre);
//        System.out.print("reconstruct tree by pre-order, ");
//        printTree(head);
//
//        level = levelSerialize(head);
//        System.out.println("serialize tree by level: " + level);
//        head = rebuildTreeLevel(level);
//        System.out.print("reconstruct tree by level, ");
//        printTree(head);
//
//        System.out.println("====================================");
//
//    }
//

}
