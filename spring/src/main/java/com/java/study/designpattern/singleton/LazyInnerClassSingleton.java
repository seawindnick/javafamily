package com.java.study.designpattern.singleton;

public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {
        System.out.println("哈哈");
    }


    public static final LazyInnerClassSingleton getSingltonInstance() {
        LazyInnerClassSingleton lazyInnerClassSingleton = LazyHolder.LAZY;
        return lazyInnerClassSingleton;
    }

    public void test() {
        System.out.println("测试");
    }


    public static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

}
