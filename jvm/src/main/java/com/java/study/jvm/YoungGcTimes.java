package com.java.study.jvm;

/**
 * <Description>
 *
 * @author hushiye
 * @since 6/30/21 11:12
 */
public class YoungGcTimes {

    /**
     * -XX:NewSize=100M -XX:MaxNewSize=100M -XX:InitialHeapSize=200M -XX:MaxHeapSize=200M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:young_gc_times.log
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
        for (int i = 0; i < 50; i++) {
            data = new byte[100 * 1024];
        }
        data = null;
        Thread.sleep(1000);
    }
}
