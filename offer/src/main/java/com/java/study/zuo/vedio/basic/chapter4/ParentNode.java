package com.java.study.zuo.vedio.basic.chapter4;

import lombok.Data;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-25 23:24
 */
@Data
public class ParentNode {
    public int value;
    public ParentNode left;
    public ParentNode right;
    public ParentNode parent;
    public ParentNode(int data) { this.value = data;
    }
}
