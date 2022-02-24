package com.java.study.zuo.tree;

import java.util.LinkedList;

/**
 * 树序列化与反序列化
 */
public class SerializeAndReconstructTree {


    /**
     * 先序遍历序列化
     *
     * @param treeNode
     * @return
     */
    public static String serializedByPre(TreeNode treeNode) {
        String str = "";
        if (treeNode == null) {
            str = "#!";
            return str;
        }

        str = treeNode.getValue() + "!";
        str = str + serializedByPre(treeNode.getLeft());
        str = str + serializedByPre(treeNode.getRight());
        return str;
    }


    /**
     * 先序遍历反解析
     *
     * @param str
     * @return
     */
    private static TreeNode reSerializedByPre(String str) {
        if ("#!".equals(str)) {
            return null;
        }

        String[] arr = str.split("!");
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            linkedList.add(arr[i]);
        }

        TreeNode treeNode = rebuildTree(linkedList);
        return treeNode;
    }

    /**
     * 层级序列化
     *
     * @return
     */
    public static String serializeByLevel(TreeNode treeNode) {
        if (treeNode == null) {
            return "#!";
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(treeNode);
        String str = "";
        while (!list.isEmpty()) {
            TreeNode node = list.pop();
            if (node != null) {
                str = str + node.value + "!";
                list.add(node.getLeft());
                list.add(node.getRight());
            } else {
                str = str + "#!";
            }

        }

        return str;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        PrintBinaryTree.printBinaryTree(head);
//        String str = serializedByPre(head);
//        System.out.println(str);


//        TreeNode treeNode = reSerializedByPre(str);
        System.out.println("---------------------");
//        PrintBinaryTree.printBinaryTree(treeNode);

        System.out.println("---------------------");
        String str = serializeByLevel(head);
        System.out.println(str);

        TreeNode newTreeNode = rebuildLevel(str);
        PrintBinaryTree.printBinaryTree(newTreeNode);

    }

    private static TreeNode rebuildLevel(String str) {
        if ("#!".equals(str)) {
            return null;
        }
        String[] array = str.split("!");
        LinkedList<TreeNode> linkedList = new LinkedList();
        int index = 0;
        TreeNode headNode = buildNode(array[index++]);
        linkedList.add(headNode);

        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.pop();
            node.left = buildNode(array[index++]);
            node.right = buildNode(array[index++]);

            if (node.left != null){
                linkedList.add(node.getLeft());
            }
            if (node.right != null){
                linkedList.add(node.getRight());
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

    private static TreeNode rebuildTree(LinkedList<String> linkedList) {
        String str = linkedList.poll();
        if ("#".equals(str)) {
            return null;
        }

        //创建完节点
        TreeNode treeNode = new TreeNode(Integer.parseInt(str));
        treeNode.setLeft(rebuildTree(linkedList));
        treeNode.setRight(rebuildTree(linkedList));
        return treeNode;
    }


}
