package com.java.study.teach;

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
public class MetaspaceFull_10 {

    /**
     * -XX:NewSize=1024M -XX:MaxNewSize=1024M -XX:InitialHeapSize=2048M -XX:MaxHeapSize=2048M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps  -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -Xloggc:metaspace_full_10.log
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
}
