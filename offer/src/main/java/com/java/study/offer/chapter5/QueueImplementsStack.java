package com.java.study.offer.chapter5;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementsStack<E> {
    private Queue<E> queue1 = new LinkedList();
    private Queue<E> queue2 = new LinkedList();


    public void push(E e) {
        Queue addQueue = queue1.isEmpty() ? queue2 : queue1;
        addQueue.add(e);
    }

    public E pop() {
        if (queue1.isEmpty() && queue2.isEmpty()){
            throw new RuntimeException("没有元素了");
        }
        Queue<E> outQueue = queue1;
        Queue<E> inQueue = queue2;
        if (queue1.isEmpty()) {
            outQueue = queue2;
            inQueue = queue1;
        }

        while (!outQueue.isEmpty()) {
            E e = outQueue.poll();
            if (outQueue.isEmpty()) {
                return e;
            }
            inQueue.add(e);
        }
        return null;
    }
}
