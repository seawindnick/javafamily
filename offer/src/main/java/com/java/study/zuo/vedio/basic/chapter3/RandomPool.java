package com.java.study.zuo.vedio.basic.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-22 15:09
 */
public class RandomPool {

    public static class RandomPoolObject<T> {
        private Map<Integer, T> indexAndEntityMap = new HashMap<>();
        private Map<T, Integer> entityAndIndexMap = new HashMap<>();
        private int size = 0;

        public void add(T value) {
            if (!entityAndIndexMap.containsKey(value)) {
                entityAndIndexMap.put(value, size);
                indexAndEntityMap.put(size, value);
                size++;
            }
        }

        public void delete(T value) {
            if (entityAndIndexMap.containsKey(value)) {
                Integer oldIndex = entityAndIndexMap.get(value);

                T lastEntity = indexAndEntityMap.get(--size);
                entityAndIndexMap.put(lastEntity, oldIndex);
                indexAndEntityMap.put(oldIndex, lastEntity);

                entityAndIndexMap.remove(value);
                indexAndEntityMap.remove(size);
            }
        }

        public T getRandom() {
            int randomIndex = (int) (Math.random() * this.size);
            return indexAndEntityMap.get(randomIndex);
        }
    }


    public static void main(String[] args) {
        RandomPoolObject<String> pool = new RandomPoolObject<String>();
        pool.add("zuo");
        pool.add("cheng");
        pool.add("yun");
        pool.delete("zuo");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }

}
