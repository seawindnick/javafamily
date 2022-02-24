package com.study.basic;

/**
 * <Description>
 *
 * @author hushiye
 * @since 10/30/21 21:09
 */
public class Test {

    public static void main(String[] args) {


        for (int j = 0; j < 1000000; j++) {

            StringBuffer stringBuffer = new StringBuffer();

            for (int i = 0; i < 1000; i++) {
                stringBuffer.append(i);
//                new Thread(new TestBuffer(i, stringBuffer)).start();
            }


            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 1000; i++) {
                stringBuilder.append(i);
//                new Thread(new TestBuilder(i, stringBuilder)).start();
            }

            if (!stringBuffer.toString().equals(stringBuilder.toString())) {
                System.out.println(stringBuffer.toString());
                System.out.println(stringBuilder.toString());
                System.out.println("------------------");
            }
        }

    }


    public static class TestBuffer implements Runnable {

        private int i;
        private StringBuffer stringBuilder;

        public TestBuffer(int i, StringBuffer stringBuilder) {
            this.i = i;
            this.stringBuilder = stringBuilder;
        }

        @Override
        public void run() {
            stringBuilder.append(i);
        }
    }


    public static class TestBuilder implements Runnable {

        private int i;
        private StringBuilder stringBuilder;

        public TestBuilder(int i, StringBuilder stringBuilder) {
            this.i = i;
            this.stringBuilder = stringBuilder;
        }

        @Override
        public void run() {
            stringBuilder.append(i);
        }
    }
}
