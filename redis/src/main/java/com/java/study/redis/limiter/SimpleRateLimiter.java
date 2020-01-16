package com.java.study.redis.limiter;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

public class SimpleRateLimiter {
    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }


    /***
     * 1.设置zset score值为当前时间
     * 2.获取score大于 过去多少时间的 数量
     * 3.为key设置过期时间，如果 过去了X时间之后没有调用，数据就没有意义，可以进行清除
     * 4.判断 过去一段时间的请求梳理是否小于限定量
     *
     * @param userId
     * @param actionKey
     * @param period
     * @param maxCount
     * @return
     * @throws IOException
     */
    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws IOException {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        Pipeline pipeline = jedis.pipelined();
        pipeline.multi();
        pipeline.zadd(key, nowTs, "" + nowTs);
        pipeline.zremrangeByScore(key, 0, nowTs - period + 1000);
        Response<Long> count = pipeline.zcard(key);
        pipeline.expire(key, period + 1);
        pipeline.exec();
        pipeline.close();
        return count.get() <= maxCount;
    }


    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis();
        SimpleRateLimiter simpleRateLimiter = new SimpleRateLimiter(jedis);
        for (int i = 0; i < 20; i++) {
            System.out.println(simpleRateLimiter.isActionAllowed(
                    "1111", "reply", 60, 6
            ));
        }
    }

}
