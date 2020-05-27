package com.java.study.chapter3;

public class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void  setN(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n) {
            throw new RuntimeException("this statement is false");
        }
    }


    public static void main(String[] args) {
        Holder holder = new Holder(-1);
        new ChangeThread(holder).start();
        new SearchThread(holder).start();
    }

    public static class ChangeThread extends Thread {
        private Holder holder;

        public ChangeThread(Holder holder) {
            this.holder = holder;
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                holder.setN(i);
                i++;
            }
        }
    }

    public static class SearchThread extends Thread {
        private Holder holder;

        public SearchThread(Holder holder) {
            this.holder = holder;
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    holder.assertSanity();
                    i++;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println(i);
                    return;
                }
            }

        }
    }
}
