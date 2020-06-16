package com.java.study.chapter7;

import com.alibaba.fastjson.JSONArray;
import org.apache.http.annotation.GuardedBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class PrimeGenerator implements Runnable {

    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    public void cancel() {
        cancelled = true;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }

    }


    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    public static void main(String[] args) throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();;
        try {
            SECONDS.sleep(1);
        }finally {
            generator.cancel();
        }
        List<BigInteger> list =  generator.get();
        System.out.println(JSONArray.toJSONString(list));
    }

}
