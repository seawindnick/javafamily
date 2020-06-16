package com.java.study.chapter4;

import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class MonitorVehicleTracker {

    private final Map<String,MutablePoint> locations;


    public MonitorVehicleTracker(Map<String,MutablePoint> locations){
        this.locations = deepCopy(locations);
    }


    /**
     * 并不只是使用 unmodifiableMap 包装 Map，只能防止容器对象被修改，不能防止调用者修改保存在容器内的可变对象
     * 如果只是通过拷贝构造函数填充deepCopy中的HashMap,只是复制了Point对西那个的引用，没有复制对象本身
     *
     * 由于 方法是在 synchronized 中调用，再执行时间较长的复制操作中，其内置锁将一直被占用，当有大量数据需要访问时，会严重降低相应性能
     * @return
     */
    public synchronized Map<String,MutablePoint> getLocations(){
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id){
        MutablePoint mutablePoint =  locations.get(id);
        return Objects.isNull(mutablePoint) ? null : new MutablePoint(mutablePoint);
    }

    public synchronized void setLocations(String id,int x,int y){
       MutablePoint loc = locations.get(id);
       if (Objects.nonNull(loc)){
           loc.setX(x);
           loc.setY(y);
       }
    }

    private Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations) {
        Map<String,MutablePoint> result = new HashMap<>();

        locations.keySet().forEach(id -> result.put(id,locations.get(id)));
        //返回不可修改的Map集合
        return Collections.unmodifiableMap(result);
    }


    @Data
    public static class MutablePoint{
        private int x,y;

        public MutablePoint() {
            x = 0;
            y = 0;
        }

        public MutablePoint(MutablePoint mutablePoint) {


            this.x = mutablePoint.getX();
            this.y = mutablePoint.getY();
        }
    }
}
