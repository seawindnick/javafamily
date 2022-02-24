package leetCode;//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 1163 👎 0


import com.alibaba.fastjson.JSONArray;

//leetcode submit region begin(Prohibit modification and deletion)
public class L10283_MoveZeroes {
    public static void main(String[] args) {
        int[] array = new int[]{0,0,1};
        moveZeroes(array);
        System.out.println(JSONArray.toJSONString(array));
    }
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        int leftIndex = 0 ;int rightIndex = 0;
        while (rightIndex < nums.length){
            if (nums[rightIndex] != 0){
                int temp = nums[rightIndex];
                nums[rightIndex] = nums[leftIndex];
                nums[leftIndex] = temp;

                leftIndex++;
            }
            rightIndex++;
        }
    }
}


