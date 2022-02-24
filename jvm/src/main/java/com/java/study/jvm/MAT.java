package com.java.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author hushiye
 * @since 7/2/21 12:29
 */
public class MAT {

    public static void main(String[] args) throws InterruptedException {

        List<Data> list = new ArrayList<Data>();
        for (int i = 0; i < 100000; i++) {
            list.add(new Data());

        }
        Thread.sleep(60 * 60 * 1000);
    }

    static class Data {

    }
}
