package com.java.study.zuo.vedio.basic.chapter3;

import lombok.Data;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 18:20
 */
@Data
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}
