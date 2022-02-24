package leetCode;//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//
//
// 示例 1：
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
//
//
// 示例 2：
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
//
//
// 示例 3：
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
//
//
// 示例 4：
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
//
// Related Topics 栈 递归 字符串
// 👍 841 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class L10394_DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int startIndex = 0;
        DecodeStringResult decodeStringResult = decodeString(s, startIndex);
        return decodeStringResult.result;
    }

    private static DecodeStringResult decodeString(String s, int startIndex) {
        DecodeStringResult decodeStringResult = new DecodeStringResult();
        if (startIndex >= s.length()) {
            decodeStringResult.result = "";
            decodeStringResult.endIndex = s.length();
            return new DecodeStringResult();
        }

        String str = "";
        Integer repeatCount = 0;
        while (startIndex <= s.length() - 1) {
            char indexChar = s.charAt(startIndex);
            if ('0' <= indexChar && indexChar <= '9') {
                repeatCount = repeatCount * 10 + (indexChar - '0');
            } else {
                if (indexChar == '[') {
                    //找到下一个 ']'位置
                    DecodeStringResult afterDecodeResult = decodeString(s, startIndex + 1);
                    //找到之后，追加值
                    String appendString = "";
                    for (int i = 0; i < repeatCount; i++) {
                        appendString = appendString + afterDecodeResult.result;
                    }
                    repeatCount = 0;
                    str = str + appendString;
                    startIndex = afterDecodeResult.endIndex;
                    continue;
                } else if (indexChar == ']') {
                    decodeStringResult.result = str;
                    decodeStringResult.endIndex = startIndex + 1;
                    return decodeStringResult;

                } else {
                    str = str + indexChar;
                }
            }
            startIndex++;
        }

        decodeStringResult.result = str;
        decodeStringResult.endIndex = startIndex + 1;
        return decodeStringResult;

    }

    public static class DecodeStringResult {
        String result;
        int endIndex;
    }
}


