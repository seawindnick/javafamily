package com.java.study.offer.tree;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

public class RebuildTree4 {

    public static void main(String[] args) {
        //先访问根节点，再访问左子节点，再访问右子节点
        int[] qianXuArray = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        //先访问左子节点，再访问根节点，最后访问右子节点
        int[] zhongxiArray = new int[]{4, 7, 2, 1, 5, 3, 8, 6};


        TreeNode treeNode = rebuildTree(qianXuArray, 0, qianXuArray.length - 1, zhongxiArray, 0, zhongxiArray.length - 1);
        System.out.println(JSONObject.toJSONString(treeNode));
    }

    private static TreeNode rebuildTree(int[] qianXuArray, int qianxuStartIndex, int qianxuEndIndex, int[] zhongxiArray, int zhongxuStartIndex, int zhongxuEndIndex) {
        if (qianXuArray == null || zhongxiArray == null || qianxuStartIndex > qianxuEndIndex) {
            return null;
        }


        int rootValue = qianXuArray[qianxuStartIndex];

        //获取根节点在中序遍历结果中的位置
        int rootInZhongXuIndex = zhongxuStartIndex;
        for (; rootInZhongXuIndex <= zhongxuEndIndex; rootInZhongXuIndex++) {
            if (zhongxiArray[rootInZhongXuIndex] == rootValue) {
                break;
            }
        }

        TreeNode treeNode = new TreeNode();
        treeNode.setValue(rootValue);

        int qianXuLeftTreeStartIndex = qianxuStartIndex + 1;
        int qianxuLeftTreeEndIndex = (qianxuStartIndex) + (rootInZhongXuIndex - zhongxuStartIndex);
        int qianxuRightTreeStartIndex = qianxuStartIndex + (rootInZhongXuIndex - zhongxuStartIndex) + 1;
        int qianxuRightEndIndex = qianxuEndIndex;

        int zhongxuLeftTreeStartIndec = zhongxuStartIndex;
        int zhongxuLeftTreeEndIndex = rootInZhongXuIndex - 1;
        int zhongxuRightStartIndex = rootInZhongXuIndex + 1;
        int zhongxuRightEndIndex = zhongxuEndIndex;


        treeNode.setLeft(rebuildTree(qianXuArray, qianXuLeftTreeStartIndex, qianxuLeftTreeEndIndex, zhongxiArray, zhongxuLeftTreeStartIndec, zhongxuLeftTreeEndIndex));
        treeNode.setRight(rebuildTree(qianXuArray, qianxuRightTreeStartIndex, qianxuRightEndIndex, zhongxiArray, zhongxuRightStartIndex, zhongxuRightEndIndex));

        return treeNode;
    }


    @Data
    public static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;
    }


}
