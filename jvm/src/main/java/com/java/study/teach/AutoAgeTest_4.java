package com.java.study.teach;

/**
 * <Description>
 * 动态年龄测试
 *
 * @author hushiye
 * @since 6/20/21 22:49
 */
public class AutoAgeTest_4 {


    /**
     * -XX:NewSize=20M -XX:MaxNewSize=20M -XX:InitialHeapSize=40M -XX:MaxHeapSize=40M -XX:SurvivorRatio=2 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:auto_age_test_4.log
     * <p>
     * Eden 10MB
     * S    5MB
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] array1 = new byte[3 * 1024 * 1024];

        byte[] array2 = new byte[2 * 1024 * 1024];
        array2 = new byte[2 * 1024 * 1024];
        array2 = null;
        array2 = new byte[1024 * 1024];
    }

}
