package com.java.study.redis.hyperloglog;


import java.util.concurrent.ThreadLocalRandom;

public class PfTest {

    static class BitKeeper {
        private int maxbits;

        public void random(long value) {
            int bits = lowZeros(value);
            if (bits > this.maxbits) {
                this.maxbits = bits;
            }
        }

        private int lowZeros(long value) {
            int i = 1;
            for (; i < 32; i++) {
                if (value >> i << i != value) {
                    break;
                }

            }
            return i - 1;
        }

    }

    static class Experiment {
        private int n;
        private int k;
        private BitKeeper[] keepers;

        public Experiment(int n) {
            this(n, 1024);
        }

        public Experiment(int n, int k) {
            this.n = n;
            this.k = k;
            this.keepers = new BitKeeper[k];
            for (int i = 0; i < k; i++) {
                keepers[i] = new BitKeeper();
            }
        }

        public void work() {
            for (int i = 0; i < this.n; i++) {
                long m = ThreadLocalRandom.current().nextLong(1L << 32);
                BitKeeper bitKeeper = keepers[(int) ((m & 0xfff000 >> 16) % keepers.length)];
                bitKeeper.random(m);
            }
        }


        public double estimate() {
            double submitsInverse = 0.0;
            for (BitKeeper keeper : keepers) {
                submitsInverse += 1.0 / (float) keeper.maxbits;

            }
            double avgBits = (float) keepers.length / submitsInverse;
            return Math.pow(2, avgBits) * this.k;
        }


    }


    public static void main(String[] args) {
        for (int i = 100000; i < 1000000; i += 10000) {
            Experiment experiment = new Experiment(i);
            experiment.work();
            double est = experiment.estimate();
            System.out.printf("%d %.2f %.2f\n", i, est, Math.abs(est - 1)/i);
        }
    }


}
