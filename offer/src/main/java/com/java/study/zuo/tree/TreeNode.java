package com.java.study.zuo.tree;

import lombok.Data;

@Data
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}
