package com.java.study.jvm;

/**
 * <Description>
 * 动态年龄测试
 *
 * @author hushiye
 * @since 6/20/21 22:49
 */
public class AutoAgeTest {

    /**
     * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
     * <p>
     * <p>
     * -XX:NewSize=10M -XX:MaxNewSize=10M -XX:InitialHeapSize=20M -XX:MaxHeapSize=20M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
     *
     * @param args
     */
//    public static void main(String[] args) {
//        byte[] array = new byte[2 * 1024 * 1024];
//        array = new byte[2 * 1024 * 1024];
//        array = new byte[2 * 1024 * 1024];
//        array = null;
//
//        byte[] arr = new byte[128 * 1024];
//        byte[] array2 = new byte[2 * 1024 * 1024];
//
//
//        /**
//         *
//         *
//         *
//         *
//         *  执行 byte[] array2 = new byte[2 * 1024 * 1024]; 时进行yong GC
//         CommandLine flags: -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:MaxTenuringThreshold=15 -XX:NewSize=10485760 -XX:OldPLABSize=16 -XX:PretenureSizeThreshold=10485760 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:SurvivorRatio=8 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseConcMarkSweepGC -XX:+UseParNewGC
//         0.092: [GC (Allocation Failure) 0.092: [ParNew: 7981K->552K(9216K), 0.0006999 secs] 7981K->552K(19456K), 0.0007954 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
//
//
//         ParNew:7981K->552K(9216K)
//         新生代总内存 Eden 区 8M + 一个 S 区 1M = 9M = 9216K
//         此时Eden区已有对象
//         byte[]  arr1 = 2M 无引用
//         byte[]  arr2 = 2M 无引用
//         byte[]  arr3 = 2M 有无引用
//         byte[]  arr4 = 128K 有引用
//
//         此时Eden区总共有对象 6.128M 加上其他信息 与 7981K 大致相同
//
//         标记清理之后 剩余 arr4 0.128M 有用对象
//         年轻代刚开始有512KB左右未知对象，因此剩余对象大约 552Kb
//
//
//         7981K->552K(19456K)
//         19456K = 老年代 10M+年轻代 9M = 19M
//         7981K 为老年代，年轻代所有对象信息
//         552K 为清理后对象信息
//
//
//         Heap
//         par new generation   total 9216K, used 2764K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
//         此时年轻代对象为 2M + 128KB + 512KB未对象
//
//
//         eden space 8192K,  27% used [0x00000007bec00000, 0x00000007bee290f0, 0x00000007bf400000)
//         Eden区为 2M 数组
//
//         from space 1024K,  53% used [0x00000007bf500000, 0x00000007bf58a288, 0x00000007bf600000)
//         from 区为 128KB+512KB未知对象，年龄1岁
//
//         to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
//         concurrent mark-sweep generation total 10240K, used 0K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
//         Metaspace       used 3170K, capacity 4496K, committed 4864K, reserved 1056768K
//         class space    used 348K, capacity 388K, committed 512K, reserved 1048576K
//
//         */
//    }
//

    /**
     * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
     * <p>
     * <p>
     * -XX:NewSize=10M -XX:MaxNewSize=10M -XX:InitialHeapSize=20M -XX:MaxHeapSize=20M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] array = new byte[2 * 1024 * 1024];
        array = new byte[2 * 1024 * 1024];
        array = new byte[2 * 1024 * 1024];
        array = null;

        byte[] arr = new byte[128 * 1024];
        byte[] array2 = new byte[2 * 1024 * 1024];

        array2 = new byte[2 * 1024 * 1024];
        array2 = new byte[2 * 1024 * 1024];
        array2 = new byte[256 * 2 * 1024];
        array2 = null;

        byte[] array3 = new byte[3 * 1024 * 1024];


        /**
         *
         *
         *
         * CommandLine flags: -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:MaxTenuringThreshold=15 -XX:NewSize=10485760 -XX:OldPLABSize=16 -XX:PretenureSizeThreshold=10485760 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:SurvivorRatio=8 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseConcMarkSweepGC -XX:+UseParNewGC
         * 0.100: [GC (Allocation Failure) 0.100: [ParNew: 7981K->567K(9216K), 0.0006453 secs] 7981K->567K(19456K), 0.0007184 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
         * 0.101: [GC (Allocation Failure) 0.101: [ParNew: 6952K->228K(9216K), 0.0032586 secs] 6952K->767K(19456K), 0.0034128 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
         *
         *  执行 array3 = new byte[2 * 1024 * 1024];发生yonggc
         *
         *  此时 S区有 128KB+512KB
         *  Eden 区有
         *   byte[] array2 = new byte[2 * 1024 * 1024];  无引用
         *   array2 = new byte[2 * 1024 * 1024]; 无引用
         *   array2 = new byte[2 * 1024 * 1024]; 无引用
         *   array2 = new byte[128 * 1024] 无引用;
         *   共 6M+128KB 对象
         *
         *   进行yonggc之后 剩余对象为  arr = new byte[128 * 1024]
         *
         *   此时Eden区剩余对象 228K ， S区对象 567K
         *
         *   进入S区之后 年龄一(228K) + 年龄二(567K)超过50%
         *   大于年龄二的进入老年代，约538K 对象进入老年代
         *
         *
         *
         *
         * Heap
         *  par new generation   total 9216K, used 2413K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   eden space 8192K,  26% used [0x00000007bec00000, 0x00000007bee22380, 0x00000007bf400000)
         *   from space 1024K,  22% used [0x00000007bf400000, 0x00000007bf439148, 0x00000007bf500000)
         *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
         *  concurrent mark-sweep generation total 10240K, used 538K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *  Metaspace       used 3244K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 355K, capacity 388K, committed 512K, reserved 1048576K
         *
         *
         */


    }


//    /**
//     * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
//     * <p>
//     * <p>
//     * -XX:NewSize=10M -XX:MaxNewSize=10M -XX:InitialHeapSize=20M -XX:MaxHeapSize=20M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
//        byte[] array = new byte[2 * 1024 * 1024];
//        array = new byte[2 * 1024 * 1024];
//        array = new byte[2 * 1024 * 1024];
//        array = null;
//
//        byte[] arr = new byte[128 * 1024];
//        byte[] array2 = new byte[2 * 1024 * 1024];
//        array2 = new byte[2 * 1024 * 1024];
//        array2 = new byte[2 * 1024 * 1024];
//        array2 = new byte[128 * 1024];
//        array2 = null;
//
//        byte[] array3 =new byte[2 * 1024 * 1024];
//
//
//    }
}
