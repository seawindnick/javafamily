package com.java.study.chapter4;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DelegatingVehicleTracker {

    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        /**
         * 保存的是 locations 节点的地址，不是 points 节点的地址
         * 当 locations 节点的属性值发生变化时，unmodifiableMap可以同样查询到数据
         * 因为是根据地址访问信息的
         */
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }


    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }


    public Point getPoint(String id) {
        return locations.get(id);
    }

    public void setLocations(String id, int x, int y) {

        if (locations.replace(id, new Point(x, y)) == null) {
            throw new RuntimeException("无效数据");
        }
    }

    @Data
    public static class Point {
        private final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Point point = new Point(1,2);
        Map map = new HashMap();
        map.put("测试",point);

        DelegatingVehicleTracker delegatingVehicleTracker = new DelegatingVehicleTracker(map);
        System.out.println(JSONObject.toJSONString(delegatingVehicleTracker.getLocations()));


        delegatingVehicleTracker.setLocations("测试",3,6);
        Point point1 = delegatingVehicleTracker.getPoint("测试");
        System.out.println(JSONObject.toJSONString(point1));
        System.out.println(JSONObject.toJSONString(delegatingVehicleTracker.getLocations()));

    }
}
