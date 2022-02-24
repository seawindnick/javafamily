package com.java.study.basic;

import java.util.ArrayDeque;

/**
 * <Description>
 *
 * @author hushiye
 * @since 10/24/21 20:36
 */
public class ArrayQueueTest {

    public static void main(String[] args) {
        ArrayDeque arrayDeque = new ArrayDeque<>();
        arrayDeque.push(1);
        arrayDeque.push(2);

        arrayDeque.addLast(4);
        arrayDeque.addLast(45);
        arrayDeque.addFirst(5);
        arrayDeque.pop();

    }
}
