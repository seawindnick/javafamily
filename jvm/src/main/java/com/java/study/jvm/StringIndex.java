package com.java.study.jvm;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author hushiye
 * @since 7/25/21 18:20
 */
@Slf4j
public class StringIndex {

    /**
     * -XX:NewSize=200M -XX:MaxNewSize=200M -XX:InitialHeapSize=500M -XX:MaxHeapSize=500M  -XX:PretenureSizeThreshold=30M  -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:+PrintGCDetails -Xloggc:string_index.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/hushiye/Downloads/dump
     *
     * @param args
     */
    public static void main(String[] args) {

//        String str1=new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//
//        str1=new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//
//
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        String str3 = str2.intern();
//
//
//        System.out.println(str2.intern() == str2);


        String str = "hello word !!";
//        System.out.println(str);
        log.info("替换之前 :{}", str);
        str = str.replace('l', 'd');
        System.out.println(str);
//        log.info("替换所有字符 :{}", str);
        str = str.replaceAll("d", "l");
        System.out.println(str);
//        log.info("替换全部 :{}", str);
        str = str.replaceFirst("l", "");
        System.out.println(str);
//        log.info("替换第一个 l :{}", str);

//
//        List<String> list = new ArrayList<>();
//        int i = 0;
//        while (true){
//            list.add(String.valueOf(i++).intern());
//        }
//

//        String str = "123";
//        while (true) {
//            str = str + str;
//        }
    }
}
