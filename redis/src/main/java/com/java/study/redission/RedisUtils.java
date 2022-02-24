package com.java.study.redission;

import lombok.SneakyThrows;
import org.redisson.Redisson;
import org.redisson.RedissonMultiLock;
import org.redisson.RedissonRedLock;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * <Description>
 *
 * @author hushiye
 * @since 12/2/21 10:11
 */
public class RedisUtils {
    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private static RedisUtils redisUtils;

    private RedisUtils() {
    }

    /**
     * 提供单例模式
     *
     * @return
     */
    public static RedisUtils getInstance() {
        if (redisUtils == null)
            synchronized (RedisUtils.class) {
                if (redisUtils == null)
                    redisUtils = new RedisUtils();
            }
        return redisUtils;
    }

    /**
     * 使用config创建Redisson Redisson是用于连接Redis Server的基础类
     *
     * @param config
     * @return
     */
    public RedissonClient getRedisson(Config config) {
        RedissonClient redisson = Redisson.create(config);
        logger.info("成功连接Redis Server");
        return redisson;
    }

    /**
     * 使用ip地址和端口创建Redisson
     *
     * @param ip
     * @param port
     * @return
     */
    public RedissonClient getRedisson(String ip, String port) {
        Config config = new Config();
        config.useSingleServer().setAddress(ip + ":" + port);
        RedissonClient redisson = Redisson.create(config);
        logger.info("成功连接Redis Server" + "\t" + "连接" + ip + ":" + port + "服务器");
        return redisson;
    }

    /**
     * 关闭Redisson客户端连接
     *
     * @param redisson
     */
    public void closeRedisson(RedissonClient redisson) {
        redisson.shutdown();
        logger.info("成功关闭Redis Client连接");
    }

    /**
     * 获取字符串对象
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public <T> RBucket<T> getRBucket(RedissonClient redisson, String objectName) {
        RBucket<T> bucket = redisson.getBucket(objectName);
        return bucket;
    }

    /**
     * 获取Map对象
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public <K, V> RMap<K, V> getRMap(RedissonClient redisson, String objectName) {
        RMap<K, V> map = redisson.getMap(objectName);
        return map;
    }

    /**
     * 获取有序集合
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public <V> RSortedSet<V> getRSortedSet(RedissonClient redisson,
                                           String objectName) {
        RSortedSet<V> sortedSet = redisson.getSortedSet(objectName);
        return sortedSet;
    }

    /**
     * 获取集合
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public <V> RSet<V> getRSet(RedissonClient redisson, String objectName) {
        RSet<V> rSet = redisson.getSet(objectName);
        return rSet;
    }

    /**
     * 获取列表
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public <V> RList<V> getRList(RedissonClient redisson, String objectName) {
        RList<V> rList = redisson.getList(objectName);
        return rList;
    }

    /**
     * 获取队列
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public <V> RQueue<V> getRQueue(RedissonClient redisson, String objectName) {
        RQueue<V> rQueue = redisson.getQueue(objectName);
        return rQueue;
    }

    /**
     * 获取双端队列
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public <V> RDeque<V> getRDeque(RedissonClient redisson, String objectName) {
        RDeque<V> rDeque = redisson.getDeque(objectName);
        return rDeque;
    }

    /**
     * 此方法不可用在Redisson 1.2 中 在1.2.2版本中 可用
     *
     * @param redisson
     * @param objectName
     * @return
     */
    /**
     * public <V> RBlockingQueue<V> getRBlockingQueue(RedissonClient
     * redisson,String objectName){ RBlockingQueue
     * rb=redisson.getBlockingQueue(objectName); return rb; }
     */

    /**
     * 获取锁
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public RLock getRLock(RedissonClient redisson, String objectName) {
        RLock rLock = redisson.getLock(objectName);
        return rLock;
    }

    /**
     * 获取原子数
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public RAtomicLong getRAtomicLong(RedissonClient redisson, String objectName) {
        RAtomicLong rAtomicLong = redisson.getAtomicLong(objectName);
        return rAtomicLong;
    }

    /**
     * 获取记数锁
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public RCountDownLatch getRCountDownLatch(RedissonClient redisson,
                                              String objectName) {
        RCountDownLatch rCountDownLatch = redisson
                .getCountDownLatch(objectName);
        return rCountDownLatch;
    }

    /**
     * 获取消息的Topic
     *
     * @param redisson
     * @param objectName
     * @return
     */
    public <M> RTopic getRTopic(RedissonClient redisson, String objectName) {
        RTopic rTopic = redisson.getTopic(objectName);
        return rTopic;
    }


