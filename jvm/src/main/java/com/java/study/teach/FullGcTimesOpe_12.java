package com.java.study.teach;

/**
 * <Description>
 *
 * @author hushiye
 * @since 7/26/21 11:42
 */
public class FullGcTimesOpe_12 {

    /**
     * -XX:NewSize=300M -XX:MaxNewSize=300M -XX:InitialHeapSize=400M -XX:MaxHeapSize=400M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=30M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:full_gc_times_ope_12.log
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
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
