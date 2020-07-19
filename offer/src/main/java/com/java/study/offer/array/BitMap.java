package com.java.study.offer.array;

import com.alibaba.fastjson.JSONArray;

public class BitMap {
    private long[] words;
    private int size;

    public BitMap(int size) {
        this.size = size;
        this.words = new long[getWordIndex(size - 1) + 1];
    }

    private int getWordIndex(int bitIndex) {
        //除以64
        return bitIndex >> 6;
    }


    /**
     * 判断某一位的状态
     *
     * @param bitIndex
     * @return
     */
    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超出有效范围");
        }

        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1 << bitIndex)) != 0;
    }

    /**
     * 某一位设置为true
     *
     * @param bitIndex
     */
    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超出有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] = words[wordIndex] | (1 << bitIndex);

    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(128);
        bitMap.setBit(0);
        bitMap.setBit(1);
        bitMap.setBit(2);
        bitMap.setBit(3);


        BitMap bitMap2 = new BitMap(6);
        bitMap2.setBit(1);
        bitMap2.setBit(2);
        bitMap2.setBit(3);
        bitMap2.setBit(4);
        long result = (bitMap.words[0] & bitMap2.words[0]);
        System.out.println(result);

        int index = 0;
        long startValue = bitMap2.words[0];
        while (startValue != 0){
            if ((startValue & 1) == 1){
                System.out.println(index);
            }
            startValue = startValue >> 1;
            index ++;
        }
    }


}
