package com.study.basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * <Description>
 *
 * @author hushiye
 * @since 11/14/21 16:34
 */
public class LHCLock implements Lock {

    private final ThreadLocal<Node> prev;
    private final ThreadLocal<Node> node;
    private final AtomicReference<Node> tail = new AtomicReference<>(new Node());

    public LHCLock() {
        this.prev = ThreadLocal.withInitial(() -> null);
        this.node = ThreadLocal.withInitial(Node::new);
    }

    /**
     * 申请获取锁
     */
    @Override
    public void lock() {
        //获取当前节点
        final Node node = this.node.get();
        node.locked = true;
        //获取历史旧尾部节点，并且设置当前节点为尾部节点
        Node previous = this.tail.getAndSet(node);
        //
        this.prev.set(previous);
        while (previous.locked) {
        }
        ;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        final Node node = this.node.get();
        node.locked = false;
        this.node.set(this.prev.get());
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private static class Node {
        private volatile boolean locked;
    }
}


