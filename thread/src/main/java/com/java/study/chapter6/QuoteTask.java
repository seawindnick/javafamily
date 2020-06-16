package com.java.study.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class QuoteTask implements Callable<String> {
    private String name;

    public QuoteTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        System.out.println(name + "哈哈");
        return name;
    }








}
