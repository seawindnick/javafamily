package com.study;

import org.junit.Test;

/**
 * <Description>
 *
 * @author hushiye
 * @since 1/22/22 16:11
 */
public class ThreadState {

    @Test
    public void test() throws InterruptedException {
//        testNew();
//        testRun();
//        testBlocked();
//        testWaiting();
        testTimedWaiting();
    }

    private void testTimedWaiting() {
        Runnable target;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadState.class){
                    try {
                        ThreadState.class.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getState());
        }
    }

    private void testWaiting() throws InterruptedException {
        Runnable target;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadState.class){
                    try {
                        ThreadState.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        while (true){
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }
    }

    private void testBlocked() throws InterruptedException {

        final Object obj = new Object();
        Runnable target;
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();

        Thread.sleep(100);

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread2.start();

        while (true){
            Thread.sleep(1000);
            System.out.println(thread2.getState());
        }




    }

    private void testNew() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        System.out.println(thread.getState());
    }

    private void testRun() throws InterruptedException {
        Runnable target = new Runnable() {
            @Override
            public void run() {
                int j = 0;
                for (int i = 0; i < 1000000; i++) {
                    j += i;
                }
            }
        };
        Thread thread = new Thread(target);
        thread.start();
        System.out.println(thread.getState());


    }


}
