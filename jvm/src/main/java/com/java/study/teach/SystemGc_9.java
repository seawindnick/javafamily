package com.java.study.teach;

/**
 * <Description>
 *
 * @author hushiye
 * @since 6/30/21 20:11
 */
public class SystemGc_9 {

    /**
     * -XX:NewSize=100M -XX:MaxNewSize=100M -XX:InitialHeapSize=200M -XX:MaxHeapSize=200M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=30M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:system_gc_9.log
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        byte[] data1 = new byte[1 * 1024 * 1024];
        System.gc();
        Thread.sleep(3000);

    }


}
