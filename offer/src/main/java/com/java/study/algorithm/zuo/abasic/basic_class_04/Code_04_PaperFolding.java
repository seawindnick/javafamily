package com.java.study.algorithm.zuo.abasic.basic_class_04;

/**
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。
 * 此时 折痕是凹下去的，即折痕突起的方向指向纸条的背面。
 * 如果从纸条的下边向上方连续对折2 次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
 * 给定 个输入参数N，代表纸条都从下边向上方连续对折N次，请从上到下打印所有折痕的方向。 例如:N=1时，打印:
 * down
 * N=2时，打印:
 * down
 * down
 * up
 * <p>
 * TODO filter hushiye
 */
public class Code_04_PaperFolding {


    /**
     * 对一个点进行考察，其上面的点总是 down,下面的点总是up,然后进行递归处理
     *
     * @param N
     * @param level
     * @param downFlag
     */
    public static void PaperFolding(int N, int level, Boolean downFlag) {
        if (N > level) {
            return;
        }

        PaperFolding(N + 1, level, true);
        System.out.println(downFlag ? "down" : "up");
        PaperFolding(N + 1, level, false);
    }

    public static void main(String[] args) {
        PaperFolding(1, 4, true);

    }


}