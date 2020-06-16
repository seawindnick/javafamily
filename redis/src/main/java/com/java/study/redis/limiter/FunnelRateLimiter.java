package com.java.study.redis.limiter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FunnelRateLimiter {

    static class Funnel {
        int capacity;//漏斗容量
        float leakingRate;//漏嘴流水速率
        int leftQuota;//漏斗剩余空间
        long leakingTs;//上一次漏水时间

        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            this.leftQuota = capacity;//剩余空间与漏斗容量一致
            this.leakingTs = System.currentTimeMillis();//上一次漏水时间为当前时间
        }


        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long deltaTs = nowTs - leakingTs;//距离上一次流水过了多少时间
            int deltaQuota = (int) (deltaTs * leakingRate);//计算过去的一段时间，流出了多少水
            if (deltaQuota < 0) {//如果间隔时间较长，发生溢出，重新进行初始化
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }

            if (deltaQuota < 1) {//流出的水较少
                return;
            }

            this.leftQuota += deltaQuota;//可以盛放的水量 + 过去X时流去的水量
            this.leakingTs = nowTs;//重新设置上一次使用时间

            if (this.leftQuota > this.capacity) {//溢出判断
                this.leftQuota = this.capacity;
            }
        }

        boolean water(int quota) {
            makeSpace();
            if (this.leftQuota >= quota) {
                this.leftQuota -= quota;//可以盛放水量的空间减少
                return true;
            }
            return false;
        }

    }

    private Map<String, Funnel> funnelMap = new HashMap<>();

    public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
        String key = String.format("%s:%s", userId, actionKey);
        Funnel funnel = funnelMap.get(key);
        if (Objects.isNull(funnel)) {
            funnel = new Funnel(capacity, leakingRate);
            funnelMap.put(key, funnel);
        }
        return funnel.water(1);
    }


    public static void main(String[] args) throws InterruptedException {
        FunnelRateLimiter funnelRateLimiter = new FunnelRateLimiter();
        for (int i = 0; i < 1000; i++) {
            System.out.println(funnelRateLimiter.isActionAllowed("111", "aaa", 10, 1));
        }
    }


}
