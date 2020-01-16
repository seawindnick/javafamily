package com.java.study.redis.lock;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisWithReentrantLock {


    private ThreadLocal<Map<String, Integer>> lockers = new ThreadLocal<Map<String, Integer>>();

    private Jedis jedis;

    private RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    private boolean _lock(String key) {
        return jedis.set(key, "", "nx", "ex", 5L) != null;
    }

    private void _unlock(String key) {
        jedis.del(key);
    }

    private Map<String, Integer> currentLockers() {
        Map<String, Integer> refs = lockers.get();
        if (refs != null) {
            return refs;
        }
        lockers.set(new HashMap<String, Integer>());
        return lockers.get();
    }


    public boolean lock(String key) {
        Map<String, Integer> refs = this.currentLockers();
        Integer redCnt = refs.get(key);
        if (redCnt != null) {
            refs.put(key, redCnt + 1);
            return Boolean.TRUE;
        }


        boolean ok = this._lock(key);
        if (!ok) {
            return Boolean.FALSE;
        }
        refs.put(key, 1);
        return Boolean.TRUE;
    }

    public boolean unlock(String key) {
        Map<String, Integer> refs = this.currentLockers();
        Integer refCnt = refs.get(key);
        if (refCnt == null) {
            return false;
        }

        refCnt = refCnt - 1;
        if (refCnt > 0) {
            refs.put(key, refCnt);
        } else {
            refs.remove(key);
            this._unlock(key);
        }
        return Boolean.TRUE;
    }


    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        RedisWithReentrantLock redisWithReentrantLock = new RedisWithReentrantLock(jedis);
        System.out.println(redisWithReentrantLock.lock("codehole"));
        System.out.println(redisWithReentrantLock.lock("codehole"));
        System.out.println(redisWithReentrantLock.unlock("codehole"));
        System.out.println(redisWithReentrantLock.unlock("codehole"));
    }


}
