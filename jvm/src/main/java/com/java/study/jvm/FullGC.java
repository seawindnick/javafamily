package com.java.study.jvm;

/**
 * <Description>
 *
 * @author hushiye
 * @since 6/22/21 22:33
 */
public class FullGC {
//    /**
//     * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
//     * <p>
//     * <p>
//     * -XX:NewSize=10M -XX:MaxNewSize=10M -XX:InitialHeapSize=20M -XX:MaxHeapSize=20M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc_full.log
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
//        byte[] arr = new byte[4 * 1024 * 1024];
//        arr = null;
//
//        byte[] arr2 = new byte[2 * 1024 * 1024];
//        byte[] arr3 = new byte[2 * 1024 * 1024];//第一次young gc 剩余 arr2 2M对象进入老年代，年轻代 2M对象
//        byte[] arr4 = new byte[2 * 1024 * 1024];//年轻代 4M 老年代2M
//        byte[] arr5 = new byte[128 * 1024];
//        byte[] arr6 = new byte[2 * 1024 * 1024];//年轻代6M 老年代2M
//
//    }

    /**
     * -XX:NewSize=10M -XX:MaxNewSize=10M -XX:InitialHeapSize=20M -XX:MaxHeapSize=20M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=4M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc_full.log
     */

    public static void main(String[] args) {
        byte[] arr = new byte[4 * 1024 * 1024];//直接进入老年代4M
        arr = null;

        byte[] arr2 = new byte[2 * 1024 * 1024];//年轻代2M
        byte[] arr3 = new byte[2 * 1024 * 1024];//年轻代2M
        byte[] arr4 = new byte[2 * 1024 * 1024];//年轻代2M
        byte[] arr5 = new byte[128 * 1024];

        byte[] arr6 = new byte[2 * 1024 * 1024];//执行minorGc, 6.128M 需要进入老年代，已经有4M老年代，不足执行full gc,full Gc之后，老年代 6.128M  年轻代2M


        /**
         *
         *
         * 0.100: [GC (Allocation Failure) 0.100: [ParNew (promotion failed): 8147K->8729K(9216K), 0.0030232 secs]0.103: [CMS: 8194K->6679K(10240K), 0.0031759 secs] 12243K->6679K(19456K), [Metaspace: 3249K->3249K(1056768K)], 0.0063183 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
         *
         *
         * Heap
         *  par new generation   total 9216K, used 2213K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   eden space 8192K,  27% used [0x00000007bec00000, 0x00000007bee297b8, 0x00000007bf400000)
         *   from space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
         *   to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
         *  concurrent mark-sweep generation total 10240K, used 6679K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *  Metaspace       used 3262K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 358K, capacity 388K, committed 512K, reserved 1048576K
         *
         *
         *
         *
         */
    }


}
