package com.java.study.chapter10.taxi;

import lombok.Data;
import org.apache.http.annotation.GuardedBy;

import java.util.HashSet;
import java.util.Set;

public class Taxi {


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
     *
     * @param location
     */
    public void setLocation(Point location) {
        boolean reachedDestination;
        /**
         * 只持有自己部分的锁，获取别人的锁时，将自己的锁释放掉
         */
        synchronized (this) {
            this.location = location;
            reachedDestination = location.equals(destination);
        }
        if (reachedDestination) {
            dispatcher.notifyAvailable(this);
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
         *
         * @return
         */
        public Image getImage() {
            Set<Taxi> copy;
            /**
             * 只持有自己部分的锁，获取别人的锁时，将自己的锁释放掉
             */
            synchronized (this) {
                copy = new HashSet<>(taxiSet);
            }
            Image image = new Image();
            for (Taxi taxi : copy) {
                image.setLocation(taxi.getLocation());
            }
            return image;
        }
    }


    @Data
    public static class Image {
        private Point location;

        public Point getLocation() {
            return location;
        }

        public void setLocation(Point location) {
            this.location = location;
        }
    }


}
