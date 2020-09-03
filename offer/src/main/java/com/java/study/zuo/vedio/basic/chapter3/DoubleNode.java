package com.java.study.zuo.vedio.basic.chapter3;

import lombok.Data;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 23:44
 */
@Data
public class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data) {
        this.value = data;
    }
}
