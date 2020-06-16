package com.java.study.offer.chapter5;

import lombok.Data;

public class RebuildTree {


    public static void main(String[] args) {
        //先访问根节点，再访问左子节点，再访问右子节点
        int[] qianXuArray = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        //先访问左子节点，再访问根节点，最后访问右子节点
        int[] zhongxiArray = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode treeNode = buildTree(qianXuArray, zhongxiArray);

        System.out.println(true);
    }

    private static TreeNode buildTree(int[] qianXuArray, int[] zhongxiArray) {
        if (qianXuArray == null || zhongxiArray == null || qianXuArray.length != zhongxiArray.length) {
            return null;
        }

        return construct(qianXuArray, 0, qianXuArray.length - 1, zhongxiArray, 0, zhongxiArray.length - 1);
    }

    private static TreeNode construct(int[] qianXuArray, int qianxuStartIndex, int qianxuEndIndex, int[] zhongxuArray, int zhongxuStartIndex, int zhongxuEndIndex) {
        if (qianxuStartIndex > qianxuEndIndex) {
            return null;
        }
        //获取根节点数据
        int value = qianXuArray[qianxuStartIndex];
        //查询根节点在中序遍历数组中的位置
        int index = zhongxuStartIndex;
        while (index <= zhongxuEndIndex && value != zhongxuArray[index]) {
            index++;
        }

        if (index > zhongxuEndIndex) {
            throw new RuntimeException("无效输入信息");
        }

        TreeNode treeNode = new TreeNode();
        treeNode.setValue(value);
        treeNode.setLeft(construct(qianXuArray, qianxuStartIndex + 1, qianxuStartIndex + (index - zhongxuStartIndex), zhongxuArray, zhongxuStartIndex, index - 1));
        treeNode.setRight(construct(qianXuArray, qianxuStartIndex + (index - zhongxuStartIndex) + 1, qianxuEndIndex, zhongxuArray, index + 1, zhongxuEndIndex));

        return treeNode;
    }


    @Data
    public static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;
    }
}
