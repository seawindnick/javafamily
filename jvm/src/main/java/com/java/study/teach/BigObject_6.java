package com.java.study.teach;

/**
 * <Description>
 *
 * @author hushiye
 * @since 7/26/21 10:37
 */
public class BigObject_6 {


    /**
     * -XX:NewSize=20M -XX:MaxNewSize=20M -XX:InitialHeapSize=50M -XX:MaxHeapSize=50M -XX:SurvivorRatio=2 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=30M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:big_object_6.log
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] array1 = new byte[21 * 1024 * 1024];
    }
}
