
package com.java.study.chapter6;

import com.alibaba.fastjson.JSONArray;
import com.sun.applet2.preloader.CancelException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        List<QuoteTask> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            QuoteTask quoteTask = new QuoteTask("姓名" + i);
            list.add(quoteTask);
        }

        List<String> result = new ArrayList<>(list.size());

        List<Future<String>> futureList = ThreadPoolExecutorUtil.getThreadPoolExecutor().invokeAll(list, 1, TimeUnit.SECONDS);
        for (Future<String> stringFuture : futureList) {
            try {
                String str = stringFuture.get();
                result.add(str);
            } catch (ExecutionException e) {
                result.add(e.getCause().getMessage());
            } catch (CancellationException ex) {
                result.add(ex.getCause().getMessage());
            }
        }

        System.out.println(JSONArray.toJSONString(result));

    }

}
