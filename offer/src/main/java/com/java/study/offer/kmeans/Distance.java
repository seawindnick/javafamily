package com.java.study.offer.kmeans;

public class Distance implements Comparable<Distance> {

    private Point source;
    private Point dest;
    private double dis;
    private AbstractDistance distince;

    @Override
    public int compareTo(Distance o) {
        return 0;
    }
}
