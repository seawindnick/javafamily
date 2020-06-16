package com.java.study.chapter10.moneylock;

import lombok.Data;

public class MoneyLock {


    public void transferMoney(String fromAccount,String toAccount,Double amount){
        synchronized (fromAccount){
            synchronized (toAccount){
                //doSomething
            }
        }
    }


    private static final Object tieLock = new Object();
    public void transferMoney(Amount fromAccount,Amount toAccount,Double amount){
        int fromHash = System.identityHashCode(fromAccount);
        int toHash = System.identityHashCode(toAccount);
        if (fromHash < toHash){
            synchronized (fromAccount){
                synchronized (toAccount){
                    //doSomething
                }
            }
        }else if (fromHash > toHash){
            synchronized (toAccount){
                synchronized (fromAccount){
                    //doSomething
                }
            }
        }else {
            synchronized (tieLock){
                synchronized (fromAccount){
                    synchronized (toAccount){
                        //doSomething
                    }
                }
            }
        }

    }




    @Data
    public static class Amount{
        private Double balance;

        public void debit(Double amount) {
        }

        public void credit(Double amount) {
        }
    }

}
