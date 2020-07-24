package com.java.study.zuo.linkedList;

import lombok.Data;

@Data
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}