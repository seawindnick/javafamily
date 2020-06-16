package com.java.study.chapter15;

import java.util.concurrent.atomic.AtomicLong;

public class CasCounter {
    private SimulatedCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.comepareAndSwap(v, v + 1));

        return v + 1;



    }

}
