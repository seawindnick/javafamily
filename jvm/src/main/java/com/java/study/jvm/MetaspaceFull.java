package com.java.study.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <Description>
 *
 * @author hushiye
 * @since 7/5/21 17:29
 */
public class MetaspaceFull {

    /**
     * -XX:NewSize=1024M -XX:MaxNewSize=1024M -XX:InitialHeapSize=2048M -XX:MaxHeapSize=2048M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps  -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -Xloggc:metaspace_full.log
     * <p>
     * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M -XX:+PrintGCDetails -Xloggc:metaspace_full.log -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=./
     *
     * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:+PrintGCDetails -Xloggc:metaspace_full.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/hushiye/Downloads/dump
     * @param args
     */
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if (method.getName().equals("run")) {
                        System.out.println("汽车启动");
                        return methodProxy.invokeSuper(o, objects);
                    } else {
                        return methodProxy.invokeSuper(o, objects);
                    }
                }
            });

            Car car = (Car) enhancer.create();
            car.run();
        }
    }


    public static class Car {
        public void run() {
            System.out.println("汽车启动，行驶中");
        }
    }


//    public static void main(String[] args) {
//        int counter = 0;
//        while (true) {
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(Car.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback(new MethodInterceptor() {
//                @Override
//                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                    if (method.getName().equals("run")) {
//                        System.out.println("running, enhanced");
//                        return methodProxy.invokeSuper(o, objects);
//                    } else {
//                        return methodProxy.invokeSuper(o, objects);
//                    }
//                }
//            });
//
//            Car car = (Car) enhancer.create();
//            car.run();
//
////            System.out.println("目前创建了 " + (counter++) + " 个Car的动态子类");
//        }
//    }
//
//    static class Car {
//        public void run() {
//            System.out.println("running...");
//        }
//    }
}
