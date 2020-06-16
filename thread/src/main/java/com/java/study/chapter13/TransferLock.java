package com.java.study.chapter13;

import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TransferLock {
    public boolean transferMoney(Account fromAcct, Account toAcct, Double amount, long timeout, TimeUnit unit){

        while (true){
            if (fromAcct.getReentrantLock().tryLock()){
                try {
                    if (toAcct.getReentrantLock().tryLock()){
                        try{

                        }finally {
                            toAcct.getReentrantLock().unlock();
                        }
                    }
                }finally {
                    fromAcct.getReentrantLock().unlock();
                }
            }
        }

    }



    @Data
    public class Account{
        private ReentrantLock reentrantLock = new ReentrantLock();

        public ReentrantLock getReentrantLock() {
            return reentrantLock;
        }

        public void setReentrantLock(ReentrantLock reentrantLock) {
            this.reentrantLock = reentrantLock;
        }
    }

}
