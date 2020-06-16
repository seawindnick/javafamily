package com.java.study.chapter15;

import java.util.concurrent.atomic.AtomicReference;

public class CasNumberRange {

    private final AtomicReference<IntPair> values = new AtomicReference<>(new IntPair(0, 0));

    public int getLower() {
        return values.get().getLower();
    }

    public int getUpper() {
        return values.get().getUpper();
    }

    public void setLower(int lower) {
        while (true) {
            IntPair oldV = values.get();
            IntPair newv = new IntPair(lower, oldV.getUpper());
            if (values.compareAndSet(oldV, newv)) {
                return;
            }
        }

    }


    private static class IntPair {
        private final int lower;
        private final int upper;

        public IntPair(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }

        public int getLower() {
            return lower;
        }

        public int getUpper() {
            return upper;
        }
    }
}
