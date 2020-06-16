package com.java.study.chapter14;

public class ConditionBoundBufferTest {

    public static void main(String[] args) throws InterruptedException {
        ConditionBoundBuffer conditionBoundBuffer = new ConditionBoundBuffer();
        conditionBoundBuffer.take();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ConditionBoundBufferTask(conditionBoundBuffer));
            thread.setName("线程:" + i);
            thread.start();
        }

    }


    private static class ConditionBoundBufferTask implements Runnable {
        private ConditionBoundBuffer conditionBoundBuffer;

        public ConditionBoundBufferTask(ConditionBoundBuffer conditionBoundBuffer) {
            this.conditionBoundBuffer = conditionBoundBuffer;
        }

        @Override
        public void run() {
            try {
                conditionBoundBuffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
