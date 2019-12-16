package com.java.study.redis.hyperloglog;

import redis.clients.jedis.Jedis;

public class HyperLogLog {


    public static void main(String[] args) {
        Jedis jedis = new Jedis("118.24.208.119");
        for (int i = 0; i < 500; i++) {
            jedis.pfadd("codeHole1", "user" + i);
//            long total = jedis.pfcount("codeHole");
//            if (total != i + 1) {
//                System.out.printf("%d %d\n", total, i + 1);
//                break;
//            }

        }
        long total = jedis.pfcount("codeHole1");
        System.out.println(total);
        jedis.close();

    }


}