    public static void main(String[] args) throws InterruptedException {


//        testFairLock();
//        testFairLock2();
//        testReadLock();
//        testWriteLock();


//        testReadAndWrite();

//        testRedissonMultiLock();

        testRedLock();

    }

    private static void testRedLock() {
        RedissonClient redisson = getRedisson();
        RLock rLock = redisson.getReadWriteLock("test").readLock();
        RLock rLock1 = redisson.getFairLock("test1");
        RLock rLock2 = redisson.getLock("test2");
        RedissonRedLock redissonRedLock = new RedissonRedLock(rLock,rLock1,rLock2);
        redissonRedLock.lock();

        while (true){

        }
    }

    private static void testRedissonMultiLock() {
        RedissonClient redisson = getRedisson();
        RLock rLock = redisson.getReadWriteLock("test").readLock();
        RLock rLock1 = redisson.getFairLock("test1");
        RLock rLock2 = redisson.getLock("test2");

        RLock redissonMultiLock = redisson.getMultiLock(rLock,rLock1,rLock2);
        redissonMultiLock.lock();

        while (true){

        }


    }

    private static void testReadAndWrite() {

        RedissonClient redisson = getRedisson();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {

                    RReadWriteLock rLock = redisson.getReadWriteLock("test");
                    RLock readLock = rLock.readLock();
                    readLock.lock();
                    Thread.sleep(10000);
                    readLock.unlock();
                }
            });
            t.start();
        }

        Thread t = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

                RReadWriteLock rLock = redisson.getReadWriteLock("test");
                RLock readLock = rLock.writeLock();
                readLock.lock();
            }
        });
        t.start();
        t.interrupt();


        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

                RReadWriteLock rLock = redisson.getReadWriteLock("test");
                RLock readLock = rLock.writeLock();
                readLock.lock();
                while (true) {

                }
            }
        });
        t1.start();
        while (true) {


        }


    }

    private static void testWriteLock() {
        RedissonClient redisson = getRedisson();
        RReadWriteLock rLock = redisson.getReadWriteLock("test");
        RLock writeLock = rLock.writeLock();
        writeLock.lock();

        rLock.readLock().lock();


        while (true) {

        }


    }

    private static void testReadLock() {

//        RReadWriteLock rLock = redisson.getReadWriteLock("test");
//        RLock readLock = rLock.readLock();
//        readLock.lock();
//        readLock.lock();
//        readLock.unlock();
//        while (true) {
//
//        }
        RedissonClient redisson = getRedisson();
        RReadWriteLock rLock = redisson.getReadWriteLock("test");
        RLock readLock = rLock.readLock();
        readLock.lock();
        readLock.lock();
        readLock.unlock();

//
//        RedissonClient redisson = getRedisson();
//        for (int i = 0; i < 10; i++) {
//
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                    RReadWriteLock rLock = redisson.getReadWriteLock("test");
//                    RLock readLock = rLock.readLock();
//                    readLock.lock();
//                    while (true){
//
//                    }
//                }
//            });
//            t.start();
//        }
//
//        while (true){
//
//        }


    }

    private static void testFairLock2() {
        RedissonClient redisson = getRedisson();
        RLock rLock = redisson.getFairLock("test");
        rLock.lock();
        rLock.lock();
        rLock.unlock();
        while (true) {

        }
//        rLock.unlock();
    }

    private static void testFairLock() {
        RedissonClient redisson = getRedisson();

        for (int i = 0; i < 1; i++) {
            Thread thread = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
//                    print();

                    RLock rLock = redisson.getFairLock("test");
                    rLock.lock();
                    rLock.unlock();
                }
            });
            thread.setName(System.currentTimeMillis() / 1000 + "");
            thread.start();
        }
    }


    public static synchronized void print() {

        Jedis jedis = new Jedis("10.26.15.206", 6379);
        if (jedis.exists("redisson_lock_timeout:{test}")) {
            Set<String> keys = jedis.zrange("redisson_lock_timeout:{test}", 0, -1);
            for (String key : keys) {
                Double value = jedis.zscore("redisson_lock_timeout:{test}", key);
                System.out.println("key:" + key + ",score:" + (value.longValue()));
            }
        }
        System.out.println("--------------");


    }

    private static RedissonClient getRedisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://10.26.15.206:6379");
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}