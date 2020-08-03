package com.java.study.chapter6;

import java.util.concurrent.Executors;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-07-28 17:15
 */
public class ThreadPoolExecutorError {
    public static void main(String[] args) {

        //最大 Integer.MAX_VALUE ，可能会造成OOM
        Executors.newFixedThreadPool(5);

        //最大 Integer.MAX_VALUE ，可能会造成OOM
        Executors.newSingleThreadExecutor();


        //核心线程数 最大 Integer.MAX_VALUE，资源耗尽
        Executors.newCachedThreadPool();

        //核心线程数 最大 Integer.MAX_VALUE，资源耗尽
        Executors.newScheduledThreadPool(5);

    }
}
