package com.java.study.chapter5.cache;

import java.util.concurrent.ExecutionException;

public interface Comutable<A,V> {
    V compute(A arg) throws InterruptedException, ExecutionException;
}
