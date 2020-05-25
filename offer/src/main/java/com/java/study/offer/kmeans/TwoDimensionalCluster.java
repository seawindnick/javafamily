package com.java.study.offer.kmeans;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class TwoDimensionalCluster extends KMeansCluster<Point> {

    @Override
    Point getCenter(List<Point> twoDimensionalPoints) {
        int x = 0;
        int y = 0;

        for (Point twoDimensionalPoint : twoDimensionalPoints) {
            x += twoDimensionalPoint.getX();
            y += twoDimensionalPoint.getY();
        }
        x = x / twoDimensionalPoints.size();
        y = y / twoDimensionalPoints.size();

        return new Point(x, y);
    }

    @Override
    double similarScore(Point p1, Point p2) {
        Math.pow((p1.getX() - p2.getX()),2);
        double distance = Math.sqrt( Math.pow((p1.getX() - p2.getX()),2) +  Math.pow((p1.getY() - p2.getY()),2));
        return distance;
    }

    public static void main(String[] args) {
        int width = 600;
        int height = 400;
        int K = 2;
        TwoDimensionalCluster twoDimensionalCluster = new TwoDimensionalCluster();

        for (int i = 0; i < 200; i++) {
            int x = (int)(Math.random() * width) + 1;
            int y = (int)(Math.random() * height) + 1;
            twoDimensionalCluster.addRecord(new Point(x, y));
        }
        twoDimensionalCluster.setK(K);
        long a = System.currentTimeMillis();
        List<List<Point>> cresult = twoDimensionalCluster.clustering();
        System.out.println(JSONArray.toJSONString(cresult));
        List<Point> center = twoDimensionalCluster.getClusterCenterList();
        System.out.println(JSONArray.toJSONString(center));

        Map<Point,List<Point>> map = twoDimensionalCluster.getClusterListMap();
        map.entrySet().forEach(pointListEntry -> {
            System.out.println(JSONObject.toJSONString(pointListEntry.getKey()));
            System.out.println(JSONArray.toJSONString(pointListEntry.getValue()));
        });

        long b = System.currentTimeMillis();
        System.out.println("耗时：" + (b - a) + "ms");

    }
}
