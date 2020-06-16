package com.java.study.chapter5;

import lombok.Data;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Preloader {
    private final FutureTask<ProductInfo> futureTask = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {
            return loadProductInfo();
        }
    });

    private final Thread thread = new Thread(futureTask);

    public void start() {
        thread.start();
    }

    private ProductInfo loadProductInfo() throws InterruptedException {

        Thread.sleep(10000);
        ProductInfo productInfo = new ProductInfo();
        return productInfo;
    }


    public ProductInfo get() throws ExecutionException, InterruptedException {
        return futureTask.get();
    }


    @Data
    public static class ProductInfo {
        private String name = "haha";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Preloader preloader = new Preloader();
        preloader.start();
        ProductInfo productInfo = preloader.get();
        System.out.println(productInfo.getName());
    }

}
