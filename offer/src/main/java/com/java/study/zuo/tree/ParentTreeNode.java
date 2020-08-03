package com.java.study.zuo.tree;

import lombok.Data;

@Data
public class ParentTreeNode {

    public int value;
    public ParentTreeNode left;
    public ParentTreeNode right;
    public ParentTreeNode parent;

    public ParentTreeNode(int value) {
        this.value = value;
    }
}
