package com.java.study.offer.tree;

import lombok.Data;

@Data
public class TreeNode {
    private int value;
    private FindTree.TreeNode left;
    private FindTree.TreeNode right;
}