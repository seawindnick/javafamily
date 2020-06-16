package com.java.study.chapter12;

import org.omg.CORBA.Object;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class BoundBuffer<E> {

    private final Semaphore availableItems;//可以从缓存中删除元素个数，初始值为0
    private final Semaphore availableSpaces;//可以插入到缓存的元素个数，初始值等于缓存大小


    private final E[] items;

    private int putPosition = 0, takePosition = 0;

    public BoundBuffer(int capacity) {
        availableItems = new Semaphore(0);
        availableSpaces = new Semaphore(capacity);
        items = (E[]) new Object[capacity];
    }


    public boolean isEmpty() {
        return availableItems.availablePermits() == 0;
    }

    public boolean isFull() {
        return availableSpaces.availablePermits() == 0;
    }

    //与take方法执行顺序相反
    public void put(E x) throws InterruptedException {
        availableSpaces.acquire();
        doInsert(x);
        availableItems.release();
    }

    public E take() throws InterruptedException {
        /**
         * 先从 availableItems 获取一个许可，如果缓存中不为空，
         * 该请求会立即成功，否则会阻塞直到缓存不空
         * 获取一个许可后，take方法将删除缓存中的下一个元素，并返回一个许可到availableSpaces信号量
         */
        availableItems.acquire();
        E item = doExtract();
        availableSpaces.release();
        return item;
    }

    //记录下一次需要插入元素的位置
    private synchronized void doInsert(E x) {
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0 : i;

    }


    //记录下一次需要获取元素的位置
    private synchronized E doExtract() {
        int i = takePosition;
        E x = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? 0 : i;
        return x;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(10);
        arrayBlockingQueue.put("123");
        arrayBlockingQueue.take();

    }

}
