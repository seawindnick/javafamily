package com.java.study.offer.tree;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

public class RebuildTree3 {


    public static void main(String[] args) {
        int[] arr = new int[]{10,9,8,7,6,5,4};
        TreeNode treeNode = rebuildTree(arr,0,arr.length-1);
        System.out.println(JSONObject.toJSONString(treeNode));
    }

    private static TreeNode rebuildTree(int[] arr, int startIndex, int endIndex) {
        if (arr == null || arr.length == 0){
            return null;
        }

        if (startIndex > endIndex){
            return null;
        }

        int rootValue = arr[startIndex];

        int rightStartIndex = startIndex;
        for (; rightStartIndex <= endIndex; rightStartIndex++) {
            if(arr[rightStartIndex] > rootValue){
                break;
            }
        }


        TreeNode treeNode = new TreeNode();
        treeNode.setValue(rootValue);
        treeNode.setLeft(rebuildTree(arr,startIndex + 1,rightStartIndex-1));
        treeNode.setRight(rebuildTree(arr,rightStartIndex,endIndex));
        return treeNode;
    }


    @Data
    public static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;
    }
}
