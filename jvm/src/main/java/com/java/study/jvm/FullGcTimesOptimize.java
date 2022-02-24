package com.java.study.jvm;

/**
 * <Description>
 *
 * @author hushiye
 * @since 6/30/21 20:11
 */
public class FullGcTimesOptimize {


    /**
     * -XX:NewSize=200M -XX:MaxNewSize=200M -XX:InitialHeapSize=300M -XX:MaxHeapSize=300M -XX:SurvivorRatio=2 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=30M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:full_gc_times_optimize.log
     *
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        while (true) {
            loadData();
        }

    }

    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 4; i++) {
            data = new byte[10 * 1024 * 1024];
        }

        data = null;

        byte[] data1 = new byte[10 * 1024 * 1024];
        byte[] data2 = new byte[10 * 1024 * 1024];
        byte[] data3 = new byte[10 * 1024 * 1024];
        data3 = new byte[10 * 1024 * 1024];
        Thread.sleep(1000);

    }


}
