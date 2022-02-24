package com.java.study.jvm;

/**
 * <Description>
 *
 * @author hushiye
 * @since 6/20/21 19:48
 */
public class EdenGC {
    /**
     * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
     */

    public static void main(String[] args) {
        byte[] arr = new byte[1024 * 1024];
        arr = new byte[1024 * 1024];
        arr = new byte[1024 * 1024];
        arr = null;

        arr = new byte[2 * 1024 * 1024];

    }
}
