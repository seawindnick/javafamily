package com.java.study.chapter4;

import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MonitorVehicleTracker {

    private final Map<String,MutablePoint> locations;


    public MonitorVehicleTracker(Map<String,MutablePoint> locations){
        this.locations = deepCopy(locations);
    }


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
