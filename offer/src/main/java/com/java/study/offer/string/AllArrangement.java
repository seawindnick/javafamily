package com.java.study.offer.string;

public class AllArrangement {

    public static void main(String[] args) {
        String[] a = {"A", "B", "C"};
        for (int i = 1; i <= a.length; i++) {
            System.out.println(a.length + "选" + i);
            String[] res = new String[i];
            combine(a, 0, res, 0);
        }
    }


    /**
     *
     * @param array 字符集
     * @param a_pos 开始位置
     * @param rs 结果数组
     * @param rs_pos 数据实际应该填充元素的角标位置
     */
    final static public void combine(final String[] array, final int a_pos, final Object rs[], final int rs_pos) {
        if (rs_pos >= rs.length) {
            for (int i = 0; i < rs.length; i++) {
                System.out.print(rs[i] + " ");
            }
            System.out.println();
        } else {
            for (int ap = a_pos; ap < array.length; ap++) {
                // 使用当前角标元素信息，填充结果集对应的位置
                rs[rs_pos] = array[ap];
                //从下一个角标后的数据中获取元素进行填充
                combine(array, ap + 1, rs, rs_pos + 1);
            }
        }
    }
}
