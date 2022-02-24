package com.java.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author hushiye
 * @since 7/6/21 11:42
 */
public class OOM {

    /**
     * -Xms10m -Xmx10m  -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:+PrintGCDetails -Xloggc:oom.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/hushiye/Downloads/dump
     *
     * @param args
     */
    public static void main(String[] args) {
        List list = new ArrayList();
        while (true) {
            list.add(new Object());
        }

    }
}
