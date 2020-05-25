package com.java.study.designpattern.simplefactor;

import com.java.study.designpattern.factory.ICourceFactory;
import com.java.study.designpattern.factory.JavaFactory;

public class FactoryTest {
    public static void main(String[] args) {
        ICourceFactory courceFactory = new JavaFactory();
        courceFactory.createNote().edit();
        courceFactory.createVideo().record();
    }

}
