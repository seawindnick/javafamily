package com.java.study.offer.kmeans;

import java.util.HashSet;
import java.util.Set;

public class Cluster {
    private int id ;
    private Point center;
    private Set<Point> members = new HashSet<>();

    public Cluster(int id, Point center, Set<Point> members) {
        this.id = id;
        this.center = center;
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Set<Point> getMembers() {
        return members;
    }

    public void setMembers(Set<Point> members) {
        this.members = members;
    }

    public void addPoint(Point point){
        if (!members.contains(point)){
            members.add(point);
        }else {
            throw new IllegalStateException("试图处理同一个样本数据");
        }
    }
}
