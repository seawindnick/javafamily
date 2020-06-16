package com.java.study.chapter5.cache;

import java.math.BigInteger;

public class ExpensiveFunction implements Comutable<String,BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}
