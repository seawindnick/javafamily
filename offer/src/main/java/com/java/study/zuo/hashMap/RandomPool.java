package com.java.study.zuo.hashMap;

import java.util.HashMap;
import java.util.Random;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-08-03 09:06
 */
public class RandomPool<T> {

    //数据的长度
    public int size;
    //角标与元素的对应关系
    private HashMap<Integer, T> indexMap;
    //元素与角标的对应关系
    private HashMap<T, Integer> entityMap;

    public RandomPool() {
        size = 0;
        indexMap = new HashMap<>();
        entityMap = new HashMap<>();
    }

    public void insert(T t) {
        if (entityMap.containsKey(t)) {
            return;
        }

        entityMap.put(t, size);
        indexMap.put(size++, t);
    }

    public void delete(T t) {
        if (entityMap.containsKey(t)) {
            Integer deleteIndex = entityMap.get(t);


            Integer lastIndex = --size;
            T lastKey = indexMap.get(lastIndex);

            //使用最后一个元素进行填充漏洞
            entityMap.put(lastKey, deleteIndex);
            indexMap.put(deleteIndex, lastKey);

            entityMap.remove(t);
            indexMap.remove(lastIndex);

        }
    }


    public T getRandom() {
        if (size == 0) {
            return null;
        }

        Integer randomInde = new Random().nextInt(size);
        return indexMap.get(randomInde);
    }

    public static void main(String[] args) {
        RandomPool<String> pool = new RandomPool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }


}
