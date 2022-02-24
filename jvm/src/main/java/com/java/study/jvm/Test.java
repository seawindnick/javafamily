package com.java.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author hushiye
 * @since 6/10/21 12:06
 */
public class Test {
    public static void main(String[] args) {
//        test();
        List<String> list = new ArrayList<>();
        int count = 1;
        while (true) {
            System.out.println(list.size());
            list.add((++count) + "");
        }

    }


    private static void test(){
        test();
    }
}
