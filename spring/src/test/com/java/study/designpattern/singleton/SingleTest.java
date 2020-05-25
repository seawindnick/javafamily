package com.java.study.designpattern.singleton;

public class SingleTest {
    public static void main(String[] args) {
        LazyInnerClassSingleton lazyInnerClassSingleton = LazyInnerClassSingleton.getSingltonInstance();
        lazyInnerClassSingleton.test();

    }
}
