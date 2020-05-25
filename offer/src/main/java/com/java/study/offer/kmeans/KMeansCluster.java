package com.java.study.offer.kmeans;

import java.util.*;

public abstract class KMeansCluster<T> {
    private List<T> dataList;//待分类的原始值

    private int k = 3;//将要分成的类别的个数

    private int maxClusterTimes = 500;//最大迭代次数

    private List<List<T>> clusterList;//聚类结果

    private Map<T,List<T>> clusterListMap;

    private List<T> clusterCenterList;//质心

    public int getK() {
        return k;
    }

    public Map<T, List<T>> getClusterListMap() {
        return clusterListMap;
    }

    public void setClusterListMap(Map<T, List<T>> clusterListMap) {
        this.clusterListMap = clusterListMap;
    }

    public void setK(int k) {
        if (k < 1) {
            throw new IllegalArgumentException("K must greater than 0");
        }
        this.k = k;
    }

    public int getMaxClusterTimes() {
        return maxClusterTimes;
    }

    public void setMaxClusterTimes(int maxClusterTimes) {
        if (maxClusterTimes < 10) {
            throw new IllegalArgumentException("maxClusterTimes must greater than 10");
        }
        this.maxClusterTimes = maxClusterTimes;
    }

    //对数据进行聚类
    public List<List<T>> clustering() {
        if (dataList == null) {
            return null;
        }

        int size = k > dataList.size() ? dataList.size() : k;


        List<T> centerList = new ArrayList<T>(size);
        Collections.shuffle(dataList);
        //选取打乱后的数据前k个质心
        for (int i = 0; i < size; i++) {
            centerList.add(dataList.get(i));
        }
        clustering(centerList, 0);
        return clusterList;
    }

    public List<T> getClusterCenterList() {
        return clusterCenterList;
    }

    public void setClusterCenterList(List<T> clusterCenterList) {
        this.clusterCenterList = clusterCenterList;
    }

    private void clustering(List<T> preCenter, int times) {
        if (preCenter == null || preCenter.size() < 2) {
            return;
        }

        Collections.shuffle(preCenter);

        List<List<T>> clusterList = getList(preCenter.size());

        for (T t : dataList) {
            int min = 0;
            double minScore = similarScore(t, preCenter.get(0));

            for (int i = 1; i < preCenter.size(); i++) {
                double tempScore = similarScore(t, preCenter.get(i));
                if (minScore > tempScore) {
                    minScore = tempScore;
                    min = i;
                }
            }
            clusterList.get(min).add(t);
        }


        if (times > maxClusterTimes || preCenter.size() < k) {
            this.clusterList = clusterList;
            return;
        }

        List<T> nowCenter = new ArrayList<>();
        Map<T,List<T>> tempMap = new HashMap<>();
        for (List<T> ts : clusterList) {
            T t = getCenter(ts);
            tempMap.put(t,ts);
            nowCenter.add(getCenter(ts));
        }
        this.clusterCenterList = nowCenter;

        if (!isCenterChange(preCenter, nowCenter)) {
            clear(clusterList);
            clustering(nowCenter, times + 1);
        } else {
            this.clusterList = clusterList;
            this.clusterListMap = tempMap;
        }

    }

    //判断质心是否发生变动
    private boolean isCenterChange(List<T> preCenter, List<T> nowCenter) {
        if (preCenter == null || nowCenter == null) {
            return Boolean.FALSE;
        }

        out:
        for (T t1 : preCenter) {
            for (T t2 : nowCenter) {
                //新旧质心列表存在同一个数据，说明质心未转移，继续判断下一个质心
                if (Objects.equals(t1, t2)) {
                    continue out;
                }
            }
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    private void clear(List<List<T>> clusterList) {
        clusterList.clear();
    }

    abstract T getCenter(List<T> ts);

    abstract double similarScore(T t, T t1);

    private List<List<T>> getList(int size) {
        List<List<T>> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
        }
        return list;
    }

    public void addRecord(T value){
        if (dataList == null){
            dataList = new ArrayList<>();
        }
        dataList.add(value);
    }
}
