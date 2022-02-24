package leetCode;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3928 👎 0

public class LongestPalindrome {


    public static void main(String[] args) {

//
        String result = longestPalindrome("babad");
        System.out.println(result);

    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        char[] arr = buildArray(s);

        int[] result = calculatePalindrome(arr);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = result[0] - result[1]; i <= result[0] + result[1]; i++) {
            if ((i & 1) == 1){
                stringBuilder.append(arr[i]);
            }
        }
        return stringBuilder.toString();
    }

    private static int[] calculatePalindrome(char[] arr) {
        int[] result = new int[arr.length];

        int centerIndex = -1;
        int r = -1;
        int maxValue = Integer.MIN_VALUE;

        int maxCenterIndex = Integer.MIN_VALUE;


        for (int i = 0; i < arr.length; i++) {
            result[i] = r > i ? Math.min(result[2 * centerIndex - i], r - i) : 1;

            while (i + result[i] < arr.length && (i - result[i]) > -1 && arr[i + result[i]] == arr[i - result[i]]) {
                result[i]++;
            }

            if (i + result[i] > r) {
                r = i + result[i];
                centerIndex = i;
            }

            if (result[i] > maxValue) {
                maxValue = Math.max(maxValue, result[i]);
                maxCenterIndex = i;
            }
        }

        return new int[]{maxCenterIndex, maxValue - 1};
    }


    private static char[] buildArray(String str) {
        char[] array = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (i & 1) == 0 ? '$' : str.charAt(index++);
        }
        return array;

    }

//    private static String longestPalindrome(String s) {
//        if (s == null || s.length() == 1) {
//            return s;
//        }
//
//        char[] arr = buildArray(s);
//
//        int[] result = calculatePalindrome(arr);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = result[0] - result[1]; i <= result[0] + result[1]; i++) {
//            if ((i & 1) == 1){
//                stringBuilder.append(arr[i]);
//            }
//        }
//        return stringBuilder.toString();
//    }
//
//    private static int[] calculatePalindrome(char[] arr) {
//        int[] result = new int[arr.length];
//
//        int centerIndex = -1;
//        int r = -1;
//        int maxValue = Integer.MIN_VALUE;
//
//        int maxCenterIndex = Integer.MIN_VALUE;
//
//
//        for (int i = 0; i < arr.length; i++) {
//            result[i] = r > i ? Math.min(result[2 * centerIndex - i], r - i) : 1;
//
//            while (i + result[i] < arr.length && (i - result[i]) > -1 && arr[i + result[i]] == arr[i - result[i]]) {
//                result[i]++;
//            }
//
//            if (i + result[i] > r) {
//                r = i + result[i];
//                centerIndex = i;
//            }
//
//            if (result[i] > maxValue) {
//                maxValue = Math.max(maxValue, result[i]);
//                maxCenterIndex = i;
//            }
//        }
//
//        return new int[]{maxCenterIndex, maxValue - 1};
//    }
//
//
//    private static char[] buildArray(String str) {
//        char[] array = new char[str.length() * 2 + 1];
//        int index = 0;
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (i & 1) == 0 ? '$' : str.charAt(index++);
//        }
//        return array;
//
//    }
//

}
