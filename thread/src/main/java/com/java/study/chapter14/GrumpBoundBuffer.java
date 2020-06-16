package com.java.study.chapter14;

public class GrumpBoundBuffer<V> extends BaseBoundedBuffer<V> {
    public GrumpBoundBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws Exception {
        if (isFull()) {
            throw new Exception("队列已满");
        }
        doPut(v);
    }

    public synchronized V take() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列是空的");
        }
        return doTake();
    }


    public static void main(String[] args) throws InterruptedException {

        GrumpBoundBuffer<String> grumpBoundBuffer = new GrumpBoundBuffer(10);
        while (true){
            try {
                String item = grumpBoundBuffer.take();
                //doSomething
                break;
            } catch (Exception e) {
               Thread.sleep(1000);
            }
        }

    }


}
