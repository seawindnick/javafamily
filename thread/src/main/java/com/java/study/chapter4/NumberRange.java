package com.java.study.chapter4;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberRange {

    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);


    public void setLower(int i) {
        if (i > upper.get()) {
            throw new IllegalArgumentException("测试1");
        }

        lower.set(i);
    }


    public void setUpper(int i) {
        if (i < lower.get()) {
            throw new IllegalArgumentException("测试2");
        }
    }

    public boolean isTnTange(int i) {
        return i >= lower.get() && i <= upper.get();
    }

}
