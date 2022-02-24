package com.java.study.teach;

/**
 * <Description>
 *
 * @author hushiye
 * @since 7/25/21 17:53
 */
public class OutCount_2 {

    /**
     * -XX:NewSize=100M -XX:MaxNewSize=100M -XX:InitialHeapSize=200M -XX:MaxHeapSize=200M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=20 -XX:PretenureSizeThreshold=30M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:out_count.log
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] arr = new byte[4 * 1024 * 1024];

        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j < 19; j++) {
                byte[] temp1 = new byte[5 * 1024 * 1024];
            }
        }

    }
}
