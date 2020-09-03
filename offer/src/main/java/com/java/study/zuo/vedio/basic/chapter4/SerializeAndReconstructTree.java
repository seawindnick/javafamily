package com.java.study.zuo.vedio.basic.chapter4;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-29 22:10
 */
public class SerializeAndReconstructTree {


    public static String serialByPre(TreeNode treeNode) {
        if (treeNode == null) {
            return "#!";
        }

        int value = treeNode.value;
        String indexValue = value + "!";
        String left = serialByPre(treeNode.left);
        String right = serialByPre(treeNode.right);
        return indexValue + left + right;
    }


    private static TreeNode reconByPreString(String pre) {
        String[] arr = pre.split("!");
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            linkedList.add(arr[i]);
        }

        TreeNode rootNode = buildTree(linkedList);

        return rootNode;
    }

    private static TreeNode buildTree(LinkedList<String> arr) {
        String str = arr.poll();
        if (Objects.equals(str, "#")) {
            return null;
        }
        int value = Integer.parseInt(str);
        TreeNode treeNode = new TreeNode(value);

        TreeNode left = buildTree(arr);
        TreeNode right = buildTree(arr);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }


    public static String serialByPos(TreeNode treeNode) {
        if (treeNode == null) {
            return "#!";
        }

        int value = treeNode.value;
        String indexValue = value + "!";
        String left = serialByPos(treeNode.left);
        String right = serialByPos(treeNode.right);
        return left + right + indexValue;
    }


    public static String serlizerLevel(TreeNode treeNode) {
        if (treeNode == null) {
            return "#!";
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        String str = "";
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                str += node.value + "!";
                queue.add(node.left);
                queue.add(node.right);
            } else {
                str += "#!";
            }

        }
        return str;

    }


    private static TreeNode reconByLevelString(String pre) {
        String[] arr = pre.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        return buildLevelTree(queue);



    }

    private static TreeNode buildLevelTree(Queue<String> queue) {
        TreeNode headNode = buildTreeNode(queue);
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(headNode);

        while (!queue.isEmpty()){
            TreeNode parentNode = treeNodeQueue.poll();
            parentNode.left = buildTreeNode(queue);
            parentNode.right =  buildTreeNode(queue);
            if (parentNode.left != null){
                treeNodeQueue.add(parentNode.left);
            }
            if (parentNode.right != null){
                treeNodeQueue.add(parentNode.right);
            }

        }
        return headNode;

    }

    private static TreeNode buildTreeNode(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)){
            return null;
        }
        return new TreeNode(Integer.parseInt(value));
    }


    // for test -- print tree
    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }


    public static void main(String[] args) {
        TreeNode head = null;
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serlizerLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new TreeNode(1);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serlizerLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serlizerLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new TreeNode(100);
        head.left = new TreeNode(21);
        head.left.left = new TreeNode(37);
        head.right = new TreeNode(-42);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(666);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serlizerLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

    }

}
