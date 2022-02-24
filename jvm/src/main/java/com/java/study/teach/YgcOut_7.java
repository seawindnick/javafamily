package com.java.study.teach;

/**
 * <Description>
 *
 * @author hushiye
 * @since 6/22/21 22:18
 */
public class YgcOut_7 {

    /**
     * -XX:NewSize=10M -XX:MaxNewSize=10M -XX:InitialHeapSize=20M -XX:MaxHeapSize=20M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:ygc_out_7.log
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] array = new byte[2 * 1024 * 1024];
        array = new byte[2 * 1024 * 1024];
        array = new byte[2 * 1024 * 1024];

        byte[] arr = new byte[128 * 1024];

        byte[] array3 = new byte[2 * 1024 * 1024];
    }
}
