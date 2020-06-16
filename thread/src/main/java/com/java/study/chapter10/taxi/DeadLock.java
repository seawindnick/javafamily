package com.java.study.chapter10.taxi;

import lombok.Data;
import org.apache.http.annotation.GuardedBy;

import java.util.HashSet;
import java.util.Set;

public class DeadLock {

    public static class Taxi {
        private final Dispatcher dispatcher;

        @GuardedBy("this")
        private Point location, destination;

        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public synchronized Point getLocation() {
            return location;
        }

        /**
         * 获取本身对象锁
         * notifyAvailable获取dispatcher对象锁
         * @param location
         */
        public synchronized void setLocation(Point location) {
            this.location = location;
            if (location.equals(destination)) {
                dispatcher.notifyAvailable(this);
            }
        }
    }


    @Data
    public static class Point {

    }

    public static class Dispatcher {
        @GuardedBy("this")
        private final Set<Taxi> taxiSet;
        @GuardedBy("this")
        private final Set<Taxi> availableTaxis;

        public Dispatcher() {
            this.taxiSet = new HashSet<>();
            this.availableTaxis = new HashSet<>();
        }

        public synchronized void notifyAvailable(Taxi taxi) {
            availableTaxis.add(taxi);
        }

        /**
         * synchronized 获取本身对象锁
         * taxi.getLocation 获取 taxi 对象锁
         * @return
         */
        public synchronized Image getImage(){
            Image image = new Image();
            for (Taxi taxi : taxiSet) {
                image.setLocation(taxi.getLocation());
            }
            return image;
        }
    }


    @Data
    public static class Image{
        private Point location;

        public Point getLocation() {
            return location;
        }

        public void setLocation(Point location) {
            this.location = location;
        }
    }

}
