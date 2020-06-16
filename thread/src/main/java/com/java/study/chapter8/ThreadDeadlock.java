package com.java.study.chapter8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDeadlock {

    public  static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static class RenderPageTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            Future<String> header,footer;
            header = executorService.submit(new LoadFileTask("header.html"));
            footer = executorService.submit(new LoadFileTask("footer.html"));
            //发生死锁，等待线程池结果
            return header.get() + footer.get();
        }
    }


    public static class LoadFileTask implements Callable<String>{
        private String str;

        public LoadFileTask(String str) {
            this.str = str;
        }

        @Override
        public String call() throws Exception {
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        executorService.submit(new RenderPageTask());
    }

}
