package com.java.study.redis.limiter;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
public class TokenBucket {

    private static final int DEFAULT_BUCKET_SIZE = 1024 * 1024 * 64;//令牌桶大小
    private int everyTokenSize = 1;//平均每个令牌大小
    private int maxFlowRate;//最大速率
    private int avgFlowRate;//平均速率
    private ArrayBlockingQueue<Byte> tokenQueen = new ArrayBlockingQueue<Byte>(DEFAULT_BUCKET_SIZE);//令牌队列

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();//定时任务
    private volatile boolean isStart = false;
    private ReentrantLock reentrantLock = new ReentrantLock(true);//加锁
    private static final Byte A_CHAR = 'a';//放入令牌桶的信息

    /**
     * 添加令牌
     */
    private void addTokens() {
        for (int i = 0; i < avgFlowRate; i++) {
            tokenQueen.offer(A_CHAR);
        }
    }

    public TokenBucket build() {
        start();
        return this;
    }

    public void start() {
        //初始化桶大小
        if (maxFlowRate != 0) {
            tokenQueen = new ArrayBlockingQueue<>(maxFlowRate);
        }

        //启动添加令牌任务
        TokenProducer tokenProducer = new TokenProducer(this);
        scheduledExecutorService.scheduleAtFixedRate(tokenProducer, 0, 1, TimeUnit.SECONDS
        );
        isStart = true;
    }


    public void stop() {
        isStart = false;
        scheduledExecutorService.shutdown();
    }

    class TokenProducer implements Runnable {
        private TokenBucket tokenBucket;

        public TokenProducer(TokenBucket tokenBucket) {
            this.tokenBucket = tokenBucket;
        }

        @Override
        public void run() {
            tokenBucket.addTokens();
        }
    }

    public static TokenBucket newBuilder() {
        return new TokenBucket();
    }

    public TokenBucket everyTokenSize(int everyTokenSize) {
        this.everyTokenSize = everyTokenSize;
        return this;
    }

    public TokenBucket maxFlowRate(int maxFlowRate) {
        this.maxFlowRate = maxFlowRate;
        return this;
    }

    public TokenBucket avgFlowRate(int avgFlowRate) {
        this.avgFlowRate = avgFlowRate;
        return this;
    }

    //判断是否获取都令牌
    public boolean getTokens(byte[] dataSize) {
        int needTokenNum = dataSize.length / everyTokenSize + 1;//获取需要的令牌数
        final ReentrantLock reentrantLock = this.reentrantLock;
        reentrantLock.lock();
        try {
            //判断需要的令牌数量是否小于等于令牌桶已有的数量
            boolean result = needTokenNum <= tokenQueen.size();
            if (!result) {
                return false;
            }
            int tokenCount = 0;
            for (int i = 0; i < needTokenNum; i++) {
                Byte poll = tokenQueen.poll();//令牌桶移除相应数量的令牌
                if (poll != null) {
                    tokenCount++;
                }
            }
            return tokenCount == needTokenNum;
        } finally {
            reentrantLock.unlock();
        }
    }


    public static void main(String[] args) {
        TokenBucket tokenBucket = TokenBucket.newBuilder().avgFlowRate(100).maxFlowRate(128).everyTokenSize(1).build();
        String data = "12345";
        for (int i = 1; i <= 1000; i++) {
            boolean tokens = tokenBucket.getTokens(data.getBytes());
            if (tokens) {
                System.out.println("获得令牌信息" + i);
            } else {
                System.out.println("没有获得令牌信息" + i);
            }

        }
        tokenBucket.stop();
    }


}
