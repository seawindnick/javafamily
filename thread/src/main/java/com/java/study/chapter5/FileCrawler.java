package com.java.study.chapter5;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FileCrawler implements Runnable {
    private final BlockingQueue<File> fileBlockingQueue;
    private final File root;

    public FileCrawler(BlockingQueue<File> fileBlockingQueue, File root) {
        this.fileBlockingQueue = fileBlockingQueue;
        this.root = root;
    }

    @Override
    public void run() {
        try {
            crawle(root);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void crawle(File root) throws InterruptedException {
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    crawle(file);
                } else {
                    fileBlockingQueue.put(file);
                }
            }
        }
    }


    public static class Indexer implements Runnable {
        private final BlockingQueue<File> queue;

        public Indexer(BlockingQueue<File> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    indexFile(queue.take());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void indexFile(File file) {
            System.out.println(file.getName());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<File> fileBlockingQueue = new ArrayBlockingQueue<File>(100);
        File file = new File("/Volumes/work/company");
        Thread thread = new Thread(new FileCrawler(fileBlockingQueue, file));
        thread.start();

        Thread thread2 = new Thread(new Indexer(fileBlockingQueue));
        thread2.start();

        Thread.sleep(10000);

        thread.interrupt();
        thread2.interrupt();
    }


}
